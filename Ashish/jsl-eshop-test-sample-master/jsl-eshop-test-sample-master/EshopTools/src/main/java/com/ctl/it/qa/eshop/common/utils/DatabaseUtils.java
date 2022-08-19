package com.ctl.it.qa.eshop.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ctl.it.qa.eshop.pages.OrderSummaryPage;
import com.ctl.it.qa.eshop.steps.OrderSummarySteps;
import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import net.serenitybdd.core.pages.WebElementFacade;

public class DatabaseUtils extends Page{

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return null;
	}

	/**
	 * Method to connect to a database 
	 */
	public Connection connect_To_Database(String databaseName){
		IntDataContainer dataContainer = commonData.getContainer(databaseName);
		String localhost = dataContainer.getFieldValue("localhost");
		String port = dataContainer.getFieldValue("port");
		String serviceName = dataContainer.getFieldValue("service_name");
		String username = dataContainer.getFieldValue("username");
		String password = dataContainer.getFieldValue("password");
		Connection con = null;
		String connectionString = "jdbc:oracle:thin:@"+localhost+":"+port+"/"+serviceName;
		System.out.println(connectionString);
		try{  
			// load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			System.out.println("---------------------------OracleDriver located now---------------------------");
			// create  the connection object  
			con = DriverManager.getConnection(connectionString,username,password);                                  
			System.out.println("---------------------------Connection established---------------------------");
		}
		catch(Exception e)
		{ 
			System.out.println(e.getMessage());                                       
		}
		return con;  
	}

	/**
	 * Oracle JDBC Connection method to fetch Paperless billing details based on Sequence Number of an order from Ensemble tables
	 */
	@SuppressWarnings("finally")
	public int fetch_Paperless_Billing_Details(String databaseName, String paperlessBillingValue, String bpSeqNo) throws SQLException{
		Connection con = connect_To_Database(databaseName);
		int noOfCopies = -1; 
		try{  
			// create the statement object  
			Statement stmt=con.createStatement();
			System.out.println("-------------------Now query will be executed---------------------------");
			// execute query
			String q1 = "select BP_BAN, BP_NO_OF_COPIES, BP_SEQ_NO from cuappc.billing_parameters where BP_BAN = '"+ OrderSummarySteps.accountnum;
			String q2 = "' and BP_SEQ_NO = '"+bpSeqNo+"'";
			String query =q1+q2;
			System.out.println(query);
			ResultSet rs=stmt.executeQuery(query);
			System.out.println("---------------------------Query Executed---------------------------");
			while(rs.next()){ 
				System.out.println(rs.getInt("BP_BAN")+"  "+rs.getInt("BP_NO_OF_COPIES")+"  "+rs.getInt("BP_SEQ_NO")); 
				noOfCopies = rs.getInt("BP_NO_OF_COPIES");
			}
		}
		catch(Exception e)
		{ 
			System.out.println(e.getMessage());                                       
		}  
		finally{
			// close the connection object
			System.out.println(" ---------------------------DB Connection will be closed---------------------------");
			con.close();
		}
		return noOfCopies;
		
	}

	/**
	 * Oracle JDBC Connection method to fetch Paperless billing email details based on BAN of an order from Ensemble tables
	 */
	public String fetch_Paperless_Billing_Email_Details(String databaseName) throws SQLException{
		Connection con = connect_To_Database(databaseName);
		String emailEnsemble = ""; 
		try{  
			// create the statement object  
			Statement stmt=con.createStatement();
			System.out.println("-------------------Now query will be executed---------------------------");
			// execute query
			String q1 = "select CPO_BAN, CPO_VALUE from cuappc.cpo_cust_info where CPO_BAN = '"+ OrderSummarySteps.accountnum;
			String q2 = "' and CPO_NAME = 'EMAIL_ADDRESS'";
			String query =q1+q2;
			System.out.println(query);
			ResultSet rs=stmt.executeQuery(query);
			System.out.println("---------------------------Query Executed---------------------------");
			while(rs.next()){ 
				System.out.println(rs.getString("CPO_BAN")+"  "+rs.getString("CPO_VALUE")); 
				emailEnsemble = rs.getString("CPO_VALUE");
			}
		}
		catch(Exception e)
		{ 
			System.out.println(e.getMessage());                                       
		}  
		finally{
			// close the connection object
			System.out.println(" ---------------------------DB Connection will be closed---------------------------");
			con.close();
		}
		return emailEnsemble;
	}
	
}
