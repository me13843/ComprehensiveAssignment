import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ReadAndWriteData 
{

    public static void main(String[] args) throws IOException 
    {
        String inputFile = System.getProperty("user.dir")+File.separator+"Input"+File.separator+"coursePriceDetails.xlsx";

        FileInputStream fileInputStream = new FileInputStream(new File(inputFile));
        
        XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = wb.getSheetAt(0);

        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
            
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) 
        {
            Row row = rowIterator.next();
            ArrayList<String> rowData = new ArrayList<String>();

            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) 
            {
                Cell cell = cellIterator.next();
                rowData.add(cell.toString());
            }
            data.add(rowData);
        }

        for (ArrayList<String> rowData : data) 
        {
            for (String cellData : rowData) 
            {
                System.out.print(cellData + "\t");
            }
            System.out.println();
        }

     } 
}
