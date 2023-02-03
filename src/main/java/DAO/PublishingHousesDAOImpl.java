package src.main.java.DAO;

import src.main.java.Hierarcy.PublishingHouses;
import src.main.java.interfacesDAO.PublishingHousesDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PublishingHousesDAOImpl implements PublishingHousesDAO {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(PublishingHousesDAOImpl.class));
    List<PublishingHouses> publishingHouses;

    public PublishingHousesDAOImpl(){
        publishingHouses = new ArrayList<PublishingHouses>();
        PublishingHouses publishingHouses1 = new PublishingHouses(1,"AST");
        PublishingHouses publishingHouses2 = new PublishingHouses(1,"AVERSEV");
        publishingHouses.add(publishingHouses1);
        publishingHouses.add(publishingHouses2);
    }
    @Override
    public List<PublishingHouses> getAllPublishingHouses() {
        return publishingHouses;
    }

    @Override
    public PublishingHouses getPublishingHouses(int PublishingHouseId) {
        return publishingHouses.get(PublishingHouseId);
    }

    @Override
    public void updatePublishingHouses(PublishingHouses publishingHouse) {
        publishingHouses.get(publishingHouse.getPublishingHouseId()).setPublishingHouseName(publishingHouse.getPublishingHouseName());
        LOGGER.info("PublishingHouses: PublishingHouseId " + publishingHouse.getPublishingHouseId() + ", updated in the database");
    }

    @Override
    public void deletePublishingHouses(PublishingHouses publishingHouse) {
        publishingHouses.remove(publishingHouse.getPublishingHouseId());
        LOGGER.info("PublishingHouses: PublishingHouseId " + publishingHouse.getPublishingHouseId() + ", deleted from database");
    }
}

