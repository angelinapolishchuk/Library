package src.main.java.interfacesDAO;

import src.main.java.Hierarcy.Workers;

import java.util.List;

public interface WorkersDAO {
    public List<Workers> getAllWorkers();
    public Workers getWorkers(int WorkerId);
    public void updateWorkers(Workers workers);
    public void deleteWorkers(Workers workers);
}
