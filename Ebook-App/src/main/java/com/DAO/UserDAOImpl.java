package com.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDAOImpl implements  UserDAO{
	private Connection conn;

	public UserDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean UserRegister(User us) {
		// TODO Auto-generated method stub
		boolean f=false;
		
		try {
			String sql="insert into user(Name,Email,PhNo, Password ) values(?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPhNo());
			ps.setString(4, us.getPassword());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public User login(String email, String password) {
		User us = null;
    
    try {
    	String sql="select * from user where Email=? and Password=?";
    	PreparedStatement ps = conn.prepareStatement(sql);
    	ps.setString(1, email);
    	ps.setString(2, password);
    	
    	ResultSet rs=ps.executeQuery();
    	while(rs.next()) {
    		
    	us=new User();
    	us.setId(rs.getInt(1));
    	us.setName(rs.getNString(2));
    	us.setEmail(rs.getNString(3));
    	us.setPhNo(rs.getNString(4));
    	us.setPassword(rs.getNString(5));
    	us.setAddress(rs.getNString(6));
    	us.setLandmark(rs.getNString(7));
    	us.setCity(rs.getNString(8));
    	us.setState(rs.getNString(9));
    	us.setPincode(rs.getNString(10));
    	
    	}
    }catch (Exception e) {
    	e.printStackTrace();
    }
	return us;
	}

	@Override
	public boolean checkPassword(int id,String ps) {
		
		
		// TODO Auto-generated method stub
		boolean f=false;
		
		try {
			String sql="select * from  user where id=? and password=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setString(2, ps);

			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				f=true;
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean updateProfile(User us) {
		
boolean f=false;
		
		try {
			String sql="update user set Name=?,Email=?,PhNo=? where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPhNo());
			ps.setInt(4, us.getId());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
		
	}

	@Override
	public boolean checkUser(String em) {
		boolean f=true;
		try {
			String sql="select * from user where email=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, em);
           
			ResultSet rs=ps.executeQuery();
			 while(rs.next()) {
	            	f=false;
	            }
				
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	

}
