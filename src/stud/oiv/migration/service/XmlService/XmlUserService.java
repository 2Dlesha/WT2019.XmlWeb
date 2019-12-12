package stud.oiv.migration.service.XmlService;

import stud.oiv.migration.beans.Librarian;
import stud.oiv.migration.beans.User;
import stud.oiv.migration.dao.xmlDao.saxDao.SaxUserDao;
import stud.oiv.migration.service.UserService;

import java.util.List;

public class XmlUserService implements UserService {
    @Override
    public List<User> getAll() {
        List<User> users = null;
        SaxUserDao dao = new SaxUserDao();
        try {
            users = dao.getAllUsers();
        }catch (Exception e)
        {
        }
        return users;
    }
}
