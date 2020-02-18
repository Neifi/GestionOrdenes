package es.neifi.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class OrderListTableModel {

	private static PostgresSQLOrderList psql = new PostgresSQLOrderList();


	public OrderListTableModel() throws SQLException {
		

	}

	public ResultSet selectOrderList(int id) {

		ResultSet data;
		try {
			data = psql.select(id);
			return data;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}

}
