package src.main.java.DAO;

import src.main.java.Hierarcy.Workers;
import src.main.java.interfacesDAO.WorkersDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class WorkersDAOImpl implements WorkersDAO {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(WorkersDAOImpl.class));
    List<Workers> workers;

    public WorkersDAOImpl(){
        workers = new ArrayList<Workers>();
        Workers workers1= new Workers(1,"Jane", 23, "librarian",1);
        Workers workers2 = new Workers(2, "Lin", 46,"librarian",2);
        workers.add(workers1);
        workers.add(workers2);
    }
    @Override
    public List<Workers> getAllWorkers() {
        return workers;
    }

    @Override
    public Workers getWorkers(int WorkerId) {
        return workers.get(WorkerId);
    }

    @Override
    public void updateWorkers(Workers worker) {
        workers.get(worker.getWorkerId()).setWorkerName(worker.getWorkerName());
        LOGGER.info("Workers: WorkerId  " + worker.getWorkerId() + ", updated in the database");
    }

    @Override
    public void deleteWorkers(Workers worker) {
        workers.remove(worker.getWorkerId());
        LOGGER.info("Workers: WorkerId  " + worker.getWorkerId() + ", deleted from database");
    }
}
