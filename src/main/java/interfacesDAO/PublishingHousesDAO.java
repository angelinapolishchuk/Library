package src.main.java.interfacesDAO;

import src.main.java.Hierarcy.PublishingHouses;

import java.util.List;

public interface PublishingHousesDAO {
    public List<PublishingHouses> getAllPublishingHouses();
    public PublishingHouses getPublishingHouses(int PublishingHouseId);
    public void updatePublishingHouses(PublishingHouses publishingHouses);
    public void deletePublishingHouses(PublishingHouses publishingHouses);
}
