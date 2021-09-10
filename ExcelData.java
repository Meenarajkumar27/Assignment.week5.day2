package testcase;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelData {
	
	public static String[][] readdata(String Sheetname) throws IOException {
		// TODO Auto-generated method stub
		
		//open the work both with the path
XSSFWorkbook wb=new XSSFWorkbook("./Data/Lead.xlsx");
//open the worksheet
XSSFSheet ws=wb.getSheet(Sheetname);
int rowcount=ws.getLastRowNum();
int columncount=ws.getRow(0).getLastCellNum();
String[][] data =new String[rowcount][columncount];
for(int i=1;i<=rowcount;i++) {
	for(int j=0;j<columncount;j++) {
		String text=ws.getRow(i).getCell(j).getStringCellValue();
		System.out.println(text);
		data[i-1][j]=text;
	}
}
//get into the row
//XSSFRow row=ws.getRow(1);
////get into the cell
//XSSFCell cell=row.getCell(0);
////getthe value from the cell
//String data=cell.getStringCellValue();
//System.out.println(data);
//close the workbook
wb.close();
return data;

	}

}
