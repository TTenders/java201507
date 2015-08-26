package com.soft.maneger.dao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import com.soft.maneger.tool.Conn;

class usersDBA2 {

	//-----------------------------------往数据库users添加一条数据
	public boolean inserUser(String[] par) throws SQLException{
		boolean tt=false;
		String sql="insert into department(id,dname,dtype,dintro) values(department_seq.nextval,?,?,?)";
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
		//-----------------------------------从数据库中取数据
	public static Vector<Vector<Object>>  getAllUsers(){
		
			Vector<Vector<Object>> allVector=new Vector<Vector<Object>>();
			
			String sql="select id,dname,dtype,dintro from department";
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
			    rowVector.add(rs.getString("dname"));
				rowVector.add(rs.getString("dtype"));				
				rowVector.add(rs.getString("dintro"));
				rowVector.add(rs.getString("id"));
				allVector.add(rowVector);
				
				}
			 }catch(SQLException e){
				e.printStackTrace();
			 }
			return allVector;	
	}
//-------删除一条记录
	
	public boolean delUsresbyId(String id){
		boolean tt = false;
		String sql = "delete department where id=?";
		Connection con = null;
		try {
			con = Conn.getConnect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
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
}
   
     



































     
     
     

