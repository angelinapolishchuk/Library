package DAO;

import ConnectionPool.ConnectionPool;
import Hierarcy.Cards;
import Hierarcy.Genres;
import interfacesDAO.GenresDAO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class GenresDAOImpl implements GenresDAO {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(GenresDAOImpl.class));
    public static final String AllGenres = "SELECT * FROM Genres";
    public static final String UPDATE = "UPDATE Genres SET Genre = ? WHERE GenreId = ?";
    public static final String DELETE = "DELETE FROM Genres WHERE GenreId = ?";
    public static final String CREATE = "INSERT INTO Genres (GenreId, Genre, BookId) " +
            "VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<Genres> getAll() {
        List<Genres> genres = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(AllGenres);
            while (resultSet.next()) {
                int GenreId = resultSet.getInt(1);
                String Genre = resultSet.getString(2);
                int BookId = resultSet.getInt(3);
                genres.add(new Genres(GenreId, Genre, BookId));
            }
            LOGGER.info("Genres" + genres);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return genres;
    }

    @Override
    public boolean update(Genres entity) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setInt(1, entity.getGenreId());
            ps.setString(2, entity.getGenre());
            ps.setInt(3, entity.getBookId());
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
            String del = "DELETE FROM Genres WHERE GenreId = " + id;
            ps.executeUpdate(del);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean create(Genres entity) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(CREATE);
            ps.setInt(1, entity.getGenreId());
            ps.setString(2, entity.getGenre());
            ps.setInt(3, entity.getBookId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }


}
