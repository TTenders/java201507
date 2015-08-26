package com.soft.maneger.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.soft.maneger.tool.Conn;

public class usersDAO_Guanliyuan {
	//-----------------------------------往数据库users添加一条数据
	public boolean inserUser(String[] par) throws SQLException{
		boolean tt=false;
		String sql="insert into Admministrator(id,Username,password,dintro) values(Admministrator_seq.nextval,?,?,?)";
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
     	ps.setString(1,par[0]);	
		ps.setString(2,par[1]);
		ps.setString(3,par[2]);
		
		
		int i=ps.executeUpdate();//对数据库记录影响的条数
		if(i>0){
			System.out.println("录入成功");
			tt=true;
			} 
		}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		
		return tt;
	}
//从数据库中取数据
	public static Vector<Vector<Object>>  getAllUsers(){
		
			Vector<Vector<Object>> allVector=new Vector<Vector<Object>>();
			
			String sql="select id,Username,password,dintro from Admministrator";
			Connection con = null;
			try {
				con = Conn.getConnect();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			PreparedStatement ps=null;
			ResultSet rs=null;
			try{
				ps=con.prepareStatement(sql);
			    rs=ps.executeQuery();
			    int i=0;
			    
			    while(rs.next()){
				Vector<Object> rowVector=new Vector<Object>();
				rowVector.add(new Integer(++i));
			    rowVector.add(rs.getString("Username"));
			    rowVector.add(rs.getString("password"));
				rowVector.add(rs.getString("dintro"));
				rowVector.add(rs.getString("id"));
				allVector.add(rowVector);
				
				}
			 }catch(SQLException e){
				e.printStackTrace();
			 }
			return allVector;	
	}
//删除一条记录
	
	public boolean delUsresbyId4(String id){
		boolean tt = false;
		String sql = "delete Admministrator where id=?";
		Connection con = null;
		try {
			con = Conn.getConnect();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		PreparedStatement ps=null;
		try{
			ps=con.prepareStatement(sql);
			ps.setString(1,id);
			int i = ps.executeUpdate();
			if(i>0){
				tt=true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return tt;
	}
	//匹配
	public boolean LoginAuthentication(String username,String password){
		boolean kk = false;
		System.out.printf(username);
		String sql="select username,password from Admministrator where username='"+username+"'";
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
   
     























     
     
     


