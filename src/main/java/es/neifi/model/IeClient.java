package es.neifi.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IeClient {

    public ResultSet select() throws SQLException;

    public int insert(Client user) throws SQLException;

    public int update(Client user) throws SQLException;

    public int delete(Client user) throws SQLException;

}