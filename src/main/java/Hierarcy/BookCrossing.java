package Hierarcy;

public class BookCrossing {
    private int  BookCrossingId;
    private String OwnerName;
    private int LibraryId;

    public BookCrossing(int BookCrossingId, String OwnerName, int LibraryId){
        this.BookCrossingId =  BookCrossingId;
        this.OwnerName = OwnerName;
        this.LibraryId = LibraryId;
    }

    public int getBookCrossingId() {
        return  BookCrossingId;
    }

    public void setBookCrossingId(int  bookCrossingId) {
        this.BookCrossingId =  bookCrossingId;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        this.OwnerName = ownerName;
    }

    public int getLibraryId() {
        return LibraryId;
    }

    public void setLibraryId(int libraryId) {
        this.LibraryId = libraryId;
    }

}
