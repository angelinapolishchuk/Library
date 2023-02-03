package Hierarcy;

import org.codehaus.jackson.map.annotate.JsonRootName;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Scanner;
import java.util.logging.Logger;

@XmlRootElement(name = "Books")
@JsonRootName(value = "Books")
public class Books {
    @XmlAttribute(name = "BookId")
    private int BookId;
    @XmlAttribute
    private int BookPages;
    @XmlElement(name = "BookTitle")
    private  String BookTitle;
    @XmlElement(name = "BookAuthor")
    private String BookAuthor;
    @XmlAttribute(name = "LibraryId")
    private int LibraryId;

    public Books(){};

    public Books(int BookId, int BookPages, String BookTitle, String BookAuthor, int LibraryId){
        this.BookId = BookId;
        this.BookPages = BookPages;
        this.BookTitle = BookTitle;
        this.BookAuthor = BookAuthor;
        this.LibraryId = LibraryId;
    }

    public int getBookPages() {
        return BookPages;
    }

    public void setBookPages(int bookPages) {
        this.BookPages = bookPages;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        this.BookId = bookId;
    }
    public String getBookTitle() {
        return BookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.BookTitle = bookTitle;
    }
    public String getBookAuthor() {
        return BookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.BookAuthor = bookAuthor;
    }
    public int getLibraryId() {
        return LibraryId;
    }

    public void setLibraryId(int libraryId) {
        this.LibraryId = libraryId;
    }

    public static Books Factory(Scanner scanner, Logger LOGGER){
        LOGGER.info("Enter book Id");
        int BookId = scanner.nextInt();
        LOGGER.info("Enter pages");
        int BookPages = scanner.nextInt();
        LOGGER.info("Enter title");
        String BookTitle = scanner.next();
        LOGGER.info("Enter author");
        String BookAuthor = scanner.next();
        LOGGER.info("Enter libraryId");
        int LibraryId = scanner.nextInt();
        return new Books(BookId, BookPages, BookTitle, BookAuthor, LibraryId);

}
    @Override
    public String toString() {
        return " Books {" +
                ", BookId = " + BookId +
                ", BookPages = " + BookPages +
                ", BookTitle = " + BookTitle +
                ", BookAuthor = " + BookAuthor +
                ", LibraryId = " + LibraryId +
                '}';
    }
}
