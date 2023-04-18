package namematching;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AuthorNamesAbrev {

	public static void main(String[] args) {

		try {
			String input = "hola";

			File xmlFile = new File("C:/Users/belen/git/nameMatching/namematching/src/namematching/AuthorNamesAbrev.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();

			NodeList nodeList = doc.getElementsByTagName("replacement");
			String[][] replacements = new String[nodeList.getLength()][2];

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					String find = element.getElementsByTagName("input").item(0).getTextContent();
					String replace = element.getElementsByTagName("output").item(0).getTextContent();
					replacements[i][0] = find;
					replacements[i][1] = replace;
				}
			}

			for (String[] replacement : replacements) {
				input = input.replaceAll(replacement[0], replacement[1]);
			}

			System.out.println("Replaced string: " + input);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
