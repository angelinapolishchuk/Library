package src.main.java;

import src.main.java.DAO.*;
import src.main.java.Hierarcy.*;
import src.main.java.interfacesDAO.*;

import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) {
        BookCrossingDAO bookCrossingDAO = new BookCrossingDAOImpl();
        for (BookCrossing bookCrossing : bookCrossingDAO.getAllBookCrossing()) {
            LOGGER.info("BookCrossing: [Id : " + bookCrossing.getBookCrossingId() + ", OwnerName : " + bookCrossing.getOwnerName() + " ]");
        }

        BooksDAO booksDAO = new BooksDAOImpl();
        for (Books book : booksDAO.getAllBooks()) {
            LOGGER.info("Book: [Id : " + book.getBookId() + ", BookTitle : " + book.getBookTitle() + " ]");
        }

        CardsDAO cardsDAO = new CardsDAOImpl();
        for (Cards card : cardsDAO.getAllCards()) {
            LOGGER.info("Card: [Id : " + card.getCardId() + ", AcceptanceDate : " + card.getAcceptanceDate() + " ]");
        }

        GenresDAO genresDAO = new GenresDAOImpl();
        for (Genres genre: genresDAO.getAllGenres()) {
            LOGGER.info("Genre: [Id : " + genre.getGenreId() + ", Genre : " + genre.getGenre() + " ]");
        }

        LibrariesDAO librariesDAO = new LibrariesDAOImpl();
        for (Libraries library: librariesDAO.getAllLibraries()) {
            LOGGER.info("Library: [Id : " + library.getLibraryId() + ", LibraryName : " + library.getLibraryName() + " ]");
        }

        OthersDAO othersDAO = new OthersDAOImpl();
        for (Libraries library: librariesDAO.getAllLibraries()) {
            LOGGER.info("Library: [Id : " + library.getLibraryId() + ", LibraryName : " + library.getLibraryName() + " ]");
        }

        PublishingHousesDAO publishingHousesDAO = new PublishingHousesDAOImpl();
        for (PublishingHouses publishingHouse: publishingHousesDAO.getAllPublishingHouses()) {
            LOGGER.info("PublishingHouse: [Id : " + publishingHouse.getPublishingHouseId() + ", PublishingHouseName : " + publishingHouse.getPublishingHouseName() + " ]");
        }

        StoragesDAO storagesDAO = new StoragesDAOImpl();
        for (Storages storage: storagesDAO.getAllStorages()) {
            LOGGER.info("Storages: [Id : " + storage.getStorageId() + ", StorageType : " + storage.getStorageType() + " ]");
        }

        VisitorsDAO visitorsDAO = new VisitorsDAOImpl();
        for (Visitors visitor: visitorsDAO.getAllVisitors()) {
            LOGGER.info("Visitors: [Id : " + visitor.getVisitorId() + ", VisitorName : " + visitor.getVisitorName() + " ]");
        }

        WorkersDAO workersDAO = new WorkersDAOImpl();
        for (Workers worker: workersDAO.getAllWorkers()) {
            LOGGER.info("Workers: [Id : " + worker.getWorkerId() + ", WorkerName : " + worker.getWorkerName() + " ]");
        }
    }}
