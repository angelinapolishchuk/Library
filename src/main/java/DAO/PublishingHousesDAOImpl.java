package DAO;

import ConnectionPool.ConnectionPool;
import Hierarcy.PublishingHouses;
import interfacesDAO.PublishingHousesDAO;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PublishingHousesDAOImpl implements PublishingHousesDAO {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(PublishingHousesDAOImpl.class));
    public static final String AllPublishingHouses = "SELECT * FROM PublishingHouses";
    public static final String UPDATE = "UPDATE PublishingHouses SET PublishingHouseName = ? WHERE PublishingHouseId = ?";
    public static final String DELETE = "DELETE FROM PublishingHouses WHERE PublishingHouseId = ?";
    public static final String CREATE = "INSERT INTO PublishingHouses (PublishingHouseName, int PublishingHousesId) " +
            "VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<PublishingHouses> getAll() {
        List<PublishingHouses> publishingHouses = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(AllPublishingHouses);
            while (resultSet.next()) {
                int PublishingHouseId = resultSet.getInt(1);
                String PublishingHouseName = resultSet.getString(2);
                publishingHouses.add(new PublishingHouses(PublishingHouseId,PublishingHouseName));
            }
            LOGGER.info("PublishingHouses" + publishingHouses);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return publishingHouses;
    }

    @Override
    public boolean update(PublishingHouses entity) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setInt(1, entity.getPublishingHouseId());
            ps.setString(2, entity.getPublishingHouseName());
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
            String del = "DELETE FROM PublishingHouses WHERE PublishingHouseId = " + id;
            ps.executeUpdate(del);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean create(PublishingHouses entity) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(CREATE);
            ps.setInt(1, entity.getPublishingHouseId());
            ps.setString(2, entity.getPublishingHouseName());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }


}
