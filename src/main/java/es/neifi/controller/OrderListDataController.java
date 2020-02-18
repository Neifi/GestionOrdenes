package es.neifi.controller;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import es.neifi.model.DependencyInjection;
import es.neifi.model.OrderListTableModel;
import es.neifi.model.PostgreSQLClients;
import es.neifi.model.PostgresSQLOrderList;
import es.neifi.model.PostgresSQLOrders;
import es.neifi.model.SQLite;
import es.neifi.model.XmlReader;

@SuppressWarnings("serial")
public class OrderListDataController extends AbstractTableModel implements TableModelListener {
	
	private OrderListTableModel orderListTableModel;
	private int rows;
	private int columns;
	private ResultSet data;
	private ResultSetMetaData metadata;
	private DependencyInjection dependencyInjection;
	private final String[] COL_NAMES = { "Client Id", "Order Id", "Status" };
	
	{
		dependencyInjection = new DependencyInjection(new PostgresSQLOrders(), new PostgresSQLOrderList());
	}
	
	public OrderListDataController(int id)  {
		try {
			orderListTableModel = new OrderListTableModel();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data = orderListTableModel.selectOrderList(id);
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
			
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Object getValueAt(int rowI, int columI) {
		try {
			data.absolute(rowI + 1);
			return data.getObject(columI + 1);
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getColumnName(int colum) {
		try {
			return metadata.getColumnName(colum + 1);
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
