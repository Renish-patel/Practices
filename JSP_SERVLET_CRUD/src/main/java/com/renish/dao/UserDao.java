package com.renish.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.renish.bean.*;

public class UserDao {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JSP_SERVLET_CRUD", "root", "root");

		} catch (Exception e) {
			System.out.println(e);

		}
		return connection;
	}

	public static int saveItemdata(User user) {
		int status = 0;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into user (ItemNo, ItemName, Date, Category) values(?,?,?,?)");

			preparedStatement.setString(1, user.getItemNo());
			preparedStatement.setString(2, user.getItemName());
			preparedStatement.setString(3, user.getDate());
			preparedStatement.setString(4, user.getCategory());

			status = preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int updateItemdata(User user) {
		int status = 0;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("update user set ItemNo=?,ItemName=?,Date=?,Category=? where id=?");
			
			
			preparedStatement.setString(1, user.getItemNo());
			preparedStatement.setString(2, user.getItemName());
			preparedStatement.setString(3, user.getDate());
			preparedStatement.setString(4, user.getCategory());
			
			preparedStatement.setInt(5, user.getId());
				System.out.println("weewewewewew===>"+user.getId());
				
			status = preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);

		}
		return status;
	}

	public static int deleteItem(User user) {
		int status = 0;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("delete from user where id=?");

			preparedStatement.setInt(1, user.getId());

			status = preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static List<User> GetitemRecord() {
		List<User> list = new ArrayList<User>();
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = new User(0, null, null, null, null);

				user.setId(resultSet.getInt("id"));
				user.setItemNo(resultSet.getString("itemNo"));
				user.setItemName(resultSet.getString("itemName"));
				user.setDate(resultSet.getString("date"));
				user.setCategory(resultSet.getString("category"));
				list.add(user);
			}

			connection.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}


	public static User getLogisticRecord(int id) {
		User user = null;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user where Id=?");
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				user = new User(id, null, null, null, null);

				user.setId(resultSet.getInt("Id"));
				user.setItemNo(resultSet.getString("itemNo"));
				user.setItemName(resultSet.getString("itemName"));
				user.setDate(resultSet.getString("date"));
				user.setCategory(resultSet.getString("category"));

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return user;
	}
}