package com.org.mypac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseIntegration {

	public static void main(String[] args){

		Connection con = null;
		try {                                             // connection string
			 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root",
					"selenium");

			Statement stm = con.createStatement();

			ResultSet result = stm.executeQuery("select * from customers where customerNumber='129'");

			while (result.next()) {

				String first = result.getString("contactFirstName");
				String last = result.getString("contactLastName");
				System.out.println(first);
				System.out.println(last);

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

	}

}
