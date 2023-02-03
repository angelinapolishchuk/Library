package src.main.java.Hierarcy;

public class Genres {
    private int  GenreId;
    private String Genre;
    private int BookId;

    public Genres(int GenreId, String Genre, int BookId){
        this.GenreId = GenreId;
        this.Genre = Genre;
        this.BookId = BookId;
    }

    public int getGenreId() {
        return GenreId;
    }

    public void setGenreId(int genreId) {
        this.GenreId = genreId;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        this.Genre = genre;
    }


    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        this.BookId = bookId;
    }
}
