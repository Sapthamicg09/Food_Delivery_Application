package com.myFoodApplication.userDAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myFoodApplication.userDAO.userDAO;
import com.myFoodApplication.user.User;

public class UserDAOImpl implements userDAO
{
	
	List<User> userList = new ArrayList<User>();
	
	private final String INSERT_QUERY = "insert into `user`(`username` , `email` , `password` , `mobile`) values(?,?,?,?)";
	private final String FECTH_ALL = "select * from user";
	private final String FECTH_SPECIFIC = "select * from `user` where `email`=? ";
	private final String UPDATE_QUERY = "update `user` set `email`=? where `uid`=?";
	private final String DELETE_QUERY = "DELETE FROM `user` where `uid`=?";
	
	private String url = "jdbc:mysql://localhost:3306/food_application";
	private String username="root";
	private String password = "2909";
	private Connection con;

	private PreparedStatement pstmt;

	private int status;
	private Statement stmt;
	private ResultSet resultSet;

	private User u;
	
	//constructor
	public UserDAOImpl()
	{
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void insert(User u)
	{
		try {
			
			pstmt = con.prepareStatement(INSERT_QUERY);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getPassword());
			pstmt.setInt(4, u.getMobile());
			
			status = pstmt.executeUpdate();
			
			if(status!=0)
			{
				System.out.println("Success");
			}
			else {
				System.out.println("Failure");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public List<User> fetchAll() 
	{
		try 
		{
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(FECTH_ALL);
			userList = exctractUserFromResultSet(resultSet);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userList;	
	}
	
	
	List<User> exctractUserFromResultSet(ResultSet resultSet)
	{
		try 
		{
			while(resultSet.next())
			{
				 userList.add(new User(resultSet.getInt("uid"),
						resultSet.getString("username"),
						resultSet.getString("email"),
						resultSet.getString("password"),
						resultSet.getInt("mobile")));
			}
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return userList;
	}

	
	@Override
	public User fetchSpecific(String email) {
		 
		try {
			
			pstmt = con.prepareStatement(FECTH_SPECIFIC);
			pstmt.setString(1, email);
			resultSet = pstmt.executeQuery();
			
			userList = exctractUserFromResultSet(resultSet);
			
			if(!userList.isEmpty()) {
				
				u =userList.get(0);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return u;
	}


	@Override
	public int update(User u) {
		
		try {
			
			pstmt = con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, u.getEmail());
			pstmt.setInt(2, u.getUid());
			status = pstmt.executeUpdate();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
		
	}


	@Override
	public int delete(int id) {
		
		try {
			
			pstmt = con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, id);
			status = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
		
	}

    
}
