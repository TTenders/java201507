package com.soft.maneger.dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.soft.maneger.tool.Conn;
  class UserDAO5 {
	  private String[] ips=new String[20];
public boolean insertUsers(String[] par){
	boolean tt=false;
	String sql="insert into wages(id,name,basepay,meritpay,tip,subsidy,personaltax,remark) values(wages_seq.Nextval,?,?,?,?,?,?,?)";
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
	ps.setString(6, par[5]);
	ps.setString(7, par[6]);

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
public static Vector<Vector<Object>> getAllUsers4(){

	Vector allVector=new Vector<Vector<Object>>();
	String sql="select id,name,basepay,meritpay,tip,subsidy,personaltax,remark from wages";
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
			int a=Integer.parseInt(rs.getString("basepay"));
			int b=Integer.parseInt(rs.getString("meritpay"));
			int c=Integer.parseInt(rs.getString("tip"));
			int d=Integer.parseInt(rs.getString("subsidy"));
			int e=Integer.parseInt(rs.getString("personaltax"));
			int f=a+b+c+d-e;
			Vector<Object> rowVector=new Vector<Object>();
			rowVector.add(new Integer(++i));//在表格中显示序列
			
			rowVector.add(rs.getString("name"));
			rowVector.add(a);
			rowVector.add(b);
			rowVector.add(c);
			rowVector.add(d);
			rowVector.add(e);
		    rowVector.add(rs.getString("remark"));
			rowVector.add(f);
			rowVector.add(rs.getString("id"));
		   allVector.add(rowVector);
		}	
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return allVector;
	
}
public void getip(){
	

	
}


//删除一条记录
public boolean delUsersbyId(String id){
	System.out.println("id"+id);
	boolean tt=false;
	String sql="delete wages where id=?";
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

}