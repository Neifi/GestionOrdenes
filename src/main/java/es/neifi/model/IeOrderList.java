package es.neifi.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IeOrderList {

	public int delete(OrderList user) throws SQLException;

	int insert(OrderList orderList) throws SQLException;;

	int update(OrderList orderList);

	ResultSet select(int id) throws SQLException;

}
