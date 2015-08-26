package com.soft.maneger.dao;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.soft.maneger.tool.MPanel;

public class registerDAO extends JFrame{
	
	 private JPanel buttonPanel; 
	 private JTextField nameTextField;
	 private  JTextField passwordTextField;
	 private  JTextField introTextField;
	 private Box boxv1,boxv2,basebox1;
	 
	 private  usersDAO_Guanliyuan dao = new usersDAO_Guanliyuan();
	   public static void main(String agrs[]){
		    new registerDAO();
	   }
	public registerDAO(){
				
		this.setTitle("����Աע��");
		this.setBounds(300,200,350,260);
		
	  
	    JLabel nameLabel = new JLabel();
		nameLabel.setText("������");		
	    nameTextField = new JTextField(10);
		
		 JLabel passwordLabel = new JLabel();
		passwordLabel.setText("���룺");		
		passwordTextField = new JTextField(10);
				
	    JLabel introLabel = new JLabel();
		introLabel.setText("���˼�飺");		
		introTextField = new JTextField(10);
		
		JPanel buttonPanel = new JPanel();
		
		JButton subButton2 = new JButton();
		subButton2.setText("����");
		buttonPanel.add(subButton2);
		
	   JButton subButton1 = new JButton();
		subButton1.setText("ע��");
		buttonPanel.add(subButton1);
		
		 boxv1 = Box.createVerticalBox();
		// boxv1.add(Box.createVerticalStrut(20));   
	     boxv1.add(nameLabel);
	     boxv1.add(Box.createVerticalStrut(18));    
	     boxv1.add(passwordLabel);
	     boxv1.add(Box.createVerticalStrut(19));
	     boxv1.add(introLabel);
	     boxv1.add(Box.createVerticalStrut(15));
	     JLabel aa = new JLabel(" ");
	     boxv1.add(aa);
	     boxv1.add(aa);
	     boxv1.add(Box.createVerticalStrut(20));
	     
	     
	     boxv2 = Box.createVerticalBox();
	     boxv2.add(Box.createVerticalStrut(15));  
	     boxv2.add(nameTextField);
	     boxv2.add(Box.createVerticalStrut(15));    
	     boxv2.add(passwordTextField);
	     boxv2.add(Box.createVerticalStrut(15));  
	     boxv2.add(introTextField);
	     boxv2.add(Box.createVerticalStrut(15));  
	     boxv2.add(buttonPanel);
	     boxv2.add(Box.createVerticalStrut(15));  	     
	     
	     basebox1 = Box.createHorizontalBox();
	     basebox1.add(boxv1);
	     basebox1.add(Box.createHorizontalStrut(10));
	     basebox1.add(boxv2);	 
	     add(basebox1);
	   	   
		//--------ע�ᰴť
			
				subButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//��ҳ��������û���Ϣ������������
						String value[] = new String[4];
						value[0] = nameTextField.getText();		
						value[1] = passwordTextField.getText();
						value[2] = introTextField.getText();
		//�û�������Ϊ��
						 if(value[0].length()==0){
								
								JOptionPane.showMessageDialog(null,"�û�������Ϊ�գ�","������ʾ",JOptionPane.INFORMATION_MESSAGE);
								nameTextField.setText("");	
								nameTextField.requestFocus();	
								return;
							}
		//���벻�ܳ���6λ				
						if(value[1].length()>6){
							
							JOptionPane.showMessageDialog(null,"���벻�ܳ���6λ��","������ʾ",JOptionPane.INFORMATION_MESSAGE);
							passwordTextField.setText("");	
							passwordTextField.requestFocus();	
							return;
						}
		//���벻��Ϊ��				
		                if(value[1].length()==0){
							
							JOptionPane.showMessageDialog(null,"���벻��Ϊ�գ�","������ʾ",JOptionPane.INFORMATION_MESSAGE);
							passwordTextField.setText("");	
							passwordTextField.requestFocus();	
							return;
						}
						boolean tt;
						
						try {
							tt=dao.inserUser(value);
							System.out.println("hhhhhhh");
							if(tt){
								String infos="����Աע��ɹ�����";
						JOptionPane.showMessageDialog(null,infos,"������ʾ",
								JOptionPane.INFORMATION_MESSAGE);
						dispose();
						new Register();
						
						//-------------����ı���--
						nameTextField.setText("");
						nameTextField.requestFocus();				
						passwordTextField.setText("");								
						introTextField.setText("");
						
							}								
						} 
						catch (SQLException e1) {
							e1.printStackTrace();
						}				
					}					
				});
				 this.setLayout(new FlowLayout());
			     this.add(basebox1);
			    
			     this.validate();
			     setVisible(true);
			     this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			   //���ü���
			     subButton2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {						
							nameTextField.setText("");
							nameTextField.requestFocus();				
							passwordTextField.setText("");								
							introTextField.setText("");
							
						}
					});
			     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Container con=this.getContentPane();
					con.setLayout(new BorderLayout());		
					MPanel pan=new MPanel(this.getClass().getResource("/com/img/dd.jpg"));
					pan.setLayout(new GridBagLayout());
					pan.add(basebox1);
					con.add(pan,BorderLayout.CENTER);
			     this.setVisible(true);
}	
}