package com.soft.maneger.tool;

import javax.swing.JTable;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class Mtable extends JTable{
	public Mtable(){
		super();
	}
public Mtable(DefaultTableModel tableModel){
	super(tableModel);
}


public ListSelectionModel getSelectionModel(){
	ListSelectionModel selectionMOdel=super.getSelectionModel();
	selectionMOdel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	//ªÚ’ﬂselectionMOdel.setSelectionMode(0);
	return selectionMOdel;
}






}
