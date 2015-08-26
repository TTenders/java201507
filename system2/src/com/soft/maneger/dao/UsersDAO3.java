package com.soft.maneger.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.soft.maneger.tool.Conn;

class UsersDAO3 {
	//-----------------------------------�����ݿ�users���һ������
	public boolean inserUser(String[] par) throws SQLException{
		boolean tt=false;
		String sql="insert into OfficeTable(id,post,username,dintro) values(OfficeTable_seq.nextval,?,?,?)";
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
		
		
		int i=ps.executeUpdate();//�����ݿ��¼Ӱ�������
		if(i>0){
			System.out.println("¼��ɹ�");
			tt=true;
			} 
		}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		
		return tt;
	}
		//-----------------------------------�����ݿ���ȡ����
	public static Vector<Vector<Object>>  getAllUsers(){
		
			Vector<Vector<Object>> allVector=new Vector<Vector<Object>>();
			
			String sql="select id,post,username,dintro from OfficeTable";
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
			    rowVector.add(rs.getString("post"));
				rowVector.add(rs.getString("username"));				
				rowVector.add(rs.getString("dintro"));
				rowVector.add(rs.getString("id"));
				allVector.add(rowVector);
				
				}
			 }catch(SQLException e){
				e.printStackTrace();
			 }
			return allVector;	
	}
//-------ɾ��һ����¼
	
	public boolean delUsresbyId(String id){
		boolean tt = false;
		String sql = "delete OfficeTable where id=?";
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
   
     
