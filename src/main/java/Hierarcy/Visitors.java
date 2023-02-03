package Hierarcy;

public class Visitors {
    private int VisitorId;
    private String VisitorName;
    private  int VisitorAge;
    private int CardId;

    public Visitors(int VisitorId, String VisitorName, int VisitorAge, int CardId){
        this.VisitorId = VisitorId;
        this.VisitorName = VisitorName;
        this.VisitorAge = VisitorAge;
        this.CardId = CardId;
    }

    public int getVisitorId() {
        return VisitorId;
    }

    public void setVisitorId(int visitorId) {
        this.VisitorId = visitorId;
    }

    public String getVisitorName() {
        return VisitorName;
    }

    public void setVisitorName(String VisitorName) {
        this.VisitorName = VisitorName;
    }

    public int getVisitorAge() {
        return VisitorAge;
    }

    public void setVisitorAge(int VisitorAge) {
        this.VisitorAge = VisitorAge;
    }

    public int getCardId() {
        return CardId;
    }

    public void setCardId(int cardId) {
        this.CardId = cardId;
    }
}
