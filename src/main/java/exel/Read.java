package exel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class Read {

    private String nameFile;
    private ArrayList<ArrayList<String>> table = new ArrayList<>();
    private ArrayList<ArrayList<String>> tableColumn = new ArrayList<>();

    public void readFile(String nemeFile) {
        this.nameFile = nemeFile + ".xlsx";

        try {
            FileInputStream file = new FileInputStream(nameFile);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("Лист1");

            for (int i = 0; i < sheet.getLastRowNum(); i ++) {
                XSSFRow row = sheet.getRow(i);

                ArrayList<String> stringTable = new ArrayList<>();
                ArrayList<String> stringTableColumn = new ArrayList<>();
                for (int j = 0; j < row.getLastCellNum(); j ++) {
                    XSSFCell cell = row.getCell(j);
                    switch (cell.getCellTypeEnum()){
                       // case _NONE:
                        case BLANK:
                            stringTable.add(null);
                            break;
                            // case ERROR:
                        case STRING:
                            stringTable.add(cell.getStringCellValue());
                            break;
                        case BOOLEAN:
                            stringTable.add(Boolean.toString(cell.getBooleanCellValue()));
                            break;
                       // case FORMULA:
                        case NUMERIC:
                            stringTable.add(Double.toString(cell.getNumericCellValue()));
                            break;
                    }

                    if (j == 4) {
                        stringTableColumn.add(cell.getStringCellValue());
                    }
                }
                table.add(stringTable);
                tableColumn.add(stringTableColumn);
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ArrayList<String>> getTable() {
        return table;
    }

    public ArrayList<ArrayList<String>> getTableColumn() {
        return tableColumn;
    }
}