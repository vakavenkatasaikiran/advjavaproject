package com.sathya.advjavaproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
	public static int saveData(UserData user)
	{	int res = 0;
		try {
		Connection connection = TestConnection.createConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into user_details values(?,?,?,?,?,?,?,?,?)");
		System.out.println(user);
		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setString(4, user.getCountry());
		preparedStatement.setString(5, user.getQualification());
		preparedStatement.setString(6, user.getGender());
		preparedStatement.setString(7, user.getTechnologies());
		preparedStatement.setString(8, user.getAddress());
		preparedStatement.setString(9, user.getComments());
		res = preparedStatement.executeUpdate();
		System.out.println(res);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static int passwordreset(String email, String confPassword) {
		int res = 0;
		try {
			Connection connection = TestConnection.createConnection();
			Statement statement = connection.createStatement();
			res = statement.executeUpdate("update user_details set password='"+confPassword+"'where email='"+ email +"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(res);
		return res;
	}

	public static boolean checkLogin(String email, String password) {
		
		boolean result = false;
		try {
			Connection connection = TestConnection.createConnection();
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery("select email,password from user_details where email='"+email+"'and password='"+password+"'");
			
			  if (set.next()) { result = true; }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}
}
