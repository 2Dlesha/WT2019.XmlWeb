package stud.oiv.migration.dao.xmlDao.domDao;

import stud.oiv.migration.beans.Book;
import stud.oiv.migration.dao.BookDao;
import stud.oiv.migration.dao.DaoException;
import stud.oiv.migration.dao.xmlDao.domDao.domParsers.DomBookParser;

import java.util.ArrayList;
import java.util.List;

public class DomBookDao implements BookDao {
    @Override
    public List<Book> getAllBooks() throws DaoException {
        List<Book> books = new ArrayList<>();
        DomBookParser domBookParser = new DomBookParser();
        books = domBookParser.getAllBooks("");
        return books;
    }

    @Override
    public void addBooks(List<Book> books) throws DaoException {

    }
}
