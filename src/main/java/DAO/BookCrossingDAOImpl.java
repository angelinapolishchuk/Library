package DAO;

import ConnectionPool.ConnectionPool;
import Hierarcy.BookCrossing;
import interfacesDAO.BookCrossingDAO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BookCrossingDAOImpl implements BookCrossingDAO {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(BookCrossingDAOImpl.class));
    public static final String ALLBookCrossing = "SELECT * FROM BookCrossing";
    public static final String UPDATE = "UPDATE BookCrossing SET OwnerName = ? WHERE BookCrossingId = ?";
    public static final String DELETE = "DELETE FROM BookCrossing WHERE BookCrossingId = ?";
    public static final String CREATE = "INSERT INTO BookCrossing (BookCrossingId, OwnerName, LibraryId) " +
            "VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<BookCrossing> getAll() {
        List<BookCrossing> bookCrossing = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(ALLBookCrossing);
            while (resultSet.next()) {
                int BookCrossingId = resultSet.getInt(1);
                String OwnerName = resultSet.getString(2);
                int LibraryId = resultSet.getInt(3);

                bookCrossing.add(new BookCrossing(BookCrossingId, OwnerName, LibraryId));
            }
            LOGGER.info("BookCrossing" + bookCrossing);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return bookCrossing;
    }

    @Override
    public boolean update(BookCrossing entity) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setInt(1, entity.getBookCrossingId());
            ps.setString(2, entity.getOwnerName());
            ps.setInt(3, entity.getLibraryId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean delete(long id) {
        try (Connection connection = ConnectionPool.getConnection()) {
            Statement ps = connection.createStatement();
            String del = "DELETE FROM BookCrossing WHERE BookCrossingId = " + id;
            ps.executeUpdate(del);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean create(BookCrossing entity) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(CREATE);
            ps.setInt(1, entity.getBookCrossingId());
            ps.setString(2, entity.getOwnerName());
            ps.setInt(3, entity.getLibraryId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }


}
