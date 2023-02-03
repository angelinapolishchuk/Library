package DAO;

import ConnectionPool.ConnectionPool;
import Hierarcy.Visitors;
import Hierarcy.Workers;
import interfacesDAO.WorkersDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class WorkersDAOImpl implements WorkersDAO {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(WorkersDAOImpl.class));
    public static final String AllWorkers = "SELECT * FROM Workers";
    public static final String UPDATE = "UPDATE Workers SET WorkersName = ? WHERE WorkerId = ?";
    public static final String DELETE = "DELETE FROM Workers WHERE WorkerId = ?";
    public static final String CREATE = "INSERT INTO Workers (WorkerId, WorkerName, WorkerAge, Position, LibraryId) " +
            "VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<Workers> getAll() {
        List<Workers> workers = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(AllWorkers);
            while (resultSet.next()) {
                int WorkerId = resultSet.getInt(1);
                String WorkerName = resultSet.getString(2);
                int WorkerAge = resultSet.getInt(3);
                String Position = resultSet.getString(4);
                int LibraryId = resultSet.getInt(5);

                workers.add(new Workers(WorkerId, WorkerName, WorkerAge, Position, LibraryId));
            }
            LOGGER.info("Workers" + workers);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return workers;
    }

    @Override
    public boolean update(Workers entity) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setInt(1, entity.getWorkerId());
            ps.setString(2, entity.getWorkerName());
            ps.setInt(3, entity.getWorkerAge());
            ps.setString(4, entity.getPosition());
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
            String del = "DELETE FROM Workers WHERE WorkerId = " + id;
            ps.executeUpdate(del);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean create(Workers entity) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(CREATE);
            ps.setInt(1, entity.getWorkerId());
            ps.setString(2, entity.getWorkerName());
            ps.setInt(3, entity.getWorkerAge());
            ps.setString(4, entity.getPosition());
            ps.setInt(5, entity.getLibraryId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }


}
