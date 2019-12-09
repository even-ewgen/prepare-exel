package exel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Write {
    private String nameFile;
    ArrayList<ArrayList<String>> table;

    public Write(ArrayList<ArrayList<String>> table){
        this.table = table;
    }

    public void createFile(String tableName) {
        this.nameFile = tableName + " (new).xlsx";
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("1");

            Row rowTitle = sheet.createRow(0);

            for (int i = 0; i < table.get(0).size(); i ++) {
                rowTitle.createCell(i).setCellValue(table.get(0).get(i));
            }

            FileOutputStream out = new FileOutputStream(nameFile);
            new File(nameFile);
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write() {
        try {
            FileInputStream file = new FileInputStream(nameFile);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("1");

            for (int i = 1; i < table.size(); i ++) {
                ArrayList<String> rowTable = table.get(i);

                Row row = sheet.createRow(i);

                for (int j = 0; j < rowTable.size(); j++) {
                    row.createCell(j).setCellValue(rowTable.get(j));
                }
            }

            file.close();

            FileOutputStream updateFile =new FileOutputStream(new File(nameFile));
            workbook.write(updateFile);
            updateFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
