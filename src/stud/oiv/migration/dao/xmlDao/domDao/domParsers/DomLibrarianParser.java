package stud.oiv.migration.dao.xmlDao.domDao.domParsers;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import stud.oiv.migration.beans.Librarian;
import stud.oiv.migration.dao.DaoException;

import java.util.ArrayList;
import java.util.List;

public class DomLibrarianParser {


    //<firstname>Mark</firstname>
     //   <lastname>Zuckerberg</lastname>
     //   <phonenumber>+324223535</phonenumber>
    public List<Librarian> getAllLibrarians(String filePath) throws DaoException {
        List<Librarian> librarians  = new ArrayList<>();
        try {
            DOMParser parser = new DOMParser();
            parser.parse("D:\\Study\\University\\5 term\\WT\\XmlParseWeb\\src\\XmlStorage\\librarians.xml");
            Document document = parser.getDocument();
            Element root = document.getDocumentElement();
            NodeList librarianNodes = root.getElementsByTagName("Librarian");
            Librarian librarian = null;
            for(int i = 0; i < librarianNodes.getLength();i++)
            {
                librarian = new Librarian("","","");
                Element librarianElement = (Element) librarianNodes.item(i);
                librarian.setId(Integer.parseInt(getSingleChild(librarianElement,"id").getTextContent().trim()));
                librarian.setFirstName(getSingleChild(librarianElement,"firstname").getTextContent().trim());
                librarian.setLastName((getSingleChild(librarianElement,"lastname").getTextContent().trim()));
                librarian.setPhoneNumber((getSingleChild(librarianElement,"phonenumber").getTextContent().trim()));
                librarians.add(librarian);
            }

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            librarians = new ArrayList<>();
        }
        return librarians;
    }

    private static Element getSingleChild(Element element,String childName)
    {
        NodeList nlist = element.getElementsByTagName(childName);
        Element child = (Element) nlist.item(0);
        return child;
    }
}
