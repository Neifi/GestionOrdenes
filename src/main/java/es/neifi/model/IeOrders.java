package es.neifi.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IeOrders {
	 public ResultSet select() throws SQLException;


	    public int update(Order user) throws SQLException;

	    public int delete(Order user) throws SQLException;

		int insert(Order order, OrderList orderList) throws SQLException;
}
