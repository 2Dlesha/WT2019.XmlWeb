package stud.oiv.migration.dao.xmlDao.staxDao.staxParsers;

import stud.oiv.migration.beans.*;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StaxUserParser {
    public static List<User> parse(XMLStreamReader reader) throws XMLStreamException
    {
    List<Book> books = new ArrayList<Book>();
    List<User> users = new ArrayList<User>();
    User user = null;
    Book book = null;
    BookTagName bookTagName = null;
    UserTagName userTagName = null;
    while (reader.hasNext())
    {
        int type = reader.next();
        switch (type)
        {
            case XMLStreamConstants.START_ELEMENT:
            {
                String text = reader.getLocalName();
                if(text.equals("User"))
                {
                    user = new User("","","","",null);
                }
                if(text.equals("Comics"))
                {
                    book = new Comics("",0,"","","");
                }
                if(text.equals("ArtBook"))
                {
                    book = new ArtBook("",0,"","");
                }
                if(text.equals("StudyBook"))
                {
                    book = new StudyBook("",0,"","");
                }

                if(book != null)
                    bookTagName = BookTagName.valueOf(reader.getLocalName().toUpperCase().replace("BK:","_"));
                else
                    userTagName = UserTagName.valueOf(reader.getLocalName().toUpperCase().replace("-","_"));

            }
            break;
            case XMLStreamConstants.CHARACTERS:
            {
                String text = reader.getText().trim();
                if(text.isEmpty()){
                    break;
                }
                if(book != null) {
                    //bookTagName = BookTagName.valueOf(reader.getLocalName().toUpperCase().replace("BK:", ""));
                    switch (bookTagName) {
                        case ID:
                            book.setId(Integer.parseInt(text.toString()));
                            break;
                        case NAME:
                            book.setName(text.toString());
                            break;
                        case TYPE:
                            ((Comics) book).setType(text.toString());
                            break;
                        case GENRE:
                            if (book instanceof ArtBook)
                                ((ArtBook) book).setGenre(text.toString());
                            if (book instanceof Comics)
                                ((Comics) book).setGenre(text.toString());
                            break;
                        case AUTHOR:
                            book.setAuthor(text.toString());
                            break;
                        case SUBJECT:
                            ((StudyBook) book).setSubject(text.toString());
                            break;
                        case PAGECOUNT:
                            book.setPageCount(Integer.parseInt(text.toString()));
                            break;
                    }
                }
                else {
                    //userTagName = UserTagName.valueOf(reader.getLocalName().toUpperCase().replace("-", "_"));
                    switch (userTagName) {
                        case FIRSTNAME:
                            user.setFirstName(text.toString());
                            break;
                        case LASTNAME:
                            user.setLastName(text.toString());
                            break;
                        case ID:
                            user.setId(Integer.parseInt(text.toString()));
                            break;
                        case ADDRESS:
                            user.setAddress(text.toString());
                            break;
                        case DATEOFMEMBERSHIP:
                            user.setDateOfMembership(text.toString());
                            break;

                    }
                }
            }
            break;
            case XMLStreamConstants.END_ELEMENT:
            {
                if(book != null) {
                    bookTagName = BookTagName.valueOf(reader.getLocalName().toUpperCase().replace("BK:", ""));
                    switch (bookTagName) {
                        case STUDYBOOK:
                        case COMICS:
                        case ARTBOOK:
                            books.add(book);
                            book = null;
                            break;
                    }
                }
                else {
                    userTagName = UserTagName.valueOf(reader.getLocalName().toUpperCase().replace("-", "_"));
                    switch (userTagName) {
                        case BOOKS:
                            user.setBooks(new ArrayList<>(books));
                            books = new ArrayList<Book>();
                            break;
                        case USER:
                            users.add(user);
                            user = null;
                            break;
                    }
                }
            }
            break;
        }
    }
        return users;
    }
}
