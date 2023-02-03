package Xml;

import DAO.CardsDAOImpl;
import Hierarcy.Cards;

import java.util.logging.Logger;

public class MyBatis {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(MyBatis.class));

    public static void main(String[] args) {
        CardsDAOImpl cardsDAO = new CardsDAOImpl();
        Cards cards = new Cards();
        cards.setCardId(8);
        cards.setAcceptanceDate("2022-12-13");
        cards.setReturnDate("2023-01-02");
        cards.setLibraryId(1);
        LOGGER.info(String.valueOf(cardsDAO.create(cards)));
    }}