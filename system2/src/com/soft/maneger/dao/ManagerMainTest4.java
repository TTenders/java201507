package com.soft.maneger.dao;

import java.awt.BorderLayout;
import java.awt.Container;
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
import com.soft.maneger.tool.Validate;

public class ManagerMainTest4 extends JDialog{

	
	private JTextField nameTextField;
	private JTextField basepayTextField;
	private JTextField meritpayTextField;
	private JTextField tipTextField;
	private JTextField subsidyTextField;
	private JTextField personaltaxTextField;
	private JTextField remarkTextField;
	private  Vector<String> tableColumnV;
	private  Vector<Vector<Object>> tableValueV;
	private  DefaultTableModel tableModel;
	private Mtable table;
	private UserDAO5 user=new UserDAO5();
	private Map<Integer,String> mapids;
	public static void main(String[] args) {
		ManagerMainTest4  mm=new ManagerMainTest4();
		
	}
	
	public ManagerMainTest4(){
		  
		super();
		setModal(true);
		setTitle("���ʹ���");
		setBounds(100, 100, 800, 375);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//���ùرյ�ǰ���ڵ�ͬʱҲ�رտ���̨�Ľ���
		
		//--------------����-------------------
		final JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridBagLayout());
		getContentPane().add(inputPanel, BorderLayout.NORTH);
		//�ӱ�ǩ
		final JLabel nameLabel = new JLabel();
		nameLabel.setText("������");
		final GridBagConstraints gridBagConstraints_13 = new GridBagConstraints();
		gridBagConstraints_13.insets = new Insets(10, 0, 0, 0);
		inputPanel.add(nameLabel, gridBagConstraints_13);
		
		//�ı���
		nameTextField = new JTextField();
		nameTextField.setColumns(20);
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridx = 1;
		inputPanel.add(nameTextField, gridBagConstraints);
		
		//---------------��������---------------------
		final JLabel basepayLabel = new JLabel();
		basepayLabel.setText("�������ʣ�");
		final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		gridBagConstraints_4.insets = new Insets(10, 15, 0, 0);
		gridBagConstraints_4.gridy = 0;
		gridBagConstraints_4.gridx = 5;
		inputPanel.add(basepayLabel, gridBagConstraints_4);
		
		basepayTextField = new JTextField();
		basepayTextField.setColumns(20);
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_5.gridy = 0;
		gridBagConstraints_5.gridx = 6;
		inputPanel.add(basepayTextField, gridBagConstraints_5);
		
		//----------------��Ч����----------------------
		final JLabel passwordLabel = new JLabel();
		passwordLabel.setText("��Ч���ʣ�");
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
		gridBagConstraints_8.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_8.gridy = 1;
		gridBagConstraints_8.gridx = 0;
		inputPanel.add(passwordLabel, gridBagConstraints_8);
		
		meritpayTextField = new JTextField();
		meritpayTextField.setColumns(20);
		final GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();
		gridBagConstraints_9.gridwidth = 4;
		gridBagConstraints_9.anchor = GridBagConstraints.WEST;
		gridBagConstraints_9.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_9.gridy = 1;
		gridBagConstraints_9.gridx = 1;
		inputPanel.add(meritpayTextField, gridBagConstraints_9);
		
		//-------------------���--------------------------
		final JLabel idCardLabel = new JLabel();
		idCardLabel.setText("��ɣ�");
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.insets = new Insets(5, 16, 0, 0);
		gridBagConstraints_6.gridy = 1;
		gridBagConstraints_6.gridx = 5;
		inputPanel.add(idCardLabel, gridBagConstraints_6);
		
		
		tipTextField = new JTextField();
		tipTextField.setColumns(20);
		final GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();
		gridBagConstraints_7.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_7.gridy = 1;
		gridBagConstraints_7.gridx = 6;
		inputPanel.add(tipTextField, gridBagConstraints_7);
		
		
		//--------------------����------------------------------
		final JLabel subsidyLabel = new JLabel();
		subsidyLabel.setText("������");
		final GridBagConstraints gridBagConstraints_12 = new GridBagConstraints();
		gridBagConstraints_12.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_12.gridy = 2;
		gridBagConstraints_12.gridx = 0;
		inputPanel.add(subsidyLabel, gridBagConstraints_12);
				
		subsidyTextField = new JTextField();
		subsidyTextField.setColumns(20);
		final GridBagConstraints gridBagConstraints_16 = new GridBagConstraints();
		gridBagConstraints_16.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_16.gridy = 2;
		gridBagConstraints_16.gridx = 1;
		inputPanel.add(subsidyTextField, gridBagConstraints_16);
				
		//-------------------------����˰-----------------------------		
				
		final JLabel personaltaxLabel = new JLabel();
		personaltaxLabel.setText("����˰��");
		final GridBagConstraints gridBagConstraints_20 = new GridBagConstraints();
		gridBagConstraints_20.insets = new Insets(5, 16, 0, 0);
		gridBagConstraints_20.gridy = 2;
		gridBagConstraints_20.gridx = 5;
		inputPanel.add(personaltaxLabel, gridBagConstraints_20);
				
		personaltaxTextField = new JTextField();
		personaltaxTextField.setColumns(20);
		final GridBagConstraints gridBagConstraints_21 = new GridBagConstraints();
		gridBagConstraints_21.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_21.gridy = 2;
		gridBagConstraints_21.gridx = 6;
		inputPanel.add(personaltaxTextField, gridBagConstraints_21);
				
		//---------------------------��ע---------------------------------------		
				
		final JLabel remarkLabel = new JLabel();
		remarkLabel.setText("��ע��");
		final GridBagConstraints gridBagConstraints_25 = new GridBagConstraints();
		gridBagConstraints_25.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_25.gridy = 3;
		gridBagConstraints_25.gridx = 0;
		inputPanel.add(remarkLabel, gridBagConstraints_25);
				
		remarkTextField = new JTextField();
		remarkTextField.setColumns(20);
		final GridBagConstraints gridBagConstraints_26 = new GridBagConstraints();
		gridBagConstraints_26.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_26.gridy = 3;
		gridBagConstraints_26.gridx = 1;
		inputPanel.add(remarkTextField, gridBagConstraints_26);
		
		//--------�����ڲ㰴ť���--------------------------------
		final JPanel buttonPanel = new JPanel();
		final GridBagConstraints gridBagConstraints_10 = new GridBagConstraints();
		gridBagConstraints_10.anchor = GridBagConstraints.EAST;
		gridBagConstraints_10.insets = new Insets(5, 0, 10, 0);
		gridBagConstraints_10.gridwidth = 7;
		gridBagConstraints_10.gridy = 4;
		gridBagConstraints_10.gridx = 5;
		inputPanel.add(buttonPanel, gridBagConstraints_10);
		
	    //---������ť-----------------
		final JButton subButton = new JButton();
	   //׷�Ӽ���
		subButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��ҳ��������û���Ϣ������������
				String values[] = new String[7];
				values[0] = nameTextField.getText();
				values[1] = basepayTextField.getText();
				values[2] = meritpayTextField.getText();
				values[3] = tipTextField.getText();
				values[4] = subsidyTextField.getText();
				values[5] = personaltaxTextField.getText();
				values[6] = remarkTextField.getText();
			
				if(values[0].length()>4){
				
					JOptionPane.showMessageDialog(null,"�������Ϊ�ĸ����֣�","������ʾ",JOptionPane.INFORMATION_MESSAGE);
					nameTextField.setText(" ");	
					nameTextField.requestFocus();	
					return;
				}
				
			
			
			//��֤ͨ��
		boolean tt;
		try{
			tt=user.insertUsers(values);
			if(tt){
				String infos[]={"��ӳɹ���"};
				JOptionPane.showMessageDialog(null,infos,"������ʾ",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				ManagerMainTest4  cc=new ManagerMainTest4();
				
			//----------���----------
				nameTextField.setText("");	
				nameTextField.requestFocus();
				basepayTextField.setText("");	
				meritpayTextField.setText("");
				tipTextField.setText("");
				subsidyTextField.setText("");
				personaltaxTextField.setText("");
				remarkTextField.setText("���");
				
	 
			}
			
		}
		catch(Exception e1){
				e1.printStackTrace();
			
		}
			}
			
		});
		
		subButton.setText("���");
		buttonPanel.add(subButton);
		
	
		//---ɾ����ť--------------
		final JButton delButton = new JButton();
		delButton.setText("ɾ��");
		buttonPanel.add(delButton);
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��ɾ��¼���к�
			    int rownum = table.getSelectedRow();
			   if(rownum==-1){
				   String infos4="��ѡ��Ա��!";
					JOptionPane.showMessageDialog(null,infos4,"������ʾ",
							JOptionPane.INFORMATION_MESSAGE);
					return;
			   }
				String name = table.getValueAt(rownum, 1).toString();
			    int i = JOptionPane.showConfirmDialog(null,"ȷ��Ҫɾ���û�"+name+"��","������ʾ",JOptionPane.YES_NO_OPTION);
						System.out.println(i);
				//ȷ��Ҫɾ����
						//i=0ʱ��ȷ����i=1ʱ��ȡ��
						if(i==0){
							//�����ݿ���ɾ����Ϣ
							String id = (String) mapids.get(Integer.parseInt(String.valueOf(rownum+1)));
							
							user.delUsersbyId(id);
							
							//�ѱ����Ҫɾ��������ɾ��
							tableModel.removeRow(rownum);
							String infos4="ɾ���ɹ���";
							JOptionPane.showMessageDialog(null,infos4,"������ʾ",
									JOptionPane.INFORMATION_MESSAGE);
						}
						//System.out.println("ɾ��"+i);
			}

		});
		//---�޸İ�ť--------------
				final JButton updButton = new JButton();
				updButton.setText("�޸�");	
				buttonPanel.add(updButton);		
				updButton.addActionListener (new ActionListener(){
					public void actionPerformed(ActionEvent e){
						int rownum = table.getSelectedRow();
						
						   if(rownum==-1){
							   String infos4="��ѡ����Ա!";
								JOptionPane.showMessageDialog(null,infos4,"������ʾ",
										JOptionPane.INFORMATION_MESSAGE);
								return;
						   }
						   String value3[] = new String[15];	 
							value3[0] = table.getValueAt(rownum, 1).toString();
							value3[1] = table.getValueAt(rownum, 2).toString();
							value3[2] = table.getValueAt(rownum,3).toString();
							value3[3] = table.getValueAt(rownum, 4).toString();
							value3[4] = table.getValueAt(rownum, 5).toString();
							value3[5] = table.getValueAt(rownum,6).toString();
							value3[6] = table.getValueAt(rownum,7).toString();
							
							
						    int i = JOptionPane.showConfirmDialog(null,"ȷ��Ҫ�޸��û�"+value3[0]+"��","������ʾ",JOptionPane.YES_NO_OPTION);
									System.out.println(i);
									if(i==0){							 
										//-----------------------������֤	
											if(value3[0].length()==0){
										    	JOptionPane.showMessageDialog(null, "�������Ʋ���Ϊ�գ�","������ʾ",JOptionPane.INFORMATION_MESSAGE);							    	
										    	return;
										    }
							           //-----------------------������֤								
										    if(value3[1].length()==0){
										    	JOptionPane.showMessageDialog(null, "�������Ͳ���Ϊ�գ�","������ʾ",JOptionPane.INFORMATION_MESSAGE);							    	
										    	return;
										    }
										//�����ݿ����޸���Ϣ
										    String id=table.getValueAt(rownum, 0).toString();						
										Connection con = null;
										try {
											con = Conn.getConnect();
										} catch (SQLException e2) {
											e2.printStackTrace();
										}
								
									    String sql1 = "update wages set name=?,basepay=?,meritpay=?,tip=?,subsidy=?,personaltax=?,remark=? where id=?";
									    
										PreparedStatement ps=null;
												try {
												   ps=con.prepareStatement(sql1);
												  System.out.println("gggggggggggggggggggggggggg");	
												   
												  ps.setString(1,value3[0]);	 
												  ps.setString(2,value3[1]);
												  ps.setString(3,value3[2]); 
												  ps.setString(4,value3[3]);
												  ps.setString(5,value3[4]); 
												  ps.setString(6,value3[5]);
												  ps.setString(7,value3[6]); 
												  ps.setString(8,id);
												  
												  System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+value3[0]+" "+value3[1]+" "+value3[2]+" ");
											   int k=ps.executeUpdate();//�����ݿ��¼Ӱ�������		
											   System.out.println("******1****"+sql1);
												   if(i>0){
													   String infos3="�����޸ĳɹ���";
														JOptionPane.showMessageDialog(null,infos3,"������ʾ",
																JOptionPane.INFORMATION_MESSAGE);
													
												   }
												} catch (SQLException e1) {
													
													e1.printStackTrace();
												}
								}
									dispose();
									ManagerMainTest4 y = new ManagerMainTest4();
									System.out.println("�޸�"+i);
									
								}
				});
		
		//---------�˳���ť--------------
		final JButton exitButton = new JButton();
	exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Homepage tt=new Homepage();
			}
		});
		exitButton.setText("�˳�");
		buttonPanel.add(exitButton);
		
		

	
		//����ʵ��
		final JScrollPane scrollpane= new JScrollPane();//�������������
	
		getContentPane().add(scrollpane,BorderLayout.CENTER);//�ѹ����������������
		 tableColumnV = new Vector<String>();//���ı�������
	
		String tableColumns[]={"���","����","��������","��Ч����","���","����","����˰","��ע","ʵ�ù���"};
		for(int column=0;column<tableColumns.length;column++){
			tableColumnV.add(tableColumns[column]);
			
		}
		tableValueV = new Vector<Vector<Object>>();//������ֵ���ݱ��
    
     
		tableValueV=UserDAO5.getAllUsers4();//��ȡ�����û���Ϣ
		
	
//		�����i����map�й�����ɾ��ʹ��
		 mapids=new HashMap();
        for(int i=0;i<tableValueV.size();i++){
    	   Vector<Object> v=tableValueV.get(i);
    	   mapids.put(Integer.parseInt(v.get(0).toString()),v.get(9).toString());
       }
		
		
		
		
		
		
		tableModel=new DefaultTableModel(tableValueV,tableColumnV);//���ģ��
		 table=new Mtable(tableModel);//�ѱ��ģ�ͷ�������
		if(table.getRowCount()>0)
			table.setRowSelectionInterval(0,0);//�������ñ���б�ѡ��
		scrollpane.setViewportView(table);
	
		

		
		
		this.setVisible(true);
	}
	
	
	
	
}
