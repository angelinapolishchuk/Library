package DAO;

import ConnectionPool.ConnectionPool;
import Hierarcy.Genres;
import Hierarcy.Libraries;
import interfacesDAO.LibrariesDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LibrariesDAOImpl implements LibrariesDAO {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(LibrariesDAOImpl.class));
    public static final String AllLibraries = "SELECT * FROM Libraries";
    public static final String UPDATE = "UPDATE Libraries SET LibraryName = ? WHERE LibraryId = ?";
    public static final String DELETE = "DELETE FROM Libraries WHERE LibraryId = ?";
    public static final String CREATE = "INSERT INTO Libraries (LibraryName, int LibraryId) " +
            "VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<Libraries> getAll() {
        List<Libraries> libraries = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(AllLibraries);
            while (resultSet.next()) {
                int LibraryId = resultSet.getInt(1);
                String LibraryName = resultSet.getString(2);
                libraries.add(new Libraries(LibraryName,LibraryId));
            }
            LOGGER.info("Libraries" + libraries);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return libraries;
    }

    @Override
    public boolean update(Libraries entity) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setInt(1, entity.getLibraryId());
            ps.setString(2, entity.getLibraryName());
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
            String del = "DELETE FROM Libraries WHERE LibraryId = " + id;
            ps.executeUpdate(del);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean create(Libraries entity) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(CREATE);
            ps.setInt(1, entity.getLibraryId());
            ps.setString(2, entity.getLibraryName());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }


}
