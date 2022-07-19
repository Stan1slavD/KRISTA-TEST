import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XMLParser {
    public static Catalog parse(File file, ArrayList<Plant> plants) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc = null;
        try {
            doc = dbf.newDocumentBuilder().parse(file);
        } catch (
                SAXException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        } catch (
                ParserConfigurationException e) {
            e.printStackTrace();
        }
        Node catalogNode = doc.getFirstChild();
        NodeList plantsNode = catalogNode.getChildNodes();
        for (int i = 0; i < plantsNode.getLength(); i++) {
            if (plantsNode.item(i).getNodeType() != Node.ELEMENT_NODE)
                continue;
            Plant plant = new Plant();
            for (int j = 0; j < plantsNode.item(i).getChildNodes().getLength(); j++) {
                if (plantsNode.item(i).getChildNodes().item(j).getNodeType() != Node.ELEMENT_NODE)
                    continue;
                switch (plantsNode.item(i).getChildNodes().item(j).getNodeName()) {
                    case "COMMON":
                        plant.setCommon(plantsNode.item(i).getChildNodes().item(j).getTextContent());
                    case "BOTANICAL":
                        plant.setBotanical(plantsNode.item(i).getChildNodes().item(j).getTextContent());
                    case "ZONE":
                        plant.setZone(plantsNode.item(i).getChildNodes().item(j).getTextContent());
                    case "LIGHT":
                        plant.setLight(plantsNode.item(i).getChildNodes().item(j).getTextContent());
                    case "PRICE":
                        plant.setPrice(plantsNode.item(i).getChildNodes().item(j).getTextContent());
                    case "AVAILABILITY":
                        plant.setAvailability(plantsNode.item(i).getChildNodes().item(j).getTextContent());
                    default:
                        break;
                }
            }
            plants.add(plant);
        }

        Catalog catalog = new Catalog(catalogNode.getAttributes().item(2).getTextContent(), catalogNode.getAttributes().item(1).getTextContent(), catalogNode.getAttributes().item(0).getTextContent(), plants);
        return catalog;
    }
}
