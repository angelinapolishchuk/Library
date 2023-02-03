package src.main.java.DAO;

import src.main.java.Hierarcy.Libraries;
import src.main.java.interfacesDAO.LibrariesDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LibrariesDAOImpl implements LibrariesDAO {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(LibrariesDAOImpl.class));
    List<Libraries>  libraries;

    public LibrariesDAOImpl(){
        libraries = new ArrayList<Libraries>();
        Libraries libraries1 = new Libraries("NationalLibrary",1);
        Libraries libraries2 = new Libraries("The second Library", 2);
        libraries.add(libraries1);
        libraries.add(libraries2);
    }
    @Override
    public List<Libraries> getAllLibraries() {
        return libraries;
    }

    @Override
    public Libraries getLibraries(int LibraryId) {
        return libraries.get(LibraryId);
    }

    @Override
    public void updateLibraries(Libraries library) {
        libraries.get(library.getLibraryId()).setLibraryName(library.getLibraryName());
        LOGGER.info("Libraries: LibraryId  " + library.getLibraryId() + ", updated in the database");
    }

    @Override
    public void deleteLibraries(Libraries library) {
        libraries.remove(library.getLibraryId());
        LOGGER.info("Libraries: LibraryId  " + library.getLibraryId() + ", deleted from database");
    }
}
