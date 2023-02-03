package src.main.java.interfacesDAO;

import src.main.java.Hierarcy.Cards;

import java.util.List;

public interface CardsDAO {
    public List<Cards> getAllCards();
    public Cards getCards(int CardId);
    public void updateCards(Cards cards);
    public void deleteCards(Cards cards);
}
