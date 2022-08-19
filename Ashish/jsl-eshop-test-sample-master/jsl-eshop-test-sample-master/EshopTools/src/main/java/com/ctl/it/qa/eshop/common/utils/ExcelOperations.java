package com.ctl.it.qa.eshop.common.utils;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class ExcelOperations extends GlobalVariables {
	
	int colNumber;
	ExcelUtils excelUtils = new ExcelUtils();
	
	public void setDataAsPerScenario(String data) throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		currentRowNumber=excelUtils.getRowNumber(data);
		
			if(data.contains("LoginDetails")) {
			colNumber = excelUtils.getColumnNumber("Browser");
			ex_Browser= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber("EPPURL");
			ex_Url= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber("Username");
			ex_UserName= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber("Password");
			ex_Password= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber("Credit card");
			ex_CreditCardNumber= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber("SSN");
			ex_SSN= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber("MonthOfBirth");
			ex_Month= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber("DateOfBirth");
			ex_Date= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber("YearOfBirth");
			ex_Year= excelUtils.getCellData(currentRowNumber, colNumber);
			
			colNumber = excelUtils.getColumnNumber("TechRemarks");
			ex_TechRemarks= excelUtils.getCellData(currentRowNumber, colNumber);
		}
			
		
	}
	
	public void setDBAndEnvironmentValues(String environment) throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		excelUtils.openExcelFile(ExcelFile, envAndDBSheetName);
		
		envRowNumber=excelUtils.getRowNumber(environment);
		
		colNumber = excelUtils.getColumnNumber(colWSDL);
		ex_WSDL=excelUtils.getCellData(envRowNumber, colNumber);
	
		colNumber = excelUtils.getColumnNumber(colDBConnectionString);
		ex_DBConnectionString=excelUtils.getCellData(envRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colDBUserName);
		ex_DBUsername=excelUtils.getCellData(envRowNumber, colNumber);
		
		colNumber = excelUtils.getColumnNumber(colDBPassword);
		ex_DBPassword=excelUtils.getCellData(envRowNumber, colNumber);
		
	}
	
	//Write data into excel
	public void writeDataIntoExcel(String data,String columnName) throws Exception{
		
		excelUtils.openExcelFile(ExcelFile, tcSheetName);
		colNumber = excelUtils.getColumnNumber(columnName);
		excelUtils.setCellData(data,currentRowNumber,colNumber);
		
	}
	
}
