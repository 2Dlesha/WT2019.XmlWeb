package stud.oiv.migration.dao.xmlDao.domDao;

import stud.oiv.migration.beans.Librarian;
import stud.oiv.migration.beans.User;
import stud.oiv.migration.dao.DaoException;
import stud.oiv.migration.dao.UserDao;
import stud.oiv.migration.dao.xmlDao.domDao.domParsers.DomLibrarianParser;
import stud.oiv.migration.dao.xmlDao.domDao.domParsers.DomUserParser;

import java.util.ArrayList;
import java.util.List;
/**/
public class DomUserDao implements UserDao {
    @Override
    public List<User> getAllUsers() throws DaoException {
        List<User> users  = new ArrayList<>();
        DomUserParser domParser = new DomUserParser();
        users = domParser.getAllUsers("");
        return users;
    }

    @Override
    public void addUsers(List<User> users) throws DaoException {

    }
}
