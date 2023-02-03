package src.main.java.Hierarcy;

public class Workers {
    private int WorkerId;
    private String WorkerName;
    private  int WorkerAge;
    private String Position;
    private int LibraryId;

    public Workers(int WorkerId, String WorkerName, int WorkerAge, String Position, int LibraryId){
        this.WorkerId = WorkerId;
        this.WorkerName = WorkerName;
        this.WorkerAge = WorkerAge;
        this.Position = Position;
        this.LibraryId = LibraryId;
    }

    public String getWorkerName() {
        return WorkerName;
    }

    public void setWorkerName(String workerName) {
        this.WorkerName = workerName;
    }

    public int getWorkerId() {
        return WorkerId;
    }

    public void setWorkerId(int workerId) {
        this.WorkerId = workerId;
    }
    public int getWorkerAge() {
        return WorkerAge;
    }

    public void setWorkerAge(int workerAge) {
        this.WorkerAge = workerAge;
    }
    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        this.Position = position;
    }
    public int getLibraryId() {
        return LibraryId;
    }

    public void setLibraryId(int libraryId) {
        this.LibraryId = libraryId;
    }
}
