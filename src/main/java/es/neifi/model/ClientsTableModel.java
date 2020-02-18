package es.neifi.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ClientsTableModel {

	private static ArrayList<Client> clientsToDelete = new ArrayList<>();
	private static ArrayList<Client> clientsToAdd = new ArrayList<>();
	private static ArrayList<Client> clientsToUpdate = new ArrayList<>();
	private static PostgreSQLClients psql = new PostgreSQLClients();

	private XmlReader xmlReader;
	
	public ClientsTableModel() {
		
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

	public void toDelete(String id) {
		Client client = new Client(id);
		clientsToDelete.add(client);
	}
	

	public void toInsert(ArrayList<String> data) {
		try {
		String id = data.get(0);
		String businessName = data.get(1);
		String country = data.get(2);
		String postalAdress = data.get(3);
		String zipCode = data.get(4);
		String email = data.get(5);
		String phoneNumber = data.get(6);
		String iban = data.get(7);
		Client client = new Client(id, businessName, country, postalAdress, zipCode, email, phoneNumber, iban);
			clientsToAdd.add(client);
			
		}
		catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, "Rellene los campos obligatorios");
			e.printStackTrace();
		}
	}
	public void toUpdate(ArrayList<String> data) {
		try {
			String id = data.get(0);
			String businessName = data.get(1);
			String country = data.get(2);
			String postalAdress = data.get(3);
			String zipCode = data.get(4);
			String email = data.get(5);
			String phoneNumber = data.get(6);
			String iban = data.get(7);
			
			Client client = new Client(id, businessName, country, postalAdress, zipCode, email, phoneNumber, iban);
			clientsToUpdate.add(client);
			
		}
		catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, "Rellene los campos obligatorios");
			e.printStackTrace();
		}
	}

	public void deleteClient() {
		if (!clientsToDelete.isEmpty()) {
			for (Client client : clientsToDelete) {
				try {
					psql.delete(client);
					//TODO SelectClients();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} 
	}

	

	public void insertClient() {
		if (!clientsToAdd.isEmpty()) {
			for (Client client : clientsToAdd) {
				try {
					psql.insert(client);
				} catch (SQLException e ) {
					
					e.printStackTrace();
				}
			}
			clientsToAdd.clear();
		}
	}
	public void updateClient() {
		if (!clientsToUpdate.isEmpty()) {
			for (Client client : clientsToUpdate) {
				try {
					psql.update(client);
					JOptionPane.showMessageDialog(null, "Cambios realizados correctamente");
				} catch (SQLException e ) {
					
					e.printStackTrace();
				}
			}
			clientsToUpdate.clear();
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
