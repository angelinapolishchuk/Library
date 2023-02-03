package DAO;

import ConnectionPool.ConnectionPool;
import Hierarcy.Books;
import interfacesDAO.BooksDAO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BooksDAOImpl implements BooksDAO {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(BooksDAOImpl.class));

    public static final String AllBooks = "SELECT * FROM Books";
    public static final String UPDATE = "UPDATE Books SET BookTitle = ? WHERE BookId = ?";
    public static final String DELETE = "DELETE FROM Books WHERE BookId = ?";
    public static final String CREATE = "INSERT INTO Books (BookId, BookPages, BookTitle, BookAuthor, LibraryId) " +
            "VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<Books> getAll() {
        List<Books> books = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(AllBooks);
            while (resultSet.next()) {
                int BookId = resultSet.getInt(1);
                int BookPages = resultSet.getInt(2);
                String BookTitle = resultSet.getString(3);
                String BookAuthor = resultSet.getString(4);
                int LibraryId = resultSet.getInt(5);

                books.add(new Books(BookId, BookPages, BookTitle, BookAuthor, LibraryId));
            }
            LOGGER.info("Books" + books);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return books;
    }

    @Override
    public boolean update(Books entity) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setInt(1, entity.getBookId());
            ps.setInt(2, entity.getBookPages());
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
            String del = "DELETE FROM Books WHERE BookId = " + id;
            ps.executeUpdate(del);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean create(Books entity) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(CREATE);
            ps.setString(1, entity.getBookAuthor());
            ps.setString(2, entity.getBookTitle());
            ps.setInt(3, entity.getBookId());
            ps.setInt(4, entity.getLibraryId());
            ps.setInt(5, entity.getBookPages());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }


}
