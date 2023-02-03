package src.main.java.DAO;

import src.main.java.Hierarcy.Cards;
import src.main.java.interfacesDAO.CardsDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CardsDAOImpl implements CardsDAO {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(CardsDAOImpl.class));
    List<Cards> cards;

    public CardsDAOImpl(){
        cards = new ArrayList<Cards>();
        Cards card1 = new Cards(1,"01.02.2022", "01.02.2022", 1);
        Cards card2 = new Cards(2,"05.02.2022", "05.03.2022", 2);
        cards.add(card1);
        cards.add(card2);
    }

    @Override
    public List<Cards> getAllCards() {
        return cards;
    }

    @Override
    public Cards getCards(int CardId) {
        return cards.get(CardId);
    }

    @Override
    public void updateCards(Cards card) {
        cards.get(card.getCardId()).setAcceptanceDate(card.getAcceptanceDate());
        LOGGER.info("Cards: CardId  " + card.getCardId() + ", updated in the database");
    }

    @Override
    public void deleteCards(Cards card) {
        cards.remove(card.getCardId());
        LOGGER.info("Cards: CardId " + card.getCardId() + ", deleted from database");
    }
}
