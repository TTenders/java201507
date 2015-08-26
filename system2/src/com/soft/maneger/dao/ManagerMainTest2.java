package com.soft.maneger.dao;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.soft.maneger.tool.Conn;
import com.soft.maneger.tool.Mtable;

public class ManagerMainTest2 extends JDialog{
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField nameTextField;
	private JTextField TypeTextField;
	private JTextField introTextField;
	DefaultTableModel tableModel;
	private Vector<String> tableColumnV;
	private Vector<Vector<Object>> tableValueV;
	private usersDBA2 dao = new usersDBA2();	
	
	private  Mtable table;
	private Map<Integer,String> mapids;
//主函数
	public static void main(String[] args) {
		
		ManagerMainTest2 y = new ManagerMainTest2();
	
	}
	
public  ManagerMainTest2 (){
		
		super();
		setModal(true);
		setTitle("部门管理");
		setBounds(100, 100, 900, 375);
		
		final JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridBagLayout());
		getContentPane().add(inputPanel, BorderLayout.NORTH);
	
		final JLabel nameLabel = new JLabel();
		nameLabel.setText("部门名称：");
		final GridBagConstraints gridBagConstraints_13 = new GridBagConstraints();
		gridBagConstraints_13.insets = new Insets(10, 0, 0, 0);
		inputPanel.add(nameLabel, gridBagConstraints_13);
	
		nameTextField = new JTextField();
		nameTextField.setColumns(12);
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridx = 1;
		inputPanel.add(nameTextField, gridBagConstraints);
	
		final JLabel TypeLabel = new JLabel();
		TypeLabel.setText("部门类型：");
		final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		gridBagConstraints_4.insets = new Insets(10, 15, 0, 0);
		gridBagConstraints_4.gridy = 0;
		gridBagConstraints_4.gridx = 5;
		inputPanel.add(TypeLabel, gridBagConstraints_4);
		
		TypeTextField = new JTextField();
		TypeTextField.setColumns(20);
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_5.gridy = 0;
		gridBagConstraints_5.gridx = 6;
		inputPanel.add(TypeTextField, gridBagConstraints_5);
				
		final JLabel introLabel= new JLabel();
		introLabel.setText("部门简介：");
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
		gridBagConstraints_8.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_8.gridy = 1;
		gridBagConstraints_8.gridx = 0;
		inputPanel.add(introLabel, gridBagConstraints_8);
		
		introTextField = new JTextField();
		introTextField.setColumns(33);
		final GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();
		gridBagConstraints_9.gridwidth = 4;
		gridBagConstraints_9.anchor = GridBagConstraints.WEST;
		gridBagConstraints_9.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_9.gridy = 1;
		gridBagConstraints_9.gridx = 1;
		inputPanel.add(introTextField, gridBagConstraints_9);

		//--------建立内层按钮面板--------------------------------
		final JPanel buttonPanel = new JPanel();
		final GridBagConstraints gridBagConstraints_10 = new GridBagConstraints();
		gridBagConstraints_10.anchor = GridBagConstraints.SOUTH;
		gridBagConstraints_10.insets = new Insets(10, 5, 20, 5);
		gridBagConstraints_10.gridwidth = 30;
		gridBagConstraints_10.gridy = 5;
		gridBagConstraints_10.gridx = 5;
		inputPanel.add(buttonPanel, gridBagConstraints_10);
		
//--------添加按钮
		final JButton subButton = new JButton();
		subButton.setText("添加");
		buttonPanel.add(subButton);
		subButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
		   //把页面输入的用户信息放入了数组中
				String values[] = new String[4];
				values[0] = nameTextField.getText();		
				values[1] = TypeTextField.getText();
				values[2] = introTextField.getText();
				
//-----------------------名称验证	
				if(values[0].length()==0){
			    	JOptionPane.showMessageDialog(null, "部门名称不能为空！","友情提示",JOptionPane.INFORMATION_MESSAGE);
			    	nameTextField.setText("");//清空文本域
			    	nameTextField.requestFocus();//获得文本域焦点
			    	return;
			    }
//-----------------------类型验证			
	
			    if(values[0].length()==0){
			    	JOptionPane.showMessageDialog(null, "部门类型不能为空！","友情提示",JOptionPane.INFORMATION_MESSAGE);
			    	TypeTextField.setText("");//清空文本域
			    	TypeTextField.requestFocus();//获得文本域焦点
			    	return;
			    }
				boolean tt;				
				try {
					tt=dao.inserUser(values);
					if(tt){
						String infos3="用户添加成功！";
				JOptionPane.showMessageDialog(null,infos3,"友情提示",
						JOptionPane.INFORMATION_MESSAGE);
				
				//-------------清空文本框--
				nameTextField.setText("");
				nameTextField.requestFocus();				
				TypeTextField.setText("");
				TypeTextField.requestFocus();
				introTextField.setText("");
				introTextField.requestFocus();
			
				dispose();
				
				ManagerMainTest2 y = new ManagerMainTest2();
				
					}
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
						
		});
		
//---删除按钮--------------
	final JButton delButton = new JButton();
	delButton.setText("删除");	
	buttonPanel.add(delButton);
	delButton.addActionListener (new ActionListener(){
		public void actionPerformed(ActionEvent e){
	
	//被删记录的行号
    int rownum = table.getSelectedRow();
   if(rownum==-1){
	   String infos4="请选中部门!";
		JOptionPane.showMessageDialog(null,infos4,"友情提示",
				JOptionPane.INFORMATION_MESSAGE);
		return;
   }
	String name = table.getValueAt(rownum, 1).toString();
    int i = JOptionPane.showConfirmDialog(null,"确定要删除用户"+name+"吗？","友情提示",JOptionPane.YES_NO_OPTION);
			System.out.println(i);
	//确定要删除？
			//i=0时是确定，i=1时是取消
			if(i==0){
				//到数据库里删除信息
				String id = (String) mapids.get(Integer.parseInt(String.valueOf(rownum+1)));
				
				dao.delUsresbyId(id);
				
				//把表格中要删除的数据删除
				tableModel.removeRow(rownum);
				String infos4="删除成功！";
				JOptionPane.showMessageDialog(null,infos4,"友情提示",
						JOptionPane.INFORMATION_MESSAGE);
			}
			System.out.println("删除"+i);
		}
        });
	

//----修改按钮2--------------
	final JButton updButton = new JButton();
	updButton.setText("修改");	
	buttonPanel.add(updButton);		
	updButton.addActionListener (new ActionListener(){
		public void actionPerformed(ActionEvent e){
			int rownum = table.getSelectedRow();
			
			   if(rownum==-1){
				   String infos4="请选中部门!";
					JOptionPane.showMessageDialog(null,infos4,"友情提示",
							JOptionPane.INFORMATION_MESSAGE);
					return;
			   }
			   String value3[] = new String[5];	 
				value3[0] = table.getValueAt(rownum, 1).toString();
				value3[1] = table.getValueAt(rownum, 2).toString();
				value3[2] = table.getValueAt(rownum,3).toString();
				 
				
			    int i = JOptionPane.showConfirmDialog(null,"确定要修改用户"+value3[0]+"吗？","友情提示",JOptionPane.YES_NO_OPTION);
						System.out.println(i);
						if(i==0){							 
							//-----------------------名称验证	
								if(value3[0].length()==0){
							    	JOptionPane.showMessageDialog(null, "部门名称不能为空！","友情提示",JOptionPane.INFORMATION_MESSAGE);							    	
							    	return;
							    }
				           //-----------------------类型验证								
							    if(value3[1].length()==0){
							    	JOptionPane.showMessageDialog(null, "部门类型不能为空！","友情提示",JOptionPane.INFORMATION_MESSAGE);							    	
							    	return;
							    }
							//到数据库里修改信息
							String id = (String) mapids.get(Integer.parseInt(String.valueOf(rownum+1)));							
							Connection con = null;
							try {
								con = Conn.getConnect();
							} catch (SQLException e2) {
								e2.printStackTrace();
							}
					
						    String sql1 = "update department set dname=?,dtype=?,dintro=? where id=?";
						    
							PreparedStatement ps=null;
									try {
									   ps=con.prepareStatement(sql1);
									  System.out.println("gggggggggggggggggggggggggg");	
									   
									  ps.setString(1,value3[0]);	 
									  ps.setString(2,value3[1]);
									  ps.setString(3,value3[2]); 
									  ps.setString(4,id);
									  
									  System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+value3[0]+" "+value3[1]+" "+value3[2]+" ");
								   int k=ps.executeUpdate();//对数据库记录影响的条数		
								   System.out.println("******1****"+sql1);
									   if(i>0){
										   String infos3="部门修改成功！";
											JOptionPane.showMessageDialog(null,infos3,"友情提示",
													JOptionPane.INFORMATION_MESSAGE);
										
									   }
									} catch (SQLException e1) {
										
										e1.printStackTrace();
									}
					}
						dispose();
						ManagerMainTest2 y = new ManagerMainTest2();
						System.out.println("修改"+i);
						
					}
			        });
		

//---------退出按钮
			final JButton exitButton = new JButton();
			exitButton.setText("退出");
			buttonPanel.add(exitButton);
			exitButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					Homepage gg = new Homepage();
				}
					
			});
		
//-----表格的实现
		
		final JScrollPane scrollPane = new JScrollPane();//带动滚动的条板
        getContentPane().add(scrollPane,BorderLayout.CENTER);	
        
         table = new Mtable();
        tableColumnV = new Vector<String>();       
        tableColumnV.add("序号");        
        tableColumnV.add("部门名称");
        tableColumnV.add("部门类型");
        tableColumnV.add("部门简介");
       
          tableValueV = new Vector<Vector<Object>>();//结果集向量
        
         tableValueV = usersDBA2.getAllUsers();//获取信息
         
         //把序号id值放入map中供后面删除使用后
         
         mapids=new HashMap();         
         for(int i=0;i<tableValueV.size();i++){
       	  Vector<Object> v =tableValueV.get(i);
       	 mapids.put(Integer.parseInt(v.get(0).toString()),v.get(4).toString()); 
         }
        
		 tableModel = new DefaultTableModel(tableValueV,tableColumnV);//建表格		
         table = new Mtable(tableModel);//表格模型放入表格中
        
        scrollPane.setViewportView(table);
		this.setVisible(true);
	}

}
