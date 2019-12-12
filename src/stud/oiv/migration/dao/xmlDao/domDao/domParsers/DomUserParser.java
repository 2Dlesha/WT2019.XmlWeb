package stud.oiv.migration.dao.xmlDao.domDao.domParsers;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import stud.oiv.migration.beans.*;
import stud.oiv.migration.dao.DaoException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static stud.oiv.migration.dao.xmlDao.domDao.domParsers.DomBookParser.parseBooks;

/*
    <User>
        <id>1213</id>
        <firstname>Roman</firstname>
        <lastname>Shuliak</lastname>
        <dateofmembership>2000-10-10</dateofmembership>
        <address>Minsk</address>
        <books>
            <bk:ArtBook>
                <bk:id>2</bk:id>
                <bk:name>War and peace</bk:name>
                <bk:pagecount>400</bk:pagecount>
                <bk:author>Lev</bk:author>
                <bk:genre>roman</bk:genre>
            </bk:ArtBook>
            <bk:StudyBook>
                <bk:id>3</bk:id>
                <bk:name>Math 9</bk:name>
                <bk:pagecount>100</bk:pagecount>
                <bk:author>ClearMan</bk:author>
                <bk:subject>Math</bk:subject>
            </bk:StudyBook>
        </books>
    </User>
*/
public class DomUserParser {
    public List<User> getAllUsers(String filePath) throws DaoException {
        List<User> users  = new ArrayList<>();
        try {
            DOMParser parser = new DOMParser();
            parser.parse("D:\\Study\\University\\5 term\\WT\\XmlParseWeb\\src\\XmlStorage\\users.xml");
            Document document = parser.getDocument();
            Element root = document.getDocumentElement();
            NodeList userNodes = root.getElementsByTagName("User");
            User user = null;
            for(int i = 0; i < userNodes.getLength();i++)
            {
                user = new User("","","","",null);
                Element userElement = (Element) userNodes.item(i);
                user.setId(Integer.parseInt(getSingleChild(userElement,"id").getTextContent().trim()));
                user.setFirstName(getSingleChild(userElement,"firstname").getTextContent().trim());
                user.setLastName((getSingleChild(userElement,"lastname").getTextContent().trim()));
                user.setDateOfMembership((getSingleChild(userElement,"dateofmembership").getTextContent().trim()));
                user.setAddress((getSingleChild(userElement,"address").getTextContent().trim()));
                user.setBooks(new ArrayList<>(parseBooks(getSingleChild(userElement,"books"))));
                users.add(user);
            }

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            users = new ArrayList<>();
        }
        return users;
    }


    private static Element getSingleChild(Element element,String childName)
    {
        NodeList list = element.getElementsByTagName(childName);
        Element child = (Element) list.item(0);
        return child;
    }
}
