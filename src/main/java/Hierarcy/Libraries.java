package src.main.java.Hierarcy;

public class Libraries {
    private int LibraryId;
    private String LibraryName;

    public Libraries(String LibraryName, int LibraryId){
        this.LibraryName = LibraryName;
        this.LibraryId = LibraryId;
    }

    public String getLibraryName() {
        return LibraryName;
    }

    public void setLibraryName(String libraryName) {
        this.LibraryName = libraryName;
    }

    public int getLibraryId() {
        return LibraryId;
    }

    public void setLibraryId(int libraryId) {
        this.LibraryId = libraryId;
    }
}
