package interfacesDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IBaseDAO<T> {

    List<T> getAll() throws SQLException, IOException;
    boolean update(T entity) throws SQLException, IOException;
    boolean delete(long id) throws SQLException, IOException;
    boolean create(T entity) throws SQLException, IOException;
}

