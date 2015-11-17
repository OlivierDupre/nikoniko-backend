package fr.thalaf.athena.eadmin.ground.service;

import fr.thalaf.athena.eadmin.ground.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service Exemple. <br/>
 * C'est lui qui porte la logique métier. Exemple.<br/>
 * TODO ODU Supprimer cette classe dès que le concept est compris.
 *
 * @author odupre
 * @version $Id: $
 */
@Service
public class BookServiceWithExternalDependency {

    @Autowired
    private BookService bookService;

    public Book stupidServiceWithExternalDependency(final String bookPatternName) {
        return bookService.stupidService(bookPatternName);
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

}
