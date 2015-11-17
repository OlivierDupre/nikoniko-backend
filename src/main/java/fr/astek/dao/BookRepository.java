package fr.thalaf.athena.eadmin.ground.dao;

import fr.thalaf.athena.eadmin.ground.model.Book;
import java.util.List;
import org.ektorp.support.GenericRepository;

/**
 * Exemple.<br/>
 * TODO ODU Supprimer cette classe dès que le concept est compris.
 *
 * @author odupre
 */
public interface BookRepository extends GenericRepository<Book> {

    public List<Book> find(String bookId);

    /**
     * remove all data from database.
     */
    public void removeAll();
}
