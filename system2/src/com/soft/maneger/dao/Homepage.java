package com.soft.maneger.dao;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Homepage extends JDialog{
	Dialog frame;
	JFrame frame2,frame3;
	JMenuBar menubar;
	JMenu menu,menu1,menu2;
	JMenuItem item1,item2,item3,item4,item5,item6,item7,item8,item9;
	public static void main(String args[]){
		Homepage tt=new Homepage();
	}
	public Homepage(){
		    dispose();
            frame2 = new JFrame("                      �Ƶ����ϵͳ");
			frame2.setBounds(150, 170, 500, 400);
			String pp="123.jpg";
			ImageIcon aa=new ImageIcon(pp);
		    JLabel ll=new JLabel(aa);
		    ll.setBounds(0,0,500,400);
		    JPanel jj=(JPanel)frame2.getContentPane();
			jj.setOpaque(false);
			frame2.getLayeredPane().add(ll,new Integer(Integer.MIN_VALUE));
			
		    frame2.setVisible(true);
		    menubar = new JMenuBar();
	 		menu = new JMenu("����");
	 		menu1=new JMenu("ϵͳ");
	 		menu2=new JMenu("����Ա");
	 	
	 		
	 		item1=new JMenuItem("Ա������");
	 		item2=new JMenuItem("���Ź���");
	 		item3=new JMenuItem("ְ�����");
	 		item4=new JMenuItem("���ʹ���");
	 		
	 		item5=new JMenuItem("�˳�");
	 		
	 		item6=new JMenuItem("����Ա����");
	 		
	 		menu.add(item1);
	 		menu.add(item2);
	 		menu.add(item3);
	 		menu.add(item4);
	 		
	 		menu1.add(item5);
	 		
	 		menu2.add(item6); //��ѯ
	 		
	 		menubar.add(menu);
	 		menubar.add(menu2);
	 		menubar.add(menu1);
	 	
	 		frame2.setJMenuBar(menubar);
	 		frame2.validate();
	 		
	 		item1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ManagerMainTest1 gh=new ManagerMainTest1();
					frame2.setVisible(false);
					//frame3.setVisible(false);
					
				}
			});
	 		//���Ź���
	 		item2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ManagerMainTest2 gh=new ManagerMainTest2();
					frame2.setVisible(false);
					frame3.setVisible(false);
					
				}
			});
	 		//ְ�����
	 		item3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ManagerMainTest3 gh=new ManagerMainTest3();
					frame2.setVisible(false);
					frame3.setVisible(false);
					
				}
			});
	 		
	 		item4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {							
					ManagerMainTest4  mmb=new ManagerMainTest4();
					frame2.setVisible(false);
					
				}
			});
	 		//�˳�
	 		item5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					frame3=new JFrame("��ʾ����");
				    frame3.setBounds(300,300,200,100);
				    JLabel label=new JLabel("ȷ���˳���");
				    JPanel panel = new JPanel();
				    panel.setLayout(new FlowLayout());
					panel.add(label);
					frame3.add(panel,BorderLayout.CENTER);
					
					JButton button1=new JButton("ȷ��");
					JPanel panel3 = new JPanel();
					panel3.add(button1);
					frame3.add(panel3,BorderLayout.SOUTH);
					 frame3.setVisible(true);
					
					button1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {							
							frame2.setVisible(false);
							
						}
					});
					//����Ա����
			 		
					}
			});
	 		item6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {							
					Admministrator_Guanliyuan fdg = new Admministrator_Guanliyuan();
					frame2.setVisible(false);
					
				}
			});
	}
}