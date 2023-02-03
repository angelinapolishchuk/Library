package src.main.java.interfacesDAO;

import src.main.java.Hierarcy.Others;

import java.util.List;

public interface OthersDAO {
    public List<Others> getAllOthers();
    public Others getOthers(int OtherId);
    public void updateOthers(Others others);
    public void deleteOthers(Others others);
}
