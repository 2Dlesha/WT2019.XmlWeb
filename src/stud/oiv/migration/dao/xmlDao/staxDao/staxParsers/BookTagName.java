package stud.oiv.migration.dao.xmlDao.staxDao.staxParsers;

public enum BookTagName {
    BOOKS,COMICS,ID,NAME,PAGECOUNT,AUTHOR,GENRE,TYPE,SUBJECT,STUDYBOOK,ARTBOOK;
    public static BookTagName getElementTagName(String element)
    {
        return BookTagName.valueOf(element.toUpperCase().replace("-","_"));
    }
}