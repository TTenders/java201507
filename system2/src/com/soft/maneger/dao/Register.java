package com.soft.maneger.dao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.soft.maneger.tool.MPanel;

public class Register extends JFrame{
	
             
	   JButton  jlogin;                  
	   JButton  jreset;                   
	   JButton  enroll;                 
	   JFrame  frame,frame2,frame3;
	 
	   JPanel inputPanel=new JPanel(),buttonPanel=new JPanel();
	   JTextField nameTextField= new JTextField();
	   JTextField passwordTextField=new JTextField();
	   JTextField introTextField=new JTextField();
	   usersDAO_Guanliyuan dao = new usersDAO_Guanliyuan();
	  
	public Register(){
		this.setTitle("µÇÂ¼");
		this.setBounds(450, 200, 500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con=this.getContentPane();
		con.setLayout(new BorderLayout());		
		MPanel pan=new MPanel(this.getClass().getResource("/com/img/yj.jpg"));
		pan.setLayout(new GridBagLayout());
		con.add(pan,BorderLayout.CENTER);
		
		JLabel  jlab1=new JLabel("ÕË»§Ãû³Æ£º");
		GridBagConstraints gri1=new GridBagConstraints();
		gri1.insets = new Insets(5, 0, 20, 0);
		gri1.gridx=0;
		gri1.gridy=0;
		pan.add(jlab1,gri1);
		
		nameTextField=new JTextField();
		GridBagConstraints gri2=new GridBagConstraints();
		gri2.insets = new Insets(5, 0, 20, 0);
		gri1.gridx=1;
		gri1.gridy=0;
		nameTextField.setColumns(15);
		pan.add(nameTextField,gri2);
		
		JLabel  jlab2=new JLabel("ÃÜ       Âë£º");
		GridBagConstraints gri3=new GridBagConstraints();
		gri3.insets = new Insets(5, 0, 20, 0);
		gri3.gridy=1;
		gri3.gridx=0;
		pan.add(jlab2,gri3);		
		
	
		passwordTextField=new JPasswordField();
		passwordTextField.setColumns(15);
		GridBagConstraints gri4=new GridBagConstraints();
		gri4.gridy=1;
		gri4.gridx=1;
		pan.add(passwordTextField,gri4);
		
		JPanel buttonPan=new JPanel();
		buttonPan.setOpaque(false);// ÉèÖÃÃæ°åµÄ±³¾°ÎªÍ¸Ã÷
		GridBagConstraints gri5=new GridBagConstraints();
		gri5.anchor = GridBagConstraints.CENTER;	
		gri5.gridwidth=2;
		gri5.gridy=2;
		gri5.gridx=0;
		pan.add(buttonPan,gri5);	
		
		jlogin=new JButton("µÇÂ¼");		
		buttonPan.add(jlogin);		
		jreset=new JButton("ÖØÖÃ");		
		buttonPan.add(jreset);
		enroll=new JButton("×¢²á");		
		buttonPan.add(enroll);
		//µÇÂ¼¼àÌý
		jlogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				usersDAO_Guanliyuan ser=new usersDAO_Guanliyuan();			
				boolean tt=ser.LoginAuthentication(nameTextField.getText(),passwordTextField.getText());
				
				if(tt){
					String infos1="µÇÂ¼³É¹¦£¡";
					JOptionPane.showMessageDialog(null,infos1,"ÓÑÇéÌáÊ¾",
							JOptionPane.INFORMATION_MESSAGE);	
					
				Homepage hh  =new Homepage();
				dispose();
				}
				else if(!tt){
					String infos2="µÇÂ¼Ê§°Ü£¡";
					JOptionPane.showMessageDialog(null,infos2,"ÓÑÇéÌáÊ¾",
							JOptionPane.INFORMATION_MESSAGE);	
					nameTextField.setText("");
					nameTextField.requestFocus();
					passwordTextField.setText("");
			}
				
			}
		});	
		//ÖØÖÃ¼àÌý
		jreset.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				nameTextField.setText("");
				nameTextField.requestFocus();
				passwordTextField.setText("");
				
			}
		});
		//×¢²á¼àÌý
		enroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				registerDAO reg = new registerDAO();
			}
		});
		this.setVisible(true);
	}
			
	public static void main(String[] args) {
		new Register();
	}
		}
