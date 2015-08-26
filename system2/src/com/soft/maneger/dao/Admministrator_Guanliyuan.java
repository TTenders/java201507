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

import javax.swing.AbstractButton;
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

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Admministrator_Guanliyuan extends JDialog{
	private JTextField nameTextField;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField birthdayTextField;
	private JTextField passwordTextField;
	private JTextField idCardTextField;
	DefaultTableModel tableModel;
	private Vector<String> tableColumnV;
	private Vector<Vector<Object>> tableValueV;
	private usersDAO_Guanliyuan dao = new usersDAO_Guanliyuan();	
	private  Mtable table;
	private Map<Integer,String> mapids;
	public static void main(String[] args) {
		Admministrator_Guanliyuan mm = new Admministrator_Guanliyuan();
	}
	
	public Admministrator_Guanliyuan(){
		
		super();
		setModal(true);
		setTitle("����Ա");
		setBounds(100, 100, 800, 375);
			
		final JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridBagLayout());
		getContentPane().add(inputPanel, BorderLayout.NORTH);
		
		final JLabel nameLabel = new JLabel();
		nameLabel.setText("������");
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
	
		final JLabel birthdayLabel = new JLabel();
		birthdayLabel.setText("���룺");
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
		
		
		final JLabel passwordLabel = new JLabel();
		passwordLabel.setText("���˼�飺");
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
		final JButton subButton = new JButton();
		
//--------��Ӱ�ť
subButton.setText("���");
buttonPanel.add(subButton);
		subButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//��ҳ��������û���Ϣ������������
				String values[] = new String[4];
				values[0] = nameTextField.getText();		
				values[1] = birthdayTextField.getText();
				values[2] = passwordTextField.getText();
//���벻�ܳ���6λ				
				if(values[1].length()>6){
					
					JOptionPane.showMessageDialog(null,"���벻�ܳ���6λ��","������ʾ",JOptionPane.INFORMATION_MESSAGE);
					passwordTextField.setText("");	
					passwordTextField.requestFocus();	
					return;
				}
//���벻��Ϊ��				
                if(values[1].length()==0){
					
					JOptionPane.showMessageDialog(null,"���벻��Ϊ�գ�","������ʾ",JOptionPane.INFORMATION_MESSAGE);
					passwordTextField.setText("");	
					passwordTextField.requestFocus();	
					return;
				}
				boolean tt;
				
				try {
					tt=dao.inserUser(values);
					System.out.println("hhhhhhh");
					if(tt){
						String infos3="����Ա��ӳɹ���";
				JOptionPane.showMessageDialog(null,infos3,"������ʾ",
						JOptionPane.INFORMATION_MESSAGE);
				
				//-------------����ı���--
				nameTextField.setText("");
				nameTextField.requestFocus();				
				birthdayTextField.setText("");
				birthdayTextField.requestFocus();
				passwordTextField.setText("");
				passwordTextField.requestFocus();
				setVisible(false);
				Admministrator_Guanliyuan g =new Admministrator_Guanliyuan();
				
					}
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}					
		});
	
//---ɾ����ť--------------
	final JButton delButton = new JButton();
	delButton.setText("ɾ��");	
	buttonPanel.add(delButton);
	
	delButton.addActionListener (new ActionListener(){
		public void actionPerformed(ActionEvent e){
		//��ɾ��¼���к�
	    int rownum = table.getSelectedRow();
	   if(rownum==-1){
		   String infos4="��ѡ�в���!";
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
					System.out.println("________________id:"+id);
					dao.delUsresbyId4(id);
					
					//�ѱ����Ҫɾ��������ɾ��
					tableModel.removeRow(rownum);
					String infos4="ɾ���ɹ���";
					JOptionPane.showMessageDialog(null,infos4,"������ʾ",
							JOptionPane.INFORMATION_MESSAGE);
				}
				System.out.println("ɾ��"+i);
		}
	});
	
//---�޸İ�ť--------------
	final JButton updButton1 = new JButton();
	updButton1.setText("�޸�");	
	buttonPanel.add(updButton1);		
	updButton1.addActionListener (new ActionListener(){
		public void actionPerformed(ActionEvent e){
			int rownum = table.getSelectedRow();
			
			   if(rownum==-1){
				   String infos4="��ѡ�в���!";
					JOptionPane.showMessageDialog(null,infos4,"������ʾ",
							JOptionPane.INFORMATION_MESSAGE);
					return;
			   }
			   String value3[] = new String[5];	 
				value3[0] = table.getValueAt(rownum, 1).toString();
				value3[1] = table.getValueAt(rownum, 2).toString();
				value3[2] = table.getValueAt(rownum,3).toString();
				 
				
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
							String id = (String) mapids.get(Integer.parseInt(String.valueOf(rownum+1)));							
							Connection con = null;
							try {
								con = Conn.getConnect();
							} catch (SQLException e2) {
								e2.printStackTrace();
							}
					
						    String sql1 = "update Admministrator set username=?,password=?,dintro=? where id=?";
						    
							PreparedStatement ps=null;
									try {
									   ps=con.prepareStatement(sql1);
									  System.out.println("gggggggggggggggggggggggggg");	
									   
									  ps.setString(1,value3[0]);	 
									  ps.setString(2,value3[1]);
									  ps.setString(3,value3[2]); 
									  ps.setString(4,id);
									  
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
						Admministrator_Guanliyuan mm = new Admministrator_Guanliyuan();
						System.out.println("�޸�"+i);
						
		}
	});
//---------�˳���ť--------------
		final JButton exitButton = new JButton();
		exitButton.setText("�˳�");
		buttonPanel.add(exitButton);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			Homepage nn = new Homepage();	
			
					
			}				
		});
		
	
		
//-----����ʵ��
		
		final JScrollPane scrollPane = new JScrollPane();//��������������
        getContentPane().add(scrollPane,BorderLayout.CENTER);	
        
         table = new Mtable();
        tableColumnV = new Vector<String>();       
        tableColumnV.add("���");
        tableColumnV.add("����");
        tableColumnV.add("����");
        tableColumnV.add("���˼��");
      
        tableValueV = new Vector<Vector<Object>>();//���������
        
         tableValueV = usersDAO_Guanliyuan.getAllUsers();//��ȡ��Ϣ
         
         //�����idֵ����map�й�����ɾ��ʹ�ú�
         
         mapids=new HashMap();         
         for(int i=0;i<tableValueV.size();i++){
       	  Vector<Object> v =tableValueV.get(i);
       	 mapids.put(Integer.parseInt(v.get(0).toString()),v.get(4).toString()); 
         }
        
		 tableModel = new DefaultTableModel(tableValueV,tableColumnV);//�����		
         table = new Mtable(tableModel);//���ģ�ͷ�������
         if(table.getRowCount()>0)
 			table.setRowSelectionInterval(0,0);//�������ñ���б�ѡ�� 
        scrollPane.setViewportView(table);
		this.setVisible(true);
	}
}

