package stud.oiv.migration.dao.xmlDao.staxDao;

import stud.oiv.migration.beans.Book;
import stud.oiv.migration.beans.User;
import stud.oiv.migration.dao.DaoException;
import stud.oiv.migration.dao.UserDao;
import stud.oiv.migration.dao.xmlDao.staxDao.staxParsers.StaxBookParser;
import stud.oiv.migration.dao.xmlDao.staxDao.staxParsers.StaxUserParser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class StaxUserDao implements UserDao {
    @Override
    public List<User> getAllUsers() throws DaoException {
        List<User> users = null;
        try {
            InputStream input = new FileInputStream("D:\\Study\\University\\5 term\\WT\\XmlParseWeb\\src\\XmlStorage\\users.xml");
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(input);
            users = StaxUserParser.parse(reader);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            System.out.println(e.getLocalizedMessage());

        }
        return users ;
    }

    @Override
    public void addUsers(List<User> users) throws DaoException {

    }
}
