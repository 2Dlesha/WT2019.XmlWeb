package stud.oiv.migration.dao.xmlDao.domDao.domParsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import stud.oiv.migration.beans.*;
import stud.oiv.migration.dao.DaoException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomBookParser {

    public List<Book> getAllBooks(String filePath) throws DaoException {
        List<Book> books  = new ArrayList<>();
        try {

            DocumentBuilder builder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            Document document = builder.parse(new File("D:\\Study\\University\\5 term\\WT\\XmlParseWeb\\src\\XmlStorage\\books.xml"));
            //DOMParser parser = new DOMParser();
            //parser.parse("D:\\Study\\University\\5 term\\WT\\XmlParseWeb\\src\\XmlStorage\\books.xml");
            //Document document = parser.getDocument();
            Element root = document.getDocumentElement();

            NodeList comicsNodes = root.getElementsByTagName("Comics");
            for(int i = 0; i < comicsNodes.getLength();i++)
            {
                Element comicsElement = (Element) comicsNodes.item(i);
                books.add(parseComics(comicsElement));
            }

            NodeList artBookNodes = root.getElementsByTagName("ArtBook");
            for(int i = 0; i < artBookNodes.getLength();i++)
            {
                Element comicsElement = (Element) artBookNodes.item(i);
                books.add(parseArtBook(comicsElement));
            }

            NodeList studyBookNodes = root.getElementsByTagName("StudyBook");
            for(int i = 0; i < studyBookNodes.getLength();i++)
            {
                Element comicsElement = (Element) studyBookNodes.item(i);
                books.add(parseStudyBook(comicsElement));
            }

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            books = new ArrayList<>();
        }
        return books;
    }


    public static List<Book> parseBooks(Element element) throws SAXException, IOException
    {
        Element root = element;

        List<Book> books  = new ArrayList<>();

        NodeList comicsNodes = root.getElementsByTagNameNS("http://www.2dlesha.org/books/","Comics");
        for(int i = 0; i < comicsNodes.getLength();i++)
        {
            Element comicsElement = (Element) comicsNodes.item(i);
            books.add(parseComics(comicsElement));
        }

        NodeList artBookNodes = root.getElementsByTagNameNS("http://www.2dlesha.org/books/","ArtBook");
        for(int i = 0; i < artBookNodes.getLength();i++)
        {
            Element comicsElement = (Element) artBookNodes.item(i);
            books.add(parseArtBook(comicsElement));
        }

        NodeList studyBookNodes = root.getElementsByTagNameNS("http://www.2dlesha.org/books/","StudyBook");
        for(int i = 0; i < studyBookNodes.getLength();i++)
        {
            Element comicsElement = (Element) studyBookNodes.item(i);
            books.add(parseStudyBook(comicsElement));
        }
        return books;
    }

    private static Comics parseComics(Element element)
    {
        Comics book = new Comics("",0,"","","");
        book.setId(Integer.parseInt(getSingleChild(element,"id").getTextContent().trim()));
        book.setName(getSingleChild(element,"name").getTextContent().trim());
        book.setPageCount(Integer.parseInt(getSingleChild(element,"pagecount").getTextContent().trim()));
        book.setAuthor(getSingleChild(element,"author").getTextContent().trim());
        book.setGenre(getSingleChild(element,"genre").getTextContent().trim());
        book.setType(getSingleChild(element,"type").getTextContent().trim());
        return book;
    }

    private static ArtBook parseArtBook(Element element)
    {
        ArtBook book = new ArtBook("",0,"","");
        book.setId(Integer.parseInt(getSingleChild(element,"id").getTextContent().trim()));
        book.setName(getSingleChild(element,"name").getTextContent().trim());
        book.setPageCount(Integer.parseInt(getSingleChild(element,"pagecount").getTextContent().trim()));
        book.setAuthor(getSingleChild(element,"author").getTextContent().trim());
        book.setGenre(getSingleChild(element,"genre").getTextContent().trim());
        return book;
    }

    private static StudyBook parseStudyBook(Element element)
    {
        StudyBook book = new StudyBook("",0,"","");
        book.setId(Integer.parseInt(getSingleChild(element,"id").getTextContent().trim()));
        book.setName(getSingleChild(element,"name").getTextContent().trim());
        book.setPageCount(Integer.parseInt(getSingleChild(element,"pagecount").getTextContent().trim()));
        book.setAuthor(getSingleChild(element,"author").getTextContent().trim());
        book.setSubject(getSingleChild(element,"subject").getTextContent().trim());
        return book;
    }

    private static Element getSingleChild(Element element,String childName)
    {
        NodeList list = element.getElementsByTagNameNS("http://www.2dlesha.org/books/",childName);
        Element child = (Element) list.item(0);
        return child;
    }
}
