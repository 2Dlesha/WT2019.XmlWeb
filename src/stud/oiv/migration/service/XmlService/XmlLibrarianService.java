package stud.oiv.migration.service.XmlService;

import stud.oiv.migration.beans.Book;
import stud.oiv.migration.beans.Librarian;
import stud.oiv.migration.beans.User;
import stud.oiv.migration.dao.xmlDao.domDao.DomBookDao;
import stud.oiv.migration.dao.xmlDao.saxDao.SaxLibrarianDao;
import stud.oiv.migration.dao.xmlDao.saxDao.SaxUserDao;
import stud.oiv.migration.dao.xmlDao.staxDao.StaxLibrarianDao;
import stud.oiv.migration.service.LibrarianService;

import java.util.List;

public class XmlLibrarianService implements LibrarianService {
    @Override
    public List<Librarian> getAll(String sourceFile) {
        List<Librarian> librarians = null;
        StaxLibrarianDao dao = new StaxLibrarianDao();
        try {
            librarians = dao.getAllLibrarians();
        }catch (Exception e)
        {
        }
        return librarians;
    }
}
