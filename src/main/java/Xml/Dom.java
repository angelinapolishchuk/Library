package Xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Dom {

    private static final java.util.logging.Logger LOGGER = Logger.getLogger(String.valueOf(Dom.class));
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("Cards.xml"));

        Element element = document.getDocumentElement();
        LOGGER.info("" + element);
        NodeList nodeList =element.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE){
                System.out.println();
                LOGGER.info(nodeList.item(i).getNodeName()+" "+nodeList.item(i).getAttributes().getNamedItem("CardId"));
                NodeList cardList =nodeList.item(i).getChildNodes();
                for (int j = 0; j <cardList.getLength() ; j++) {
                    if (cardList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        LOGGER.info(cardList.item(j).getNodeName() + ": " + cardList.item(j).getTextContent());
                    }
                }
            }
        }


    }
}
