package fr.thalaf.athena.eadmin.ground.service;

import fr.thalaf.athena.eadmin.ground.model.Book;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Value;
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
public class BookService {

    private final AtomicLong counter = new AtomicLong();

    @Value("${eBook.sample.book.external.property}")
    private String bookPatternName;

    public Book stupidService(final String pattern) {
        return new Book(String.valueOf(counter.incrementAndGet()), pattern + "bookName", 2048, 3);
    }

    public String getBookPatternName() {
        return bookPatternName;
    }

    public void setBookPatternName(String bookPatternName) {
        this.bookPatternName = bookPatternName;
    }
}
