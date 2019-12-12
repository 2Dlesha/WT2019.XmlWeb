package stud.oiv.migration.dao.xmlDao.staxDao.staxParsers;

import stud.oiv.migration.beans.*;
import stud.oiv.migration.dao.xmlDao.saxDao.saxParsers.BooksTagName;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StaxBookParser {
    public static List<Book> parse(XMLStreamReader reader) throws XMLStreamException
    {
        List<Book> books = new ArrayList<>();
        Book book = null;
        BookTagName elementName = null;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type)
            {
                case XMLStreamConstants.START_ELEMENT:
                {
                    elementName = BookTagName.valueOf(reader.getLocalName().toUpperCase().replace("-","_"));
                    String text = reader.getLocalName();
                    if( text.equals("Comics"))
                    {
                        book = new Comics("",0,"","","");
                    }
                    if( text.equals("ArtBook"))
                    {
                        book = new ArtBook("",0,"","");
                    }
                    if( text.equals("StudyBook"))
                    {
                        book = new StudyBook("",0,"","");
                    }
                }
                break;
                case XMLStreamConstants.CHARACTERS:
                {
                    String text = reader.getText().trim();
                    if(text.isEmpty()){
                        break;
                    }

                    switch(elementName){
                        case ID:
                            book.setId(Integer.parseInt(text));
                            break;
                        case NAME:
                            book.setName(text);
                            break;
                        case TYPE:
                            ((Comics)book).setType(text);
                            break;
                        case GENRE:
                            if(book instanceof ArtBook)
                                ((ArtBook)book).setGenre(text);
                            if(book instanceof Comics)
                                ((Comics)book).setGenre(text);
                            break;
                        case AUTHOR:
                            book.setAuthor(text);
                            break;
                        case SUBJECT:
                            ((StudyBook)book).setSubject(text);
                            break;
                        case PAGECOUNT:
                            book.setPageCount(Integer.parseInt(text));
                            break;
                    }
                }
                break;
                case XMLStreamConstants.END_ELEMENT:
                {
                    elementName = BookTagName.valueOf(reader.getLocalName().toUpperCase().replace("-","_"));
                    switch(elementName){
                        case STUDYBOOK:
                        case COMICS:
                        case ARTBOOK:
                            books.add(book);
                            book = null;
                            break;
                    }
                }
                break;
            }
        }
        return books;
    }
}
