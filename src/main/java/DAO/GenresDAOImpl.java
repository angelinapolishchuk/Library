package src.main.java.DAO;

import src.main.java.Hierarcy.Genres;
import src.main.java.interfacesDAO.GenresDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GenresDAOImpl implements GenresDAO {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(GenresDAOImpl.class));
    List<Genres> genres;

    public GenresDAOImpl(){
        genres = new ArrayList<Genres>();
        Genres genre1 = new Genres(1,"fantasy", 1);
        Genres genre2 = new Genres(2,"fiction", 2);
        genres.add(genre1);
        genres.add(genre2);
    }

    @Override
    public List<Genres> getAllGenres() {
        return genres;
    }

    @Override
    public Genres getGenres(int GenreId) {
        return genres.get(GenreId);
    }

    @Override
    public void updateGenres(Genres genre) {
        genres.get(genre.getBookId()).setGenre(genre.getGenre());
        LOGGER.info("Genres: GenreId  " + genre.getGenreId() + ", updated in the database");
    }

    @Override
    public void deleteGenres(Genres genre) {
        genres.remove(genre.getGenreId());
        LOGGER.info("Genres: GenreId  " + genre.getGenreId() + ", deleted from database");
    }
}
