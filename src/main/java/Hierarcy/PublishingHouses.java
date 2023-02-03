package Hierarcy;

public class PublishingHouses {
    private int  PublishingHouseId;
    private String PublishingHouseName;

    public PublishingHouses(int PublishingHouseId, String PublishingHouseName){
        this.PublishingHouseId = PublishingHouseId;
        this.PublishingHouseName = PublishingHouseName;
    }

    public int getPublishingHouseId() {
        return PublishingHouseId;
    }

    public void setPublishingHouseId(int publishingHouseId) {
        this.PublishingHouseId = publishingHouseId;
    }

    public String getPublishingHouseName() {
        return PublishingHouseName;
    }

    public void setPublishingHouseName(String publishingHouseName) {
        this.PublishingHouseName = publishingHouseName;
    }

}
