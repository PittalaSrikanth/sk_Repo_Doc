package prop;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	public  static File file;
	public  static FileInputStream fis;
	public  static FileOutputStream fos;
	public  static Workbook wb;
	public  static Sheet sheet;
	
	
	public void ExcelRead(String filepath,String sheetName) throws IOException
	{
		file = new File(filepath);
		fis = new FileInputStream(file);
		String extension = filepath.substring(filepath.indexOf("."));
		if(extension.equals(".xlsx"))
		{
			System.out.println(fis);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(sheetName);
		}
		
		if(extension.equals(".xls"))
		{
			wb = new HSSFWorkbook(fis);
			sheet = wb.getSheet(sheetName);
		}
	}
	
	public int ExcelRowCount()
	{
		return sheet.getLastRowNum();
	}
	
	public int ExcelColoumCount()
	{
		return sheet.getRow(0).getLastCellNum();
	}
	
	public String GetCellData(int rowNo, int coloumNo)
	{		
		return sheet.getRow(rowNo).getCell(coloumNo).getStringCellValue();
	}
	
	public void setValue(int rowNo, int colNo,String value) throws IOException
	{
		sheet.getRow(rowNo).createCell(colNo).setCellValue(value);
		fis.close();
		fos = new FileOutputStream("C:\\Users\\spittala\\Desktop\\TestData.xlsx");
		wb.write(fos);
	}
}
