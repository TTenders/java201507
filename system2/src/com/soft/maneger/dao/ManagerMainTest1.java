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
		setTitle("Ա������");
		setBounds(100, 100, 800, 375);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//���ùرյ�ǰ���ڵ�ͬʱҲ�رտ���̨�Ľ���
				
		final JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridBagLayout());
		getContentPane().add(inputPanel, BorderLayout.NORTH);
		//�ӱ�ǩ
		final JLabel nameLabel = new JLabel();
		nameLabel.setText("��    ����");
		final GridBagConstraints gridBagConstraints_13 = new GridBagConstraints();
		gridBagConstraints_13.insets = new Insets(10, 0, 0, 0);
		inputPanel.add(nameLabel, gridBagConstraints_13);
		
		//�ı���
		nameTextField = new JTextField();
		nameTextField.setColumns(12);
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridx = 1;
		inputPanel.add(nameTextField, gridBagConstraints);
		
		//------�Ա�-------------------------------
		final JLabel sexLabel = new JLabel();
		sexLabel.setText("�Ա�");
		final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.insets = new Insets(10, 15, 0, 0);
		gridBagConstraints_1.gridy = 0;
		gridBagConstraints_1.gridx = 2;
		inputPanel.add(sexLabel, gridBagConstraints_1);
		
		//-------��ѡ��ť---------------------------
		final JRadioButton manRadioButton = new JRadioButton();
		buttonGroup.add(manRadioButton);
		manRadioButton.setText("��");
		manRadioButton.setSelected(true);
		final GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_2.gridy = 0;
		gridBagConstraints_2.gridx = 3;
		inputPanel.add(manRadioButton, gridBagConstraints_2);
		
		
		final JRadioButton womanRadioButton = new JRadioButton();
		buttonGroup.add(womanRadioButton);
		womanRadioButton.setText("Ů");
		final GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints_3.gridy = 0;
		gridBagConstraints_3.gridx = 4;
		inputPanel.add(womanRadioButton, gridBagConstraints_3);
		
		//-------��������-------------
		final JLabel birthdayLabel = new JLabel();
		birthdayLabel.setText("�������ڣ�");
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
		
		//---------����-----------------------------
		final JLabel passwordLabel = new JLabel();
		passwordLabel.setText("��¼���룺");
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
		
		//----���֤��---------------------------
		final JLabel idCardLabel = new JLabel();
		idCardLabel.setText("���֤�ţ�");
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
		
		//--------�����ڲ㰴ť���--------------------------------
		final JPanel buttonPanel = new JPanel();
		final GridBagConstraints gridBagConstraints_10 = new GridBagConstraints();
		gridBagConstraints_10.anchor = GridBagConstraints.EAST;
		gridBagConstraints_10.insets = new Insets(5, 0, 10, 0);
		gridBagConstraints_10.gridwidth = 7;
		gridBagConstraints_10.gridy = 2;
		gridBagConstraints_10.gridx = 0;
		inputPanel.add(buttonPanel, gridBagConstraints_10);
		
	    //---������ť-----------------
//��Ӱ�ť		
		final JButton subButton = new JButton();
		subButton.setText("���");
		buttonPanel.add(subButton);
		subButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��ҳ��������û���Ϣ������������
				String values[] = new String[6];
				values[0] = nameTextField.getText();
				values[1] = (manRadioButton.isSelected() ? "��" : "Ů");
				values[2] = birthdayTextField.getText();
				values[3] = idCardTextField.getText();
				values[4] = passwordTextField.getText();
				values[5]="����";
				if(values[0].length()>4){
				
					JOptionPane.showMessageDialog(null,"�������Ϊ�ĸ����֣�","������ʾ",JOptionPane.INFORMATION_MESSAGE);
					nameTextField.setText("");	
					nameTextField.requestFocus();	
					return;
				}
				
			if(!com.soft.maneger.tool.Validate.excute("[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}", values[2])){
				String infos[]={"�������ڸ�ʽ����","��ȷ��ʽΪ��2008-8-8"};
				JOptionPane.showMessageDialog(null,infos,"������ʾ",JOptionPane.INFORMATION_MESSAGE);
				birthdayTextField.setText("");	
				birthdayTextField.requestFocus();	
				//return;
			}
			
			
			if(values[4].length()>6){
				
				JOptionPane.showMessageDialog(null,"���벻�ܳ���6λ��","������ʾ",JOptionPane.INFORMATION_MESSAGE);
				passwordTextField.setText("");	
				passwordTextField.requestFocus();	
				return;
			}
			
			if(!com.soft.maneger.tool.Validate.excute(
					"(\\d){15,18}", values[3])){
				String infos[]={"���֤���������","���֤�ű���Ϊ15��18λ"};
				JOptionPane.showMessageDialog(null,infos,"������ʾ",JOptionPane.INFORMATION_MESSAGE);
				idCardTextField.setText("");	
				idCardTextField.requestFocus();	
				return;
			}
			//��֤ͨ��
		boolean tt;
		try{
			tt=user.insertUsers(values);
			if(tt){
				String infos[]={"��ӳɹ���"};
				JOptionPane.showMessageDialog(null,infos,"������ʾ",JOptionPane.INFORMATION_MESSAGE);
			//----------���----------
				nameTextField.setText("");	
				nameTextField.requestFocus();
				birthdayTextField.setText("");	
				passwordTextField.setText("");
				idCardTextField.setText("");	
		  //------------����ӵ�������ʾ�ڱ����--------
				dispose();
				ManagerMainTest1  mm=new ManagerMainTest1();
				
			}
		}
		catch(Exception e1){
				e1.printStackTrace();
			
		}
			}			
		});
	
//ɾ����ť
		final JButton delButton = new JButton();
		delButton.setText("ɾ��");
		buttonPanel.add(delButton);
		delButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				int selecteRow=table.getSelectedRow();//��¼��ɾ�����к�
				if(selecteRow==-1){
					   String infos4="��ѡ���û�!";
						JOptionPane.showMessageDialog(null,infos4,"������ʾ",
								JOptionPane.INFORMATION_MESSAGE);
						return;
				   }
				String name=table.getValueAt(selecteRow, 1).toString();
				
				int i=JOptionPane.showConfirmDialog(null,"ȷ��Ҫɾ���û�"+name+"?","������ʾ",JOptionPane.YES_NO_OPTION);
				
				if(i==0){
	       //�����ݿ���ɾ��������Ϣ			
				String id=mapids.get(Integer.parseInt(String.valueOf(selecteRow+1)));
				user.delUsersbyId(id);
			   tableModel.removeRow(selecteRow);
				JOptionPane.showMessageDialog(null,"ɾ���ɹ�","������ʾ",JOptionPane.INFORMATION_MESSAGE);
				System.out.println("ɾ��"+selecteRow+" "+i);
				}
			}
		});		

		//�޸İ�ť
		final JButton updButton = new JButton();
		updButton.setText("�޸�");	
		buttonPanel.add(updButton);		
		updButton.addActionListener (new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				int rownum = table.getSelectedRow();
				  if(rownum==-1){
					   String infos4="��ѡ��Ա��!";
						JOptionPane.showMessageDialog(null,infos4,"������ʾ",
								JOptionPane.INFORMATION_MESSAGE);
						return;
				   }
				   String value3[] = new String[5];	 
					value3[0] = table.getValueAt(rownum, 1).toString();
					value3[1] = table.getValueAt(rownum, 2).toString();
					value3[2] = table.getValueAt(rownum,3).toString();
					value3[3] = table.getValueAt(rownum,4).toString();
					value3[4] = table.getValueAt(rownum,5).toString();
					
				    int i = JOptionPane.showConfirmDialog(null,"ȷ��Ҫ�޸��û�"+value3[0]+"��","������ʾ",JOptionPane.YES_NO_OPTION);
							System.out.println(i);
							if(i==0){							 
								//-----------------------������֤	
									if(value3[0].length()==0){
								    	JOptionPane.showMessageDialog(null, "��������Ϊ�գ�","������ʾ",JOptionPane.INFORMATION_MESSAGE);							    	
								    	return;
								    }
					           //-----------------------������֤								
								    if(value3[3].length()==0){
								    	JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�","������ʾ",JOptionPane.INFORMATION_MESSAGE);							    	
								    	return;
								    }
								//�����ݿ����޸���Ϣ
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
									   int k=ps.executeUpdate();//�����ݿ��¼Ӱ�������		
									   System.out.println("******1****"+sql1);
										   if(i>0){
											   String infos33="Ա���޸ĳɹ���";
												JOptionPane.showMessageDialog(null,infos33,"������ʾ",
														JOptionPane.INFORMATION_MESSAGE);
												dispose();
												ManagerMainTest1 y = new ManagerMainTest1();
												System.out.println("�޸�"+i);
										   }
										} catch (SQLException e1) {
											
											e1.printStackTrace();
										}
						}
							
								                          				              
			}
		});
//�˳���ť
		final JButton exitButton = new JButton();
		exitButton.setText("�˳�");
		buttonPanel.add(exitButton);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Homepage de=new Homepage();
			}
		});

//����ʵ��
		final JScrollPane scrollpane= new JScrollPane();//�������������
	
		getContentPane().add(scrollpane,BorderLayout.CENTER);//�ѹ����������������
		 tableColumnV = new Vector<String>();//���ı�������
	
		String tableColumns[]={"���","����","�Ա�","��������","���֤��","ID"};
		for(int column=0;column<tableColumns.length;column++){
			tableColumnV.add(tableColumns[column]);
			
		}
		tableValueV = new Vector<Vector<Object>>();//������ֵ���ݱ��
      
     
		tableValueV=user.getAllUsers();//��ȡ�����û���Ϣ
		//�����i����map�й�����ɾ��ʹ��
		 mapids=new HashMap();
        for(int i=0;i<tableValueV.size();i++){
    	   Vector<Object> v=tableValueV.get(i);
    	   mapids.put(Integer.parseInt(v.get(0).toString()),v.get(5).toString());
       }
	
		tableModel=new DefaultTableModel(tableValueV,tableColumnV);//���ģ��
		 table=new Mtable(tableModel);//�ѱ��ģ�ͷ�������
		if(table.getRowCount()>0)
			table.setRowSelectionInterval(0,0);//�������ñ���б�ѡ��
		scrollpane.setViewportView(table);
	this.setVisible(true);
	}
	
}
