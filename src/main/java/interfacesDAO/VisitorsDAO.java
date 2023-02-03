package src.main.java.interfacesDAO;

import src.main.java.Hierarcy.Visitors;

import java.util.List;

public interface VisitorsDAO {
    public List<Visitors> getAllVisitors();
    public Visitors getVisitors(int VisitorId);
    public void updateVisitors(Visitors visitors);
    public void deleteVisitors(Visitors visitors);
}
