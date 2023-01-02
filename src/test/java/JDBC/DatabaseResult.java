package JDBC;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DatabaseResult extends JDBCParent {


    @Test
    public void test4() throws SQLException, IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Page1");

        ResultSet rs = statement.executeQuery("select first_name,\n" +
                "concat(left(first_name,2), repeat('*',length(first_name)-2)) as secretName,\n" +
                "concat(repeat('*',length(last_name)-2),right(last_name,2)) as secretLastName\n" +
                "from customer;");

        ResultSetMetaData rsmd = rs.getMetaData();

        Row newRow = sheet.createRow(0);
        for (int i = 0; i <= rsmd.getColumnCount() - 1; i++) {
            newRow.createCell(i).setCellValue(rsmd.getColumnName(i + 1));
            System.out.printf("%-30s", rsmd.getColumnName(i + 1));
        }

        System.out.println();

        int cnt = 1;
        while (rs.next())
        {
            newRow = sheet.createRow(cnt);
            for (int i = 0; i <= rsmd.getColumnCount() - 1; i++) {
                newRow.createCell(i).setCellValue(rs.getString(i + 1));
                System.out.printf("%-30s", rs.getString(i + 1));
            }
            cnt++;
            System.out.println();
        }


        String yeniExcelPath = "src/test/java/ResourcesExcel/NewExcelFile.xlsx";
        FileOutputStream outputStream = new FileOutputStream(yeniExcelPath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("Mission Complete");
    }


}
