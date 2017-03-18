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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class XMLfileReadAndWriteServiceImpl implements XMLfileReadAndWriteService {

    public static boolean saveToXMLStatisticInformationCompleted() {
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
            Path path_emps = Paths.get(new File("").getAbsolutePath()+"\\veslid\\emps.xml");
            StreamResult file = new StreamResult(new File(path_emps.toString()));
            transformer.transform(source, file);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    return false;
    }

    public static void saveToXMLStartStatisticInformation() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("Statistic");
            doc.appendChild(rootElement);
            Element node = doc.createElement("totalAccountOfWords");
            node.appendChild(doc.createTextNode("0"));
            rootElement.appendChild(node);
            Element nodeAdjective = doc.createElement("totalAccountOfWordsAdjective");
            nodeAdjective.appendChild(doc.createTextNode("0"));
            rootElement.appendChild(nodeAdjective);
            Element nodeAdverb = doc.createElement("totalAccountOfWordsAdverb");
            nodeAdverb.appendChild(doc.createTextNode("0"));
            rootElement.appendChild(nodeAdverb);
            Element nodeConjunction = doc.createElement("totalAccountOfWordsConjunction");
            nodeConjunction.appendChild(doc.createTextNode("0"));
            rootElement.appendChild(nodeConjunction);
            Element nodeNoun = doc.createElement("totalAccountOfWordsNoun");
            nodeNoun.appendChild(doc.createTextNode("0"));
            rootElement.appendChild(nodeNoun);
            Element nodeNumeral = doc.createElement("totalAccountOfWordsNumeral");
            nodeNumeral.appendChild(doc.createTextNode("0"));
            rootElement.appendChild(nodeNumeral);
            Element nodePreposition = doc.createElement("totalAccountOfWordsPreposition");
            nodePreposition.appendChild(doc.createTextNode("0"));
            rootElement.appendChild(nodePreposition);
            Element nodePronoun = doc.createElement("totalAccountOfWordsPronoun");
            nodePronoun.appendChild(doc.createTextNode("0"));
            rootElement.appendChild(nodePronoun);
            Element nodeVerb = doc.createElement("totalAccountOfWordsVerb");
            nodeVerb.appendChild(doc.createTextNode("0"));
            rootElement.appendChild(nodeVerb);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            Path path_emps = Paths.get(new File("").getAbsolutePath()+"\\veslid\\emps.xml");
            StreamResult file = new StreamResult(new File(path_emps.toString()));
            transformer.transform(source, file);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void saveToXMLStartTXTfilesInformation() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("TakenTXT");
            doc.appendChild(rootElement);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            Path path_emps = Paths.get(new File("").getAbsolutePath()+"\\veslid\\txt_emps.xml");
            StreamResult file = new StreamResult(new File(path_emps.toString()));
            transformer.transform(source, file);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Map<String,Integer> readFromXMLStatisticInformation() {
        Map<String,Integer> accountOfWords = LinguisticCategoriesServiceImpl.listOfStatisticItem();
        try {
            Path path_emps = Paths.get(new File("").getAbsolutePath()+"\\veslid\\emps.xml");
            File fXmlFile = new File(path_emps.toString());
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

    public  static void defineSystemParameters() {

        if (systemParametersIsAvoid()) {
            writeDefaultSystemParameters();
        }
    }

    public  static void defineSystemParametersSavingTexts() {

        if (systemParametersSavingTextsIsAvoid()) {
            writeDefaultSystemParametersSavingTexts();
        }
    }

    private static void writeDefaultSystemParametersSavingTexts() {
        Path path = Paths.get(new File("").getAbsolutePath()+"\\veslid\\");
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Path path_emps = Paths.get(path+"\\txt_emps.xml");
        if (!Files.exists(path_emps)) {
            try {
                Files.createFile(path_emps);
                saveToXMLStartStatisticInformation();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Path path_json = Paths.get(path+"\\json txt files\\");
        if (!Files.exists(path_json)) {
            try {
                Files.createDirectories(path_json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Boolean systemParametersIsAvoid() {
        Path path = Paths.get(new File("").getAbsolutePath()+"\\veslid\\");
        Path path_emps = Paths.get(path+"\\emps.xml");
        Path path_json = Paths.get(path+"\\json files\\");
        if (!Files.exists(path)||!Files.exists(path_emps)||!Files.exists(path_json)) {
            return true;
        }
        return false;
    }

    public static Boolean systemParametersSavingTextsIsAvoid() {
        Path path = Paths.get(new File("").getAbsolutePath()+"\\veslid\\");
        Path path_emps = Paths.get(path+"\\txt_emps.xml");
        Path path_json_txt = Paths.get(path+"\\json txt files\\");
        if (!Files.exists(path)||!Files.exists(path_emps)||!Files.exists(path_json_txt)) {
            return true;
        }
        return false;
    }

    public static void writeDefaultSystemParameters() {
        Path path = Paths.get(new File("").getAbsolutePath()+"\\veslid\\");
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Path path_emps = Paths.get(path+"\\emps.xml");
        if (!Files.exists(path_emps)) {
            try {
                Files.createFile(path_emps);
                saveToXMLStartStatisticInformation();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Path path_json = Paths.get(path+"\\json files\\");
        if (!Files.exists(path_json)) {
            try {
                Files.createDirectories(path_json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
