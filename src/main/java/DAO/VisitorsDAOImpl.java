package DAO;

import ConnectionPool.ConnectionPool;
import Hierarcy.Storages;
import Hierarcy.Visitors;
import interfacesDAO.VisitorsDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class VisitorsDAOImpl implements VisitorsDAO {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(VisitorsDAOImpl.class));
    public static final String AllVisitors = "SELECT * FROM Visitors";
    public static final String UPDATE = "UPDATE Visitors SET VisitorName = ? WHERE VisitorId = ?";
    public static final String DELETE = "DELETE FROM Visitors WHERE VisitorId = ?";
    public static final String CREATE = "INSERT INTO Visitors (VisitorId, VisitorName, VisitorAge, CardId) " +
            "VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<Visitors> getAll() {
        List<Visitors> visitors = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(AllVisitors);
            while (resultSet.next()) {
                int VisitorId = resultSet.getInt(1);
                String VisitorName = resultSet.getString(2);
                int VisitorAge = resultSet.getInt(3);
                int CardId = resultSet.getInt(4);

                visitors.add(new Visitors(VisitorId, VisitorName, VisitorAge, CardId));
            }
            LOGGER.info("Visitors" + visitors);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return visitors;
    }

    @Override
    public boolean update(Visitors entity) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setInt(1, entity.getVisitorId());
            ps.setString(2, entity.getVisitorName());
            ps.setInt(3, entity.getVisitorAge());
            ps.setInt(4, entity.getCardId());
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
            String del = "DELETE FROM Visitors WHERE VisitorId = " + id;
            ps.executeUpdate(del);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean create(Visitors entity) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(CREATE);
            ps.setInt(1, entity.getVisitorId());
            ps.setString(2, entity.getVisitorName());
            ps.setInt(3, entity.getVisitorAge());
            ps.setInt(4, entity.getCardId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }


}
