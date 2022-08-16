package prop;

import java.io.IOException;

public class TestExcelFile 
{
public static void main(String[] args) throws IOException {
	ExcelReader r = new ExcelReader();
	r.ExcelRead("C:\\Users\\spittala\\Desktop\\TestData.xlsx", "Sheet1");
	System.out.println(r.ExcelRowCount());
	System.out.println(r.ExcelColoumCount());
	System.out.println(r.GetCellData(8, 1));
	r.setValue(11, 1, "Sk");
	
}
}
