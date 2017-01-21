package pp.xmlFileProcessing;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import pp.linguisticCategories.*;
import pp.linguisticCategories.linguisticCategoriesService.LinguisticCategoriesServiceImpl;
import pp.word.WordUniqueForm;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Map;

public class XMLfileReadAndWriteServiceImpl implements XMLfileReadAndWriteService {

    public static void saveToXMLStatisticInformation() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("Statistic");
            doc.appendChild(rootElement);

            Element node = doc.createElement("totalAccountOfWords");
            node.appendChild(doc.createTextNode(WordUniqueForm.getAccountOfWords().toString()));
            rootElement.appendChild(node);
            Element nodeAdjective = doc.createElement("totalAccountOfWordsAdjective");
            nodeAdjective.appendChild(doc.createTextNode(LcAdjectiveUkrainian.getAccountOfWordsLC().toString()));
            rootElement.appendChild(nodeAdjective);
            Element nodeAdverb = doc.createElement("totalAccountOfWordsAdverb");
            nodeAdverb.appendChild(doc.createTextNode(LcAdverbUkrainian.getAccountOfWordsLC().toString()));
            rootElement.appendChild(nodeAdverb);
            Element nodeConjunction = doc.createElement("totalAccountOfWordsConjunction");
            nodeConjunction.appendChild(doc.createTextNode(LcConjunctionUkrainian.getAccountOfWordsLC().toString()));
            rootElement.appendChild(nodeConjunction);
            Element nodeNoun = doc.createElement("totalAccountOfWordsNoun");
            nodeNoun.appendChild(doc.createTextNode(LcNounUkrainian.getAccountOfWordsLC().toString()));
            rootElement.appendChild(nodeNoun);
            Element nodeNumeral = doc.createElement("totalAccountOfWordsNumeral");
            nodeNumeral.appendChild(doc.createTextNode(LcNumeralUkrainian.getAccountOfWordsLC().toString()));
            rootElement.appendChild(nodeNumeral);
            Element nodePreposition = doc.createElement("totalAccountOfWordsPreposition");
            nodePreposition.appendChild(doc.createTextNode(LcPrepositionUkrainian.getAccountOfWordsLC().toString()));
            rootElement.appendChild(nodePreposition);
            Element nodePronoun = doc.createElement("totalAccountOfWordsPronoun");
            nodePronoun.appendChild(doc.createTextNode(LcPronounUkrainian.getAccountOfWordsLC().toString()));
            rootElement.appendChild(nodePronoun);
            Element nodeVerb = doc.createElement("totalAccountOfWordsVerb");
            nodeVerb.appendChild(doc.createTextNode(LcVerbUkrainian.getAccountOfWordsLC().toString()));
            rootElement.appendChild(nodeVerb);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("c:\\Nazar\\emps.xml"));

            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("DONE");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Map<String,Integer> readFromXMLStatisticInformation() {
        Map<String,Integer> accountOfWords = LinguisticCategoriesServiceImpl.listOfStatisticItem();
        try {
            File fXmlFile = new File("c:\\Nazar\\emps.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            for (Map.Entry<String,Integer> accountTypeEntry: accountOfWords.entrySet()) {
                Element elementXML = (Element) doc.getElementsByTagName(accountTypeEntry.getKey()).item(0);
                accountTypeEntry.setValue(Integer.valueOf(elementXML.getTextContent()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountOfWords;
    }


}
