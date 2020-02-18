package es.neifi.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class OrdersTableModel {

	private static ArrayList<Order> ordersToAdd;
	private static ArrayList<OrderList> orderListToAdd;
	private static PostgresSQLOrders psql = new PostgresSQLOrders();
	private static PostgresSQLOrderList psqlList = new PostgresSQLOrderList();
	private XmlReader xmlReader;

	public OrdersTableModel() throws SQLException {
		xmlReader = new XmlReader();
		ordersToAdd = xmlReader.getOrdersArray();
		orderListToAdd = xmlReader.getOrderListArray();
		insertOrder();

	}

	public ResultSet selectOrders() {

		ResultSet data;
		try {
			data = psql.select();
			return data;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}

	public void insertOrder() throws SQLException {
		if (!ordersToAdd.isEmpty()) {
			for (Order order : ordersToAdd) {

				psql.insert(order);
			}
			for (OrderList orderList : orderListToAdd) {
				psqlList.insert(orderList);
			}

			ordersToAdd.clear();
		}
	}

	public void updateOrder() {
		if (!ordersToAdd.isEmpty()) {
			for (Order order : ordersToAdd) {
				try {
					psql.update(order);
					JOptionPane.showMessageDialog(null, "Cambios realizados correctamente");
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			ordersToAdd.clear();
		}
	}

//	public static int getClientRows() {
//		try {
//			clients = sQlite.select();
//			int rows = clients.size();
//			return rows;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return 0; 
//		}
//	}

//	private static String[][] putData() {
//
//		clientListSize = clients.size();
//		data = new String[clientListSize][9];
//
//		int i = 0;
//		for (Client client : clients) {
//			for (int j = 0; j < 1; j++) {
//				data[i][0] = client.getId();
//				data[i][1] = client.getName();
//				data[i][2] = client.getSurName();
//				data[i][3] = client.getEmail();
//				data[i][4] = client.getPhoneNumber();
//				data[i][5] = client.getPostalAdress();
//				data[i][6] = client.getBirdDate();
//				data[i][7] = client.getZipCode();
//				data[i][8] = client.getBirdDate();
//				i += 1;
//			}
//
//		}
//
//		return data;
//
//	}

}
