package Xml;

import Hierarcy.Books;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class Jaxb {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Jaxb.class));

    public static void main(String[] args) throws JAXBException, IOException {
          Books books = new Books();
          books.setBookId(1);
          books.setBookTitle("Harry Potter");
          books.setBookAuthor("Rowling");
          books.setBookPages(453);
          books.setLibraryId(1);
          marshalProject(books);
          Books unmarshal = unmarshallProject();
          LOGGER.info("" + unmarshal);
    }

    public static void marshalProject(Books books) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Books.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(books, new File("./Books.xml"));
    }

    public static Books unmarshallProject() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Books.class);
        return (Books) context.createUnmarshaller()
                .unmarshal(new FileReader("./Books.xml"));
    }
}

