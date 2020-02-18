package es.neifi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgresSQLOrders implements IeOrders {

	private static final String SELECT = "SELECT * FROM orders";
	private static final String DELETE = "DELETE FROM orders where id = ?";
	private static final String INSERT_ORDER = "INSERT INTO orders (clientId,orderId,status) VALUES (?,?,?)";
	// private static final String INSERT_ORDER_LIST = "INSERT INTO orderList
	// (qty,servedUnits,status,orderId) VALUES (?,?,?,?)";
	private static final String UPDATE = "UPDATE orderList SET servedUnits = ? WHERE id = ?";
	private PostgresSQLOrderList postgresSQLOrderList;

	public PostgresSQLOrders() {
		postgresSQLOrderList = new PostgresSQLOrderList();
	}

	@Override
	public ResultSet select() throws SQLException {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			System.out.println("[INFO] Ejecutando select");
			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(SELECT, PreparedStatement.RETURN_GENERATED_KEYS,
					ResultSet.TYPE_SCROLL_INSENSITIVE);
			rs = stmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;
	}

	/**
	 * @author neifi
	 * @param order     la orden a insertar.
	 * @param orderList la orderList referente a esa order. Inserta una order, si la
	 *                  ejecucion se ejecuta correctamente se inserta una orderList.
	 */
	
	//@override
	public int insert(Order order) {
		System.out.println("[INFO] Ejecutando insert");
		int rows = 0;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = PostgreSQLConnection.getConnection();
			stmt = conn.prepareStatement(INSERT_ORDER);
			stmt.setString(1, order.getClient_id());
			stmt.setString(2, order.getOrder_id());
			stmt.setString(3, order.getStatus());
			rows = stmt.executeUpdate();

			// -3 indica que se ejecuto correctamente
		
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			PostgreSQLConnection.closeStmt(stmt);
			PostgreSQLConnection.closeConnection(conn);
		}
		return rows;
	}

	@Override
	public int update(Order user) throws SQLException {
		return 0;
	}

	@Override
	public int delete(Order user) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Order order, OrderList orderList) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
