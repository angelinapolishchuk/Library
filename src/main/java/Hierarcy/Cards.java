package src.main.java.Hierarcy;


public class Cards {
    private int CardId;
    private String AcceptanceDate;
    private  String ReturnDate;
    private int LibraryId;

   public Cards(int CardId, String AcceptanceDate, String ReturnDate, int LibraryId){
        this.CardId = CardId;
        this.AcceptanceDate = AcceptanceDate;
        this.ReturnDate = ReturnDate;
        this.LibraryId = LibraryId;
    }

    public int getCardId() {
        return CardId;
    }

    public void setCardId(int cardId) {
        this.CardId = cardId;
    }

    public String getAcceptanceDate() {
        return AcceptanceDate;
    }

    public void setAcceptanceDate(String acceptanceDate) {
        this.AcceptanceDate = acceptanceDate;
    }

    public String getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(String returnDate) {
        this.ReturnDate = returnDate;
    }

    public int getLibraryId() {
        return LibraryId;
    }

    public void setLibraryId(int libraryId) {
        this.LibraryId = libraryId;
    }
}
