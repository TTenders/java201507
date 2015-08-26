package com.soft.maneger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;

import com.soft.maneger.tool.Conn;

public class UserDAO1 {
	JFrame frame2;
//插入
public boolean insertUsers(String[] par){
	boolean tt=false;
	String sql="insert into Users(id,Username,Sex,Birth,Peopleid,password) values(Users_seq.Nextval,?,?,?,?,?)";
	Connection con=null;
	try {
		con = Conn.getConnect();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	PreparedStatement ps=null;
	try{
	ps=con.prepareStatement(sql);
	ps.setString(1, par[0]);
	ps.setString(2, par[1]);
	ps.setString(3, par[2]);
	ps.setString(4, par[3]);
	ps.setString(5, par[4]);
	 int i=ps.executeUpdate();
	 if(i>0)
		 System.out.println("录入成功！");
	   tt=true;
	}
	catch (SQLException e) {
		
		e.printStackTrace();
	}
	return tt;   
}

//获取所有用户信息
public Vector<Vector<Object>> getAllUsers(){
	Vector allVector=new Vector<Vector<Object>>();
	String sql="select id,Username,Sex,Birth,Peopleid from users";
	Connection con=null;
	try {
		con = Conn.getConnect();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	PreparedStatement ps=null;
	ResultSet rs=null;
	try {
		ps=con.prepareStatement(sql);
		rs=ps.executeQuery();
		int i=0;
		while(rs.next())
		{
			Vector<Object> rowVector=new Vector<Object>();
			rowVector.add(new Integer(++i));//在表格中显示序列
			rowVector.add(rs.getString("username"));
			rowVector.add(rs.getString("sex"));
			rowVector.add(rs.getString("birth"));
			rowVector.add(rs.getString("peopleid"));
			rowVector.add(rs.getString("id"));
		   allVector.add(rowVector);
		}	
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return allVector;
}
//删除一条记录
public boolean delUsersbyId(String id){
	boolean tt=false;
	String sql="delete users where id=?";
		PreparedStatement ps=null;
	try {
		Connection con=Conn.getConnect();
		ps=con.prepareStatement(sql);
		ps.setString(1,id);
		System.out.println(id);
		int i=ps.executeUpdate();
		if(i>0){
			tt=true;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return tt;
	
}

//匹配
public boolean aaLoginAuthentication(String username,String password){
	boolean kk = false;
	System.out.printf(username);
	String sql="select username,password from users where username='"+username+"'";
    Connection con=null;
	try {
		con = Conn.getConnect();
	} catch (SQLException e1) {
		e1.printStackTrace();

	}
	PreparedStatement ps=null;
	ResultSet rs=null;
	String kg = null,km=null;
	try {
		ps=con.prepareStatement(sql);
	}catch(Exception e1){
		e1.printStackTrace();
	
	}
		try{
		rs=ps.executeQuery();
		while(rs.next())
		{
			  km=rs.getString(1);
			  kg=rs.getString("password");
			 
			}	
		
	} catch (SQLException e) {
		e.printStackTrace();

	}
	if(password.equals(kg)&&username.equals(km)) {
		 
		 kk=true;
	}
	
return kk;
}

}

