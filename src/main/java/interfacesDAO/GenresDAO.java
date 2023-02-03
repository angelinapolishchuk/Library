package src.main.java.interfacesDAO;

import src.main.java.Hierarcy.Genres;

import java.util.List;

public interface GenresDAO {
    public List<Genres> getAllGenres();
    public Genres getGenres(int GenreId);
    public void updateGenres(Genres genres);
    public void deleteGenres(Genres genres);
}
