package src.main.java.DAO;

import src.main.java.Hierarcy.Books;
import src.main.java.interfacesDAO.BooksDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BooksDAOImpl implements BooksDAO {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(BooksDAOImpl.class));
    List<Books> books;

    public BooksDAOImpl(){
        books = new ArrayList< Books>();
        Books book1 = new  Books(1,345, "The Lord Of The Rings", "J.R.R.Tolkien", 2);
        Books book2 = new  Books(2,645, "To Kill a Mockingbird", "Harper Lee", 1);
        books.add(book1);
        books.add(book2);
    }

    @Override
    public List<Books> getAllBooks() {
        return books;
    }

    @Override
    public Books getBooks(int BookId) {
        return books.get(BookId);
    }

    @Override
    public void updateBooks(Books book) {
        books.get(book.getBookId()).setBookTitle(book.getBookTitle());
        LOGGER.info("Books: BookId  " + book.getBookId() + ", updated in the database");
    }

    @Override
    public void deleteBooks(Books book) {
        books.remove(book.getBookId());
        LOGGER.info("Books: BookId " + book.getBookId() + ", deleted from database");
    }
}
