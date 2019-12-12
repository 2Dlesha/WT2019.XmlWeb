package stud.oiv.migration.service.XmlService;

import stud.oiv.migration.beans.Book;
import stud.oiv.migration.dao.xmlDao.domDao.DomBookDao;
import stud.oiv.migration.dao.xmlDao.saxDao.SaxBookDao;
import stud.oiv.migration.service.BookService;

import java.util.List;

public class XmlBookService implements BookService {
    @Override
    public List<Book> getAll() {
        List<Book> books = null;
        SaxBookDao dao = new SaxBookDao();
        try {
            books = dao.getAllBooks();
        }catch (Exception e)
        {
        }
        return books;

    }
}
