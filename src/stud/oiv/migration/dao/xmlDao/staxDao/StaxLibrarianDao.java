package stud.oiv.migration.dao.xmlDao.staxDao;

import stud.oiv.migration.beans.Librarian;
import stud.oiv.migration.dao.DaoException;
import stud.oiv.migration.dao.LibrarianDao;
import stud.oiv.migration.dao.xmlDao.staxDao.staxParsers.StaxLibrarianParser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class StaxLibrarianDao implements LibrarianDao {
    @Override
    public List<Librarian> getAllLibrarians() throws DaoException {
        List<Librarian> librarians = null;
        try {
            InputStream input = new FileInputStream("D:\\Study\\University\\5 term\\WT\\XmlParseWeb\\src\\XmlStorage\\librarians.xml");
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(input);
            librarians = StaxLibrarianParser.parse(reader);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return  librarians ;
    }

    @Override
    public void addLibrarians(List<Librarian> librarians) throws DaoException {

    }
}
