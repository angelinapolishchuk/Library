package src.main.java.DAO;

import src.main.java.Hierarcy.Visitors;
import src.main.java.interfacesDAO.VisitorsDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class VisitorsDAOImpl implements VisitorsDAO {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(VisitorsDAOImpl.class));
    List<Visitors> visitors;

    public VisitorsDAOImpl(){
        visitors = new ArrayList<Visitors>();
        Visitors visitors1= new Visitors(1,"Pasha", 26, 1);
        Visitors visitors2 = new Visitors(2, "Jin", 19,2);
        visitors.add(visitors1);
        visitors.add(visitors2);
    }
    @Override
    public List<Visitors> getAllVisitors() {
        return visitors;
    }

    @Override
    public Visitors getVisitors(int VisitorId) {
        return visitors.get(VisitorId);
    }

    @Override
    public void updateVisitors(Visitors visitor) {
        visitors.get(visitor.getVisitorId()).setVisitorName(visitor.getVisitorName());
        LOGGER.info("Visitors: VisitorId  " + visitor.getVisitorId() + ", updated in the database");
    }

    @Override
    public void deleteVisitors(Visitors visitor) {
        visitors.remove(visitor.getVisitorId());
        LOGGER.info("Visitors: VisitorId  " + visitor.getVisitorId() + ", deleted from database");
    }
}
