package stud.oiv.migration.dao.xmlDao.staxDao.staxParsers;

public enum UserTagName {
    USERS,USER,ID,FIRSTNAME,LASTNAME,DATEOFMEMBERSHIP,ADDRESS,BOOKS;
    public static UserTagName getElementTagName(String element)
    {
        return UserTagName.valueOf(element.toUpperCase().replace("-","_"));
    }
}