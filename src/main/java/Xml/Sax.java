package Xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Sax {
    private static final java.util.logging.Logger LOGGER = Logger.getLogger(String.valueOf(Sax.class));
    public static void main(String[] args) {
        DefaultHandler defaultHandler = new DefaultHandler(){
            boolean AcceptanceDate =false;
            boolean ReturnDate =false;
            boolean LibraryId= false;
            boolean CardId =false;



            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                LOGGER.info("Start Element: "+qName);
                if (qName.equals("AcceptanceDate")) AcceptanceDate =true;
                if (qName.equals("ReturnDate")) ReturnDate =true;
                if (qName.equals("LibraryId")) LibraryId =true;
                if (qName.equals("CardId")) CardId =true;
            }


            public void endElement(String uri, String localName, String qName) throws SAXException {
                LOGGER.info("End Element: "+ qName);
            }


            public void characters(char[] ch, int start, int length) throws SAXException {
                if (AcceptanceDate){
                    LOGGER.info("AcceptanceDate: "+new String(ch,start,length));
                    AcceptanceDate=false;
                }
                if (ReturnDate){
                    LOGGER.info("ReturnDate: "+new String(ch,start,length));
                    ReturnDate=false;
                }
                if (LibraryId){
                    LOGGER.info("LibraryId:" +new String(ch,start,length));
                    LibraryId=false;
                }
                if (CardId){
                    LOGGER.info("CardId: "+new String(ch,start,length));
                    CardId =false;
                }
            }
        };


        SAXParserFactory saxParser = SAXParserFactory.newInstance();
        try {
            SAXParser parser = saxParser.newSAXParser();
            parser.parse(new File("Cards.xml"),defaultHandler);


        } catch (ParserConfigurationException | SAXException | IOException ex) {
            LOGGER.info("" + ex);
        }
    }
}
