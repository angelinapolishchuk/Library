package src.main.java.DAO;

import src.main.java.Hierarcy.BookCrossing;
import src.main.java.interfacesDAO.BookCrossingDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BookCrossingDAOImpl implements BookCrossingDAO {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(BookCrossingDAOImpl.class));
    List< BookCrossing>  bookCrossings;

    public BookCrossingDAOImpl(){
        bookCrossings = new ArrayList< BookCrossing>();
        BookCrossing bookCrossing1 = new  BookCrossing(1,"Robert", 1);
        BookCrossing bookCrossing2 = new  BookCrossing(2,"John", 1);
        bookCrossings.add(bookCrossing1);
        bookCrossings.add(bookCrossing2);
    }

    @Override
    public List<BookCrossing> getAllBookCrossing() {
        return bookCrossings;
    }

    @Override
    public BookCrossing getBookCrossing(int BookCrossingId) {
        return bookCrossings.get(BookCrossingId);
    }

    @Override
    public void updateBookCrossing(BookCrossing bookCrossing) {
        bookCrossings.get(bookCrossing.getBookCrossingId()).setOwnerName(bookCrossing.getOwnerName());
        LOGGER.info("BookCrossing: BookCrossingId  " + bookCrossing.getBookCrossingId() + ", updated in the database");
    }

    @Override
    public void deleteBookCrossing(BookCrossing bookCrossing) {
        bookCrossings.remove(bookCrossing.getBookCrossingId());
        LOGGER.info("BookCrossing: BookCrossingId " + bookCrossing.getBookCrossingId() + ", deleted from database");
    }
    }
