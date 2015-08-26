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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.soft.maneger.tool.Conn;
import com.soft.maneger.tool.Mtable;

public class ManagerMainTest1 extends JDialog{

	private JTextField nameTextField;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField birthdayTextField;
	private JTextField passwordTextField;
	private JTextField idCardTextField;
	private  Vector<String> tableColumnV;
	private  Vector<Vector<Object>> tableValueV;
	private  DefaultTableModel tableModel;
	private Mtable table;
	private UserDAO1 user=new UserDAO1();
	private Map<Integer,String> mapids;
	public static void main(String[] args) {
		ManagerMainTest1  mm=new ManagerMainTest1();
		
	}
	
	public ManagerMainTest1(){
		  
		super();
		setModal(true);
		setTitle("员工管理");
		setBounds(100, 100, 800, 375);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//设置关闭当前窗口的同时也关闭控制台的进程
				
		final JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridBagLayout());
		getContentPane().add(inputPanel, BorderLayout.NORTH);
		//加标签
		final JLabel nameLabel = new JLabel();
		nameLabel.setText("姓    名：");
		final GridBagConstraints gridBagConstraints_13 = new GridBagConstraints();
		gridBagConstraints_13.insets = new Insets(10, 0, 0, 0);
		inputPanel.add(nameLabel, gridBagConstraints_13);
		
		//文本框
		nameTextField = new JTextField();
		nameTextField.setColumns(12);
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridx = 1;
		inputPanel.add(nameTextField, gridBagConstraints);
		
		//------性别-------------------------------
		final JLabel sexLabel = new JLabel();
		sexLabel.setText("性别：");
		final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.insets = new Insets(10, 15, 0, 0);
		gridBagConstraints_1.gridy = 0;
		gridBagConstraints_1.gridx = 2;
		inputPanel.add(sexLabel, gridBagConstraints_1);
		
		//-------单选按钮---------------------------
		final JRadioButton manRadioButton = new JRadioButton();
		buttonGroup.add(manRadioButton);
		manRadioButton.setText("男");
		manRadioButton.setSelected(true);
		final GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_2.gridy = 0;
		gridBagConstraints_2.gridx = 3;
		inputPanel.add(manRadioButton, gridBagConstraints_2);
		
		
		final JRadioButton womanRadioButton = new JRadioButton();
		buttonGroup.add(womanRadioButton);
		womanRadioButton.setText("女");
		final GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_3.gridy = 0;
		gridBagConstraints_3.gridx = 4;
		inputPanel.add(womanRadioButton, gridBagConstraints_3);
		
		//-------出生日期-------------
		final JLabel birthdayLabel = new JLabel();
		birthdayLabel.setText("出生日期：");
		final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		gridBagConstraints_4.insets = new Insets(10, 15, 0, 0);
		gridBagConstraints_4.gridy = 0;
		gridBagConstraints_4.gridx = 5;
		inputPanel.add(birthdayLabel, gridBagConstraints_4);
		
		birthdayTextField = new JTextField();
		birthdayTextField.setColumns(20);
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_5.gridy = 0;
		gridBagConstraints_5.gridx = 6;
		inputPanel.add(birthdayTextField, gridBagConstraints_5);
		
		//---------密码-----------------------------
		final JLabel passwordLabel = new JLabel();
		passwordLabel.setText("登录密码：");
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
		gridBagConstraints_8.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_8.gridy = 1;
		gridBagConstraints_8.gridx = 0;
		inputPanel.add(passwordLabel, gridBagConstraints_8);
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(33);
		final GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();
		gridBagConstraints_9.gridwidth = 4;
		gridBagConstraints_9.anchor = GridBagConstraints.WEST;
		gridBagConstraints_9.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_9.gridy = 1;
		gridBagConstraints_9.gridx = 1;
		inputPanel.add(passwordTextField, gridBagConstraints_9);
		
		//----身份证号---------------------------
		final JLabel idCardLabel = new JLabel();
		idCardLabel.setText("身份证号：");
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.insets = new Insets(5, 16, 0, 0);
		gridBagConstraints_6.gridy = 1;
		gridBagConstraints_6.gridx = 5;
		inputPanel.add(idCardLabel, gridBagConstraints_6);
		
		
		idCardTextField = new JTextField();
		idCardTextField.setColumns(20);
		final GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();
		gridBagConstraints_7.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_7.gridy = 1;
		gridBagConstraints_7.gridx = 6;
		inputPanel.add(idCardTextField, gridBagConstraints_7);
		
		//--------建立内层按钮面板--------------------------------
		final JPanel buttonPanel = new JPanel();
		final GridBagConstraints gridBagConstraints_10 = new GridBagConstraints();
		gridBagConstraints_10.anchor = GridBagConstraints.EAST;
		gridBagConstraints_10.insets = new Insets(5, 0, 10, 0);
		gridBagConstraints_10.gridwidth = 7;
		gridBagConstraints_10.gridy = 2;
		gridBagConstraints_10.gridx = 0;
		inputPanel.add(buttonPanel, gridBagConstraints_10);
		
	    //---创建按钮-----------------
//添加按钮		
		final JButton subButton = new JButton();
		subButton.setText("添加");
		buttonPanel.add(subButton);
		subButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//把页面输入的用户信息放入了数组中
				String values[] = new String[6];
				values[0] = nameTextField.getText();
				values[1] = (manRadioButton.isSelected() ? "男" : "女");
				values[2] = birthdayTextField.getText();
				values[3] = idCardTextField.getText();
				values[4] = passwordTextField.getText();
				values[5]="正常";
				if(values[0].length()>4){
				
					JOptionPane.showMessageDialog(null,"姓名最多为四个汉字！","友情提示",JOptionPane.INFORMATION_MESSAGE);
					nameTextField.setText("");	
					nameTextField.requestFocus();	
					return;
				}
				
			if(!com.soft.maneger.tool.Validate.excute("[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}", values[2])){
				String infos[]={"出生日期格式错误！","正确格式为：2008-8-8"};
				JOptionPane.showMessageDialog(null,infos,"友情提示",JOptionPane.INFORMATION_MESSAGE);
				birthdayTextField.setText("");	
				birthdayTextField.requestFocus();	
				//return;
			}
			
			
			if(values[4].length()>6){
				
				JOptionPane.showMessageDialog(null,"密码不能超过6位！","友情提示",JOptionPane.INFORMATION_MESSAGE);
				passwordTextField.setText("");	
				passwordTextField.requestFocus();	
				return;
			}
			
			if(!com.soft.maneger.tool.Validate.excute(
					"(\\d){15,18}", values[3])){
				String infos[]={"身份证号输入错误！","身份证号必须为15或18位"};
				JOptionPane.showMessageDialog(null,infos,"友情提示",JOptionPane.INFORMATION_MESSAGE);
				idCardTextField.setText("");	
				idCardTextField.requestFocus();	
				return;
			}
			//验证通过
		boolean tt;
		try{
			tt=user.insertUsers(values);
			if(tt){
				String infos[]={"添加成功！"};
				JOptionPane.showMessageDialog(null,infos,"友情提示",JOptionPane.INFORMATION_MESSAGE);
			//----------清空----------
				nameTextField.setText("");	
				nameTextField.requestFocus();
				birthdayTextField.setText("");	
				passwordTextField.setText("");
				idCardTextField.setText("");	
		  //------------把添加的数据显示在表格中--------
				dispose();
				ManagerMainTest1  mm=new ManagerMainTest1();
				
			}
		}
		catch(Exception e1){
				e1.printStackTrace();
			
		}
			}			
		});
	
//删除按钮
		final JButton delButton = new JButton();
		delButton.setText("删除");
		buttonPanel.add(delButton);
		delButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				int selecteRow=table.getSelectedRow();//记录被删除的行号
				if(selecteRow==-1){
					   String infos4="请选中用户!";
						JOptionPane.showMessageDialog(null,infos4,"友情提示",
								JOptionPane.INFORMATION_MESSAGE);
						return;
				   }
				String name=table.getValueAt(selecteRow, 1).toString();
				
				int i=JOptionPane.showConfirmDialog(null,"确定要删除用户"+name+"?","友情提示",JOptionPane.YES_NO_OPTION);
				
				if(i==0){
	       //到数据库里删除该条信息			
				String id=mapids.get(Integer.parseInt(String.valueOf(selecteRow+1)));
				user.delUsersbyId(id);
			   tableModel.removeRow(selecteRow);
				JOptionPane.showMessageDialog(null,"删除成功","友情提示",JOptionPane.INFORMATION_MESSAGE);
				System.out.println("删除"+selecteRow+" "+i);
				}
			}
		});		

		//修改按钮
		final JButton updButton = new JButton();
		updButton.setText("修改");	
		buttonPanel.add(updButton);		
		updButton.addActionListener (new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				int rownum = table.getSelectedRow();
				  if(rownum==-1){
					   String infos4="请选中员工!";
						JOptionPane.showMessageDialog(null,infos4,"友情提示",
								JOptionPane.INFORMATION_MESSAGE);
						return;
				   }
				   String value3[] = new String[5];	 
					value3[0] = table.getValueAt(rownum, 1).toString();
					value3[1] = table.getValueAt(rownum, 2).toString();
					value3[2] = table.getValueAt(rownum,3).toString();
					value3[3] = table.getValueAt(rownum,4).toString();
					value3[4] = table.getValueAt(rownum,5).toString();
					
				    int i = JOptionPane.showConfirmDialog(null,"确定要修改用户"+value3[0]+"吗？","友情提示",JOptionPane.YES_NO_OPTION);
							System.out.println(i);
							if(i==0){							 
								//-----------------------名称验证	
									if(value3[0].length()==0){
								    	JOptionPane.showMessageDialog(null, "姓名不能为空！","友情提示",JOptionPane.INFORMATION_MESSAGE);							    	
								    	return;
								    }
					           //-----------------------类型验证								
								    if(value3[3].length()==0){
								    	JOptionPane.showMessageDialog(null, "密码不能为空！","友情提示",JOptionPane.INFORMATION_MESSAGE);							    	
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
						
							    String sql1 = "update users set username=?,sex=?,birth=?,peopleid=?,password=? where id=?";
							    
										try {
								PreparedStatement ps=null;
										   ps=con.prepareStatement(sql1);
										  System.out.println("gggggggggggggggggggggggggg");	
										   
										  ps.setString(1,value3[0]);	 
										  ps.setString(2,value3[1]);
										  ps.setString(3,value3[2]); 
										  ps.setString(4,value3[3]);
										  ps.setString(5,value3[4]); 
										  ps.setString(6,id);
										  
										  System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+value3[0]+" "+value3[1]+" "+value3[2]+" ");
									   int k=ps.executeUpdate();//对数据库记录影响的条数		
									   System.out.println("******1****"+sql1);
										   if(i>0){
											   String infos33="员工修改成功！";
												JOptionPane.showMessageDialog(null,infos33,"友情提示",
														JOptionPane.INFORMATION_MESSAGE);
												dispose();
												ManagerMainTest1 y = new ManagerMainTest1();
												System.out.println("修改"+i);
										   }
										} catch (SQLException e1) {
											
											e1.printStackTrace();
										}
						}
							
								                          				              
			}
		});
//退出按钮
		final JButton exitButton = new JButton();
		exitButton.setText("退出");
		buttonPanel.add(exitButton);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Homepage de=new Homepage();
			}
		});

//表格的实现
		final JScrollPane scrollpane= new JScrollPane();//带滚动条的面板
	
		getContentPane().add(scrollpane,BorderLayout.CENTER);//把滚动面板加入内容面板
		 tableColumnV = new Vector<String>();//表格的标题向量
	
		String tableColumns[]={"序号","姓名","性别","出生日期","身份证号","ID"};
		for(int column=0;column<tableColumns.length;column++){
			tableColumnV.add(tableColumns[column]);
			
		}
		tableValueV = new Vector<Vector<Object>>();//定义数值内容表格
      
     
		tableValueV=user.getAllUsers();//获取所有用户信息
		//把序号i放在map中供后面删除使用
		 mapids=new HashMap();
        for(int i=0;i<tableValueV.size();i++){
    	   Vector<Object> v=tableValueV.get(i);
    	   mapids.put(Integer.parseInt(v.get(0).toString()),v.get(5).toString());
       }
	
		tableModel=new DefaultTableModel(tableValueV,tableColumnV);//表格模型
		 table=new Mtable(tableModel);//把表格模型放入表格中
		if(table.getRowCount()>0)
			table.setRowSelectionInterval(0,0);//用来设置表格几行被选中
		scrollpane.setViewportView(table);
	this.setVisible(true);
	}
	
}
