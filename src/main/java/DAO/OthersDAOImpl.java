package DAO;

import ConnectionPool.ConnectionPool;
import Hierarcy.Books;
import Hierarcy.Others;
import interfacesDAO.OthersDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class OthersDAOImpl implements OthersDAO {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(OthersDAOImpl.class));
    public static final String AllOthers = "SELECT * FROM Others";
    public static final String UPDATE = "UPDATE Others SET OtherTitle = ? WHERE OtherId = ?";
    public static final String DELETE = "DELETE FROM Others WHERE OtherId = ?";
    public static final String CREATE = "INSERT INTO Others (OtherId, OtherType, OtherTitle, OtherAuthor, LibraryId) " +
            "VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<Others> getAll() {
        List<Others> others = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(AllOthers);
            while (resultSet.next()) {
                int OtherId = resultSet.getInt(1);
                String OtherType = resultSet.getString(2);
                String OtherTitle = resultSet.getString(3);
                String OtherAuthor = resultSet.getString(4);
                int LibraryId = resultSet.getInt(5);

                others.add(new Others(OtherId, OtherType, OtherTitle, OtherAuthor, LibraryId));
            }
            LOGGER.info("Others" + others);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return others;
    }

    @Override
    public boolean update(Others entity) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setInt(1, entity.getOtherId());
            ps.setString(2, entity.getOtherType());
            ps.setString(3, entity.getOtherTitle());
            ps.setString(4, entity.getOtherAuthor());
            ps.setInt(5, entity.getLibraryId());
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
            String del = "DELETE FROM others WHERE OtherId = " + id;
            ps.executeUpdate(del);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean create(Others entity) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(CREATE);
            ps.setInt(1, entity.getOtherId());
            ps.setString(2, entity.getOtherType());
            ps.setString(3, entity.getOtherTitle());
            ps.setString(4, entity.getOtherAuthor());
            ps.setInt(5, entity.getLibraryId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }


}
