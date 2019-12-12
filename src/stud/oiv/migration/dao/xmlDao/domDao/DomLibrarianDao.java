package stud.oiv.migration.dao.xmlDao.domDao;

import stud.oiv.migration.beans.Book;
import stud.oiv.migration.beans.Librarian;
import stud.oiv.migration.dao.DaoException;
import stud.oiv.migration.dao.LibrarianDao;
import stud.oiv.migration.dao.xmlDao.domDao.domParsers.DomBookParser;
import stud.oiv.migration.dao.xmlDao.domDao.domParsers.DomLibrarianParser;


import java.util.ArrayList;
import java.util.List;

public class DomLibrarianDao implements LibrarianDao {
    @Override
    public List<Librarian> getAllLibrarians() throws DaoException {
        List<Librarian> librarians  = new ArrayList<>();
        DomLibrarianParser domParser = new DomLibrarianParser();
        librarians = domParser.getAllLibrarians("");
        return librarians;
    }

    @Override
    public void addLibrarians(List<Librarian> librarians) throws DaoException {

    }
}
