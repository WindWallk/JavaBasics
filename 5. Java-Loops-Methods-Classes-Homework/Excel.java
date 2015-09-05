import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Excel {
    public static void main(String[] args) throws IOException {
        try {
            FileInputStream excelFile = new FileInputStream("5. Incomes-Report.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            int rows = sheet.getPhysicalNumberOfRows();
            Map<String, Double> officesInfo = new TreeMap<>();

            for (int r = 1; r < rows; r++) {
                Row row = sheet.getRow(r);

                Cell officeCell = row.getCell(0);
                String office = officeCell.getStringCellValue();

                Cell totalIncomeCell = row.getCell(5);
                double income = totalIncomeCell.getNumericCellValue();

                if (!officesInfo.containsKey(office)) {
                    officesInfo.put(office, income);
                } else {
                    officesInfo.put(office, officesInfo.get(office) + income);
                }
            }

            double grandTotal = 0;

            for (Map.Entry<String, Double> entry : officesInfo.entrySet()) {
                String office = entry.getKey();
                Double totalIncome = entry.getValue();

                grandTotal += totalIncome;

                System.out.println(String.format("%s -> %.2f", office, totalIncome));
            }
            System.out.println(String.format("Grand Total -> %.2f", grandTotal));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
