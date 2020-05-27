package com.org.mypac;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hpsf.Array;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CommonUtill {

	public static Map<Integer, List<String>> excelRead() {
		Map<Integer, List<String>> rowValues= new HashMap<Integer, List<String>>();
		try {

			File f = new File("Resource/BookData.xlsx");
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook ex = new XSSFWorkbook(fis);
			XSSFSheet sheet = ex.getSheet("selenium");
			
			ArrayList<String> data = null;

			int numberOfCell = sheet.getRow(0).getPhysicalNumberOfCells();

			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) 
			{
				data = new ArrayList<>();
				for (int j = 0; j < numberOfCell; j++) {

					data.add(sheet.getRow(i).getCell(j).getStringCellValue());
				}
				rowValues.put(i, data);
			               //1, Admin	admin123	John Smith	John 	Test123	Test123
				           //2, Admin	admin123	Linda Anderson	Linda	Test123	Test123
				           //3, Admin	admin123	Russel Hamilton	Russel	Test123	Test123
				
				//Write functionality
				sheet.getRow(0).createCell(7).setCellValue("STATUS");
				sheet.getRow(i).createCell(7).setCellValue("Stored in Map");
				//1 , "Stored in Map"
				//2 , "Stored in Map"
				//3 , "Stored in Map"
				
			}
			
			FileOutputStream fos=new FileOutputStream(f);
			ex.write(fos);

		} catch (Exception e) {
			System.out.println("Something went wrong in excelRead()");
		}

		return rowValues;
	}

	
	public static List<String> databaseData()
	{
		List<String> dataDB= new ArrayList<>();
		Connection con = null;
		try {                                             // connection string
			 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root",
					"selenium");

			Statement stm = con.createStatement();

			ResultSet result = stm.executeQuery("select * from customers where customerNumber='129'");

			while (result.next()) {

				String firstName = result.getString("contactFirstName");
				String lastName = result.getString("contactLastName");
				System.out.println(firstName);
				System.out.println(lastName);
				
				dataDB.add(firstName);
				dataDB.add(lastName);

			}
		} catch (Exception e) {
			System.out.println("Connection not establised correcrtly");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dataDB;
	}
}
