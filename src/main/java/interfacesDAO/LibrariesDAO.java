package src.main.java.interfacesDAO;

import src.main.java.Hierarcy.Libraries;

import java.util.List;

public interface LibrariesDAO {
    public List<Libraries> getAllLibraries();
    public Libraries getLibraries(int LibraryId);
    public void updateLibraries(Libraries libraries);
    public void deleteLibraries(Libraries libraries);
}
