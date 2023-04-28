package com.example.progression_student.helper;


import com.example.progression_student.entities.admin.Student_Details;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ExcelHelper {

    //In multipart data if it's an Excel file data it'll return true.
    //content type of Xlsx file :-application/vnd.openxmlformats-officedocument.spreadsheetml.sheet

    //check that file is of Excel type or not

    public static String Type = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public static boolean checkExcelFormat(MultipartFile multipartFile) {
        String contentType = multipartFile.getContentType();
        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }
    }

    //covert excel to list of students ----->
    public static List<Student_Details> covertExcelToListOfStudent(InputStream inputStream) throws Exception {
        List<Student_Details> list = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("data");

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    if (!checkHeader(row)) {
                        throw new Exception("Invalid Excel file format. Required columns are missing.");
                    }
                    ++rowNumber;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;
                Student_Details student_details = new Student_Details();
                boolean hasEmptyCell = false; // flag to check if any cell is empty

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    if (cell.getCellType() == CellType.BLANK) {
                        // If an empty cell is found, set the flag and move on to the next cell
                        System.out.println("Empty cell found in row " + (rowNumber + 1) + ", column " + cid);
                        hasEmptyCell = true;
                        continue;
                    }

                    switch (cid) {
                        case 0:
                            if (cell.getCellType() != CellType.NUMERIC) {
                                throw new Exception("Invalid Excel file format. Invalid data type in ID column.");
                            }
                            student_details.setId((int) cell.getNumericCellValue());//read in double
                            break;
                        case 1:
                            if (cell.getCellType() != CellType.STRING) {
                                throw new Exception("Invalid Excel file format. Invalid data type in Roll No column.");
                            }
                            student_details.setRoll_no(cell.getStringCellValue());
                            break;
                        case 2:
                            if (cell.getCellType() != CellType.STRING) {
                                throw new Exception("Invalid Excel file format. Invalid data type in Full Name column.");
                            }
                            student_details.setFull_name(cell.getStringCellValue());
                            break;
                        case 3:
                            if (cell.getCellType() != CellType.STRING) {
                                throw new Exception("Invalid Excel file format. Invalid data type in College ID column.");
                            }
                            student_details.setCollege_id(cell.getStringCellValue());
                            break;
                        case 4:
                            if (cell.getCellType() != CellType.STRING) {
                                throw new Exception("Invalid Excel file format. Invalid data type in Branch column.");
                            }
                            student_details.setBranch(cell.getStringCellValue());
                            break;
                        case 5:
                            if (cell.getCellType() != CellType.STRING) {
                                throw new Exception("Invalid Excel file format. Invalid data type in Batch column.");
                            }
                            student_details.setBatch(cell.getStringCellValue());
                            break;
                        case 6:
                            if (cell.getCellType() != CellType.STRING) {
                                throw new Exception("Invalid Excel file format. Invalid data type in Email ID column.");
                            }
                            student_details.setEmail_id(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;
                }

                // Add the student details to the list only if all the cells are non-empty
                if (cid == 7 && !hasEmptyCell) {
                    list.add(student_details);
                } else if (hasEmptyCell) {
                    throw new Exception("Invalid Excel file format. Empty cells found in row " + (rowNumber + 1));
                } else {
                    throw new Exception("Invalid Excel file format. Required columns are missing in row " + (rowNumber + 1));
                }
                ++rowNumber;
            }
        } catch (IOException e) {
            throw new Exception("Error reading Excel file.", e);
        }

        return list;
    }

        public static boolean checkHeader(Row row) {
        boolean valid = true;
        String[] headers = {"ID", "ROLL_NO", "FULL_NAME", "COLLEGE_ID", "BRANCH", "BATCH", "EMAIL_ID"};
        Iterator<Cell> cellIterator = row.iterator();
        int i = 0;
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            if (!cell.getStringCellValue().equalsIgnoreCase(headers[i])) {
                valid = false;
                break;
            }
            i++;
        }
        return valid;
    }

}
