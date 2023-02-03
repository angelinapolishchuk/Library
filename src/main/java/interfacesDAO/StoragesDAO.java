package src.main.java.interfacesDAO;

import src.main.java.Hierarcy.Storages;

import java.util.List;

public interface StoragesDAO {
    public List<Storages> getAllStorages();
    public Storages getStorages(int StorageId);
    public void updateStorages(Storages storages);
    public void deleteStorages(Storages storages);
}
