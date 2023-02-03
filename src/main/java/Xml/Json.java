package Xml;

import Hierarcy.Books;
import Hierarcy.Libraries;
import Hierarcy.Workers;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class Json {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Json.class));

    public static void main(String[] args) throws IOException {
        String json = (new BufferedReader(new FileReader("Books.json"))).readLine();
        Books books = new Books(1, 234,"Harry Potter", "Rowling", 1);
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(books);
        System.out.println(result);

        String json2 = (new BufferedReader(new FileReader("Libraries.json"))).readLine();
        Libraries libraries = new Libraries("National Library", 1);
        result = mapper.writeValueAsString(libraries);
        System.out.println(result);

        String json3 = (new BufferedReader(new FileReader("Workers.json"))).readLine();
        Workers workers = new Workers(1, "Peter", 35,"librarian", 1);
        result = mapper.writeValueAsString(workers);
        System.out.println(result);

    }
}
