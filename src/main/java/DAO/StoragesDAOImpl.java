package src.main.java.DAO;

import src.main.java.Hierarcy.Storages;
import src.main.java.interfacesDAO.StoragesDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StoragesDAOImpl implements StoragesDAO {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(StoragesDAOImpl.class));
    List<Storages> storages;

    public StoragesDAOImpl(){
        storages = new ArrayList<Storages>();
        Storages storages1= new Storages(1,"For disposal", 2);
        Storages storages2 = new Storages(2, "For exhibition", 1);
        storages.add(storages1);
        storages.add(storages2);
    }
    @Override
    public List<Storages> getAllStorages() {
        return storages;
    }

    @Override
    public Storages getStorages(int StorageId) {
        return storages.get(StorageId);
    }

    @Override
    public void updateStorages(Storages storage) {
        storages.get(storage.getStorageId()).setStorageType(storage.getStorageType());
        LOGGER.info("Storages: StorageId  " + storage.getStorageId() + ", updated in the database");
    }

    @Override
    public void deleteStorages(Storages storage) {
        storages.remove(storage.getStorageId());
        LOGGER.info("Storages: StorageId  " + storage.getStorageId() + ", deleted from database");
    }
}
