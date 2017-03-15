package Base;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

/**
 * Created by Kumar on 2/11/2017.
 */
public class DataHelper {

    public static List<HashMap<String,String>> data (String filepath, String sheetName)
    {
        List<HashMap<String,String>> mydata = new ArrayList<HashMap<String, String>>();

        try {
            FileInputStream fs = new FileInputStream(filepath);
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            Row HeaderRow = sheet.getRow(0);
            for(int i=1;i<sheet.getPhysicalNumberOfRows();i++) {
                Row currentRow = sheet.getRow(i);
                HashMap<String,String> currentHash = new HashMap<String, String>();
                for(int j=0;j<currentRow.getPhysicalNumberOfCells();j++)
                {
                    Cell currentCell = currentRow.getCell(j);
                    switch(currentCell.getCellType())
                    {
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(currentCell.getStringCellValue() + "\t");
                            currentHash.put(HeaderRow.getCell(j).getStringCellValue(),
                                    currentCell.getStringCellValue());
                            break;
                    }
                }
                mydata.add(currentHash);
            }
            fs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return mydata;
    }
}
