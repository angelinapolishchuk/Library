package DAO;

import ConnectionPool.ConnectionPool;
import Hierarcy.Cards;
import interfacesDAO.CardsDAO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;



public class CardsDAOImpl implements CardsDAO {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(CardsDAOImpl.class));
    public static final String AllCards = "SELECT * FROM Cards";
    public static final String UPDATE = "UPDATE Cards SET AcceptanceDate = ? WHERE CardId = ?";
    public static final String DELETE = "DELETE FROM Cards WHERE CardId = ?";
    public static final String CREATE = "INSERT INTO Cards (CardId, AcceptanceDate, ReturnDate,LibraryId) " +
            "VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<Cards> getAll() {
        List<Cards> cards = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(AllCards);
            while (resultSet.next()) {
                int CardId = resultSet.getInt(1);
                String ReturnDate = resultSet.getString(2);
                String AcceptanceDate = resultSet.getString(3);
                int LibraryId = resultSet.getInt(4);


                cards.add(new Cards(CardId,AcceptanceDate, ReturnDate, LibraryId));
            }
            LOGGER.info("Cards" + cards);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return cards;
    }

    @Override
    public boolean update(Cards entity) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setInt(1, entity.getCardId());
            ps.setString(2, entity.getAcceptanceDate());
            ps.setString(3, entity.getReturnDate());
            ps.setInt(4, entity.getLibraryId());
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
            String del = "DELETE FROM Cards WHERE CardId = " + id;
            ps.executeUpdate(del);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean create(Cards entity) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(CREATE);
            ps.setInt(1, entity.getCardId());
            ps.setString(2, entity.getAcceptanceDate());
            ps.setString(3, entity.getReturnDate());
            ps.setInt(4, entity.getLibraryId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }


}
