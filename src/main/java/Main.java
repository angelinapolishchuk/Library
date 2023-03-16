import DAO.BooksDAOImpl;
import DAO.OthersDAOImpl;
import Hierarcy.Books;
import Hierarcy.Others;
import Menu.AllDAOClasses;
import Menu.AllOptions;
import interfacesDAO.IBaseDAO;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Main.class));

    private static AllOptions currentState = AllOptions.ALL;
    private static AllDAOClasses selectedOption = null;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int a;
        boolean exit = false;

        while (!exit) {
            switch (currentState) {
                case ALL -> {
                    LOGGER.info("\n1 - INSERT\n2 - UPDATE\n3 - DELETE\n4 - PRINT\n0 - EXIT");
                    boolean validInt = false;
                    a = 0;
                    a = scanner.nextInt();
                    if (a < 0 || a > 4) {
                        LOGGER.info("Wrong number.Try again");
                        currentState = AllOptions.ALL;
                    }
                    switch (a) {
                        case 1 -> currentState = AllOptions.INSERT;
                        case 2 -> currentState = AllOptions.UPDATE;
                        case 3 -> currentState = AllOptions.DELETE;
                        case 0 -> currentState = AllOptions.EXIT;
                        default -> currentState = AllOptions.ALL;
                    }
                }
                case INSERT -> {
                    IBaseDAO iBaseDAO = getClass(scanner);
                    switch (selectedOption) {
                        case BOOKS -> {
                            Books books = Books.Factory(scanner, LOGGER);
                            iBaseDAO.create(books);
                            currentState = AllOptions.ALL;
                        }
                        case OTHERS -> {
                            Others others = Others.Factory(scanner, LOGGER);
                            iBaseDAO.create(others);
                            currentState = AllOptions.ALL;
                        }
                        default -> currentState = AllOptions.INSERT;
                    }
                }
                case UPDATE -> {
                    IBaseDAO iBaseDAO = getClass(scanner);
                    switch (selectedOption) {
                        case BOOKS -> {
                            Books books = new Books();
                            LOGGER.info("Enter new book title");
                            books.setBookTitle(scanner.nextLine());
                            iBaseDAO.update(books);
                            currentState = AllOptions.ALL;
                        }
                        case OTHERS -> {
                            Others others = new Others();
                            LOGGER.info("Enter new other title");
                            others.setOtherTitle(scanner.nextLine());
                            iBaseDAO.update(others);
                            currentState = AllOptions.ALL;
                        }
                        default -> currentState = AllOptions.UPDATE;
                    }
                }
                case DELETE -> {
                    IBaseDAO iBaseDAO = getClass(scanner);
                    switch (selectedOption) {
                        case BOOKS, OTHERS -> {
                            LOGGER.info("Enter Id");
                            iBaseDAO.delete(scanner.nextLong());
                            currentState = AllOptions.ALL;
                        }
                    }
                }
                case EXIT -> {
                    LOGGER.info("\nAre you sure?\nIf 'yes' enter 'Y'; If 'no' enter 'N':");
                    char ch = Character.toLowerCase(scanner.next().trim().charAt(0));
                    switch (ch) {
                        case 'y' -> {
                            LOGGER.info("Goodbye");
                            exit = true;
                        }
                        case 'n' -> {
                            currentState = AllOptions.ALL;
                        }
                    }
                }
                default -> throw new RuntimeException("Wrong number");
            }
        }
        scanner.close();
    }

    private static IBaseDAO getClass(Scanner scanner) {
        LOGGER.info("\n1 - BOOKS\n2 - OTHERS");
        IBaseDAO iBaseDAO = null;
        int a = 0;
        a = scanner.nextInt();
        if (a < 0 || a > 4) {
            LOGGER.info("Wrong number.Try again");
            currentState = AllOptions.ALL;
        }

        switch (a) {
            case 1 -> {
                iBaseDAO = new BooksDAOImpl();
                selectedOption = AllDAOClasses.BOOKS;
            }
            case 2 -> {
                iBaseDAO = new OthersDAOImpl();
                selectedOption = AllDAOClasses.OTHERS;
            }
            default -> {
                currentState = AllOptions.ALL;
            }
        }
        return iBaseDAO;
    }
}
