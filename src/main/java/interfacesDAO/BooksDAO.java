package src.main.java.interfacesDAO;

import src.main.java.Hierarcy.Books;

import java.util.List;

public interface BooksDAO {
    public List<Books> getAllBooks();
    public Books getBooks(int BookId);
    public void updateBooks(Books books);
    public void deleteBooks(Books books);
}
