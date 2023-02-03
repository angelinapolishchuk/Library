package DAO;

import ConnectionPool.ConnectionPool;
import Hierarcy.Others;
import Hierarcy.Storages;
import interfacesDAO.StoragesDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StoragesDAOImpl implements StoragesDAO {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(StoragesDAOImpl.class));
    public static final String AllStorages = "SELECT * FROM Storages";
    public static final String UPDATE = "UPDATE Storages SET StorageType = ? WHERE StorageId = ?";
    public static final String DELETE = "DELETE FROM Storages WHERE StorageId = ?";
    public static final String CREATE = "INSERT INTO Storages (StorageId, StorageType, LibraryId) " +
            "VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<Storages> getAll() {
        List<Storages> storages = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(AllStorages);
            while (resultSet.next()) {
                int StorageId = resultSet.getInt(1);
                String StorageType = resultSet.getString(2);
                int LibraryId = resultSet.getInt(3);

                storages.add(new Storages(StorageId, StorageType, LibraryId));
            }
            LOGGER.info("Storages" + storages);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return storages;
    }

    @Override
    public boolean update(Storages entity) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setInt(1, entity.getStorageId());
            ps.setString(2, entity.getStorageType());
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
            String del = "DELETE FROM Storages WHERE StorageId = " + id;
            ps.executeUpdate(del);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean create(Storages entity) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(CREATE);
            ps.setInt(1, entity.getStorageId());
            ps.setString(2, entity.getStorageType());
            ps.setInt(3, entity.getLibraryId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }


}
