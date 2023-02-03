package src.main.java.Hierarcy;

public class Storages {
    private int  StorageId;
    private String StorageType;
    private int LibraryId;

    public Storages(int StorageId, String StorageType, int LibraryId){
        this.StorageId = StorageId;
        this.StorageType = StorageType;
        this.LibraryId = LibraryId;
    }

    public int getStorageId() {
        return StorageId;
    }

    public void setStorageId(int storageId) {
        this.StorageId = storageId;
    }

    public String getStorageType() {
        return StorageType;
    }

    public void setStorageType(String storageType) {
        this.StorageType = storageType;
    }


    public int getLibraryId() {
        return LibraryId;
    }

    public void setLibraryId(int libraryId) {
        this.LibraryId = libraryId;
    }
}
