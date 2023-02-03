package src.main.java.DAO;

import src.main.java.Hierarcy.Others;
import src.main.java.interfacesDAO.OthersDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class OthersDAOImpl implements OthersDAO {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(OthersDAOImpl.class));
    List<Others> others;

    public OthersDAOImpl(){
        others = new ArrayList<Others>();
        Others others1 = new Others(1,"magazine", "NationalGeographic", "Andrew Evans", 2);
        Others others2 = new Others(2,"magazine", "Time", "Briton Hadden", 1);
        others.add(others1);
        others.add(others2);
    }

    @Override
    public List<Others> getAllOthers() {
        return others;
    }

    @Override
    public Others getOthers(int OtherId) {
        return others.get(OtherId);
    }

    @Override
    public void updateOthers(Others other) {
        others.get(other.getOtherId()).setOtherTitle(other.getOtherTitle());
        LOGGER.info("Others: OtherId  " + other.getOtherId() + ", updated in the database");
    }

    @Override
    public void deleteOthers(Others other) {
        others.remove(other.getOtherId());
        LOGGER.info("Others: OtherId  " + other.getOtherId() + ", deleted from database");
    }
}
