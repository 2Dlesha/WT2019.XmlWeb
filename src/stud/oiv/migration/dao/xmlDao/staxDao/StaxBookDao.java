package stud.oiv.migration.dao.xmlDao.staxDao;

import stud.oiv.migration.beans.Book;
import stud.oiv.migration.beans.Librarian;
import stud.oiv.migration.dao.BookDao;
import stud.oiv.migration.dao.DaoException;
import stud.oiv.migration.dao.xmlDao.staxDao.staxParsers.StaxBookParser;
import stud.oiv.migration.dao.xmlDao.staxDao.staxParsers.StaxLibrarianParser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class StaxBookDao implements BookDao {
    @Override
    public List<Book> getAllBooks() throws DaoException {
        List<Book> books = null;
        try {
            InputStream input = new FileInputStream("D:\\Study\\University\\5 term\\WT\\XmlParseWeb\\src\\XmlStorage\\books.xml");
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(input);
            books = StaxBookParser.parse(reader);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return  books ;
    }

    @Override
    public void addBooks(List<Book> books) throws DaoException {

    }
}
