package Patterns;

import java.util.logging.Logger;

public class Builder {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Builder.class));
    public static void main(String[] args) {
        Librarian librarian = Librarian.builder()
                .withName("Alex")
                .withSecondName("Ivanov")
                .withAge((short)28)
                .withPhoneNumber(56336892).build();
        LOGGER.info("" + librarian);
    }
}
