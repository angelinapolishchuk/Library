package src.main.java.interfacesDAO;

import src.main.java.Hierarcy.BookCrossing;


import java.util.List;

public interface BookCrossingDAO {
    public List<BookCrossing> getAllBookCrossing();
    public BookCrossing getBookCrossing(int BookCrossingId);
    public void updateBookCrossing(BookCrossing bookCrossing);
    public void deleteBookCrossing(BookCrossing bookCrossing);
}
