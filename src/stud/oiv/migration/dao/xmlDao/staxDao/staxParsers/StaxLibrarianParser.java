package stud.oiv.migration.dao.xmlDao.staxDao.staxParsers;

import stud.oiv.migration.beans.Book;
import stud.oiv.migration.beans.Librarian;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StaxLibrarianParser {
    public static List<Librarian> parse(XMLStreamReader reader) throws XMLStreamException
    {
        List<Librarian> librarians = new ArrayList<>();
        Librarian librarian = null;
        LibrarianTagName elementName = null;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type)
            {
                case XMLStreamConstants.START_ELEMENT:
                {
                    elementName = LibrarianTagName.valueOf(reader.getLocalName().toUpperCase().replace("-","_"));
                    if(reader.getLocalName().equals("Librarian"))
                    {
                        librarian = new Librarian("","","");
                    }
                }
                break;
                case XMLStreamConstants.CHARACTERS:
                {
                    String text = reader.getText().trim();
                    if(text.isEmpty())
                    {break;}
                    switch( elementName){
                        case ID:
                            librarian.setId(Integer.parseInt(text));
                            break;
                        case PHONENUMBER:
                            librarian.setPhoneNumber(text);
                            break;
                        case LASTNAME:
                            librarian.setLastName(text);
                            break;
                        case FIRSTNAME:
                            librarian.setFirstName(text);
                            break;
                    }
                }
                break;
                case XMLStreamConstants.END_ELEMENT:
                {
                    String text = reader.getLocalName();
                    elementName = LibrarianTagName.valueOf(text.toUpperCase().replace("-","_"));
                    switch(elementName){
                        case LIBRARIAN:
                            librarians.add(librarian);
                            librarian = null;
                            break;
                    }
                }
                break;
            }
        }
        return librarians;
    }
}
