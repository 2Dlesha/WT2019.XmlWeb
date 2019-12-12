package stud.oiv.migration.dao.xmlDao.staxDao.staxParsers;

public enum LibrarianTagName {
    LIBRARIANS,LIBRARIAN,ID,FIRSTNAME,LASTNAME,PHONENUMBER;
    public static LibrarianTagName getElementTagName(String element)
    {
        return LibrarianTagName.valueOf(element.toUpperCase().replace("-","_"));
    }
}
