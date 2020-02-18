package es.neifi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.neifi.controller.OrdersDataController;

/**
 * 
 * @author neifi
 *
 */
public class PostgreSQLClients implements IeClient {

	private static final String SELECT = "SELECT * FROM clients";
	private static final String DELETE = "DELETE FROM clients where id = ?";
	private static final String INSERT = "INSERT INTO clients (id,businesname,country,postaladress,zip,email,phone,iban,isdefaulter) VALUES (?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE clients SET businesname = ?,country = ? ,postaladress = ? ,zip = ? ,email = ? ,phone = ? ,iban = ? WHERE id = ?";

	public PostgreSQLClients() {

	}

	@Override
	public ResultSet select() throws SQLException {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		// List<Client> clientList = new ArrayList<>();

		try {
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(SELECT, PreparedStatement.RETURN_GENERATED_KEYS,
					ResultSet.TYPE_SCROLL_INSENSITIVE);
			rs = stmt.executeQuery();
			
			return rs;

//			while (rs.next()) {
//				String id = rs.getString("client_id");
//				String name = rs.getString("name");
//				String surname = rs.getString("surname");
//				String email = rs.getString("email");
//				String phone = rs.getString("phoneNumber");
//				String postalAdress = rs.getString("postalAdress");
//				String zipCode = rs.getString("zipCode");
//				String birdDate = rs.getString("birdDate");
//				String isDefaulter = rs.getString("isDefaulter");
//				

			// clientList.add(new
			// Client(id,name,surname,email,isDefaulter,phone,birdDate,postalAdress,zipCode));

//			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			PostgreSQLConnection.closeConnection(conn);
		}

	}

	@Override
	public int insert(Client client) throws SQLException {

		int rows = 0;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(INSERT);
			stmt.setString(1, client.getId());
			stmt.setString(2, client.getBusinessName());
			stmt.setString(3, client.getCountry());
			stmt.setString(4, client.getPostalAdress());
			stmt.setString(5, client.getZipCode());
			stmt.setString(6, client.getEmail());
			stmt.setString(7, client.getPhoneNumber());
			stmt.setString(8, client.getIban());
			stmt.setString(9, "false");

			rows = stmt.executeUpdate();
			System.out.println(rows + " ROWS AFFECTED!");

		} finally {

			PostgreSQLConnection.closeStmt(stmt);
			PostgreSQLConnection.closeConnection(conn);
		}
		return rows;
	}

	@Override
	public int update(Client client) throws SQLException {
		int rows = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(UPDATE);

			stmt.setString(8, client.getId());
			stmt.setString(1, client.getBusinessName());
			stmt.setString(2, client.getCountry());
			stmt.setString(3, client.getPostalAdress());
			stmt.setString(4, client.getZipCode());
			stmt.setString(5, client.getEmail());
			stmt.setString(6, client.getPhoneNumber());
			stmt.setString(7, client.getIban());

			rows = stmt.executeUpdate();
			System.out.println(rows + " ROWS AFFECTED");

		} finally {

			PostgreSQLConnection.closeStmt(stmt);
		}
		return rows;
	}

	@Override
	public int delete(Client client) throws SQLException {
		int rows = 0;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(DELETE);
			stmt.setString(1, client.getId());

			rows = stmt.executeUpdate();
			System.out.println(rows + " ROWS AFFECTED!");
		} finally {

			PostgreSQLConnection.closeStmt(stmt);
		}
		return rows;
	}

}
