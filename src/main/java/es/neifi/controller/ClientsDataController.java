package es.neifi.controller;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import es.neifi.model.PostgreSQLClients;


@SuppressWarnings("serial")
public class ClientsDataController extends AbstractTableModel implements TableModelListener{
	
	private int rows;
	private int columns;
	private ResultSet data;
	private ResultSetMetaData metadata;
	private PostgreSQLClients sq = new PostgreSQLClients();
	
	
	public ClientsDataController() {
		try {
			data = sq.select();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public int getRowCount() {
		
		try {
			
			
			data.last();


			rows = data.getRow();
			return rows;
		} catch (Exception e) {
			
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public int getColumnCount() {
		try {
			
			metadata = data.getMetaData();
			
			columns = metadata.getColumnCount();
			return columns;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Object getValueAt(int rowI, int columI) {
		try {
			data.absolute(rowI+1);
			return data.getObject(columI+1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String getColumnName(int colum) {
		try {
			return metadata.getColumnName(colum+1);
		} catch (Exception e) {
			
		}
		return null;
		
	}
	
	@Override
	public void tableChanged(TableModelEvent e) {
		if (e.getType() == TableModelEvent.ALL_COLUMNS) {
			System.out.println("changed");
			
		}
		
	}

}
