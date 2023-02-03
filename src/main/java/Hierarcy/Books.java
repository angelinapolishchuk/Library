package src.main.java.Hierarcy;

public class Books {
    private int BookId;
    private int BookPages;
    private  String BookTitle;
    private String BookAuthor;
    private int LibraryId;

    public Books(int BookId, int BookPages, String BookTitle, String BookAuthor, int LibraryId){
        this.BookId = BookId;
        this.BookPages = BookPages;
        this.BookTitle = BookTitle;
        this.BookAuthor = BookAuthor;
        this.LibraryId = LibraryId;
    }

    public int getBookPages() {
        return BookPages;
    }

    public void setBookPages(int bookPages) {
        this.BookPages = bookPages;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        this.BookId = bookId;
    }
    public String getBookTitle() {
        return BookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.BookTitle = BookTitle;
    }
    public String getBookAuthor() {
        return BookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.BookAuthor = bookAuthor;
    }
    public int getLibraryId() {
        return LibraryId;
    }

    public void setLibraryId(int libraryId) {
        this.LibraryId = libraryId;
    }
}
