package es.neifi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgresSQLOrderList implements IeOrderList {

	private static final String SELECT = "SELECT * FROM orderlist WHERE orderid = ?";
	private static final String DELETE = "DELETE FROM orders where id = ?";
	private static final String INSERT_ORDER_LIST = "INSERT INTO orderList (orderid,articleid,qty,price,status,servedunits) VALUES (?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE orderList SET servedUnits = ? WHERE id = ?";

	public PostgresSQLOrderList() {

	}

	@Override
	public ResultSet select(int id) throws SQLException {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(SELECT, PreparedStatement.RETURN_GENERATED_KEYS,
					ResultSet.TYPE_SCROLL_INSENSITIVE);
			stmt.setString(1, String.valueOf(id));
			rs = stmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;
	}

	@Override
	public int update(OrderList orderList) {
		int rows = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(UPDATE);
			stmt.setInt(1,orderList.getServedUnits() );
			stmt.setInt(2, orderList.getOrderList_id());
			rows = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			PostgreSQLConnection.closeConnection(conn);
			PostgreSQLConnection.closeStmt(stmt);
		}
		return rows;
	}

	@Override
	public int delete(OrderList user) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(OrderList orderList) throws SQLException {
		System.out.println("[INFO] Ejecutando insert en la tabla orderlist");
		int rows = 0;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(INSERT_ORDER_LIST);
			stmt.setString(1, orderList.getOrder_id());
			stmt.setString(2, orderList.getArticleId());
			stmt.setString(3, String.valueOf(orderList.getQty()));
			stmt.setString(4, String.valueOf(orderList.getPrice()));
			stmt.setString(5, orderList.getStatus());
			stmt.setString(6, String.valueOf(orderList.getServedUnits()));
			
			rows = stmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			PostgreSQLConnection.closeStmt(stmt);
			PostgreSQLConnection.closeConnection(conn);
		}
		return rows;
		
	}

}
