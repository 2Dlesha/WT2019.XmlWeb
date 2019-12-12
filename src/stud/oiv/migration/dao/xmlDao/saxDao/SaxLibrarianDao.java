package stud.oiv.migration.dao.xmlDao.saxDao;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import stud.oiv.migration.beans.Librarian;
import stud.oiv.migration.dao.DaoException;
import stud.oiv.migration.dao.LibrarianDao;
import stud.oiv.migration.dao.xmlDao.saxDao.saxParsers.LibrarianSaxHandler;

import java.util.List;

public class SaxLibrarianDao implements LibrarianDao {

    public static final Logger LOG = Logger.getLogger(LibrarianDao.class.getName());

    @Override
    public List<Librarian> getAllLibrarians()throws DaoException {
        List<Librarian> librarians = null;
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            LibrarianSaxHandler handler = new LibrarianSaxHandler();
            reader.setContentHandler(handler);
            reader.parse("D:\\Study\\University\\5 term\\WT\\XmlParseWeb\\src\\XmlStorage\\librarians.xml");
            reader.setFeature("http://xml.org/sax/features/validation",true);
            reader.setFeature("http://xml.org/sax/features/namespaces",true);
            reader.setFeature("http://xml.org/sax/features/string-interning",true);
            reader.setFeature("http://apache.org/xml/features/validation/schema",false);
            librarians = handler.getLibrarianList();
        }catch (Exception e) {
            LOG.log(Level.ERROR,e.getMessage());
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
            throw new DaoException(e);
        }
        return librarians;
    }

    @Override
    public void addLibrarians(List<Librarian> librarians)throws DaoException {

    }
}
