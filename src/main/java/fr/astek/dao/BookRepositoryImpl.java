package fr.thalaf.athena.eadmin.ground.dao;

import fr.thalaf.athena.eadmin.ground.dao.configuration.DbManager;
import fr.thalaf.athena.eadmin.ground.model.Book;
import java.util.List;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * The repository of Book (model). Exemple.<br/>
 * TODO ODU Supprimer cette classe dès que le concept est compris.
 *
 * @author Astek
 */
@View(name = "all", map = "function(doc) { if (doc.type === 'Book') {emit(null, doc); } }")
@Repository
public class BookRepositoryImpl extends CouchDbRepositorySupport<Book> implements BookRepository {

    /**
     * BookRepository default constructor.
     *
     * @param dbManager
     */
    @Autowired
    public BookRepositoryImpl(final DbManager dbManager) {
        super(Book.class, dbManager.getDb(), true);
        initStandardDesignDocument();
    }

    /**
     * Find by book id.
     *
     * @return
     */
    @View(name = "by_bookId", map = "function(doc) { if (doc.bookId && doc.type === 'Book') { emit(doc.bookId, doc); } }")
    @Override
    public List<Book> find(final String bookId) {
        return db.queryView(createQuery("by_bookId").key(bookId).includeDocs(true), Book.class);
    }

    @Override
    public void removeAll() {
        List<Book> metadatas = getAll();

        metadatas.stream().forEach((metadata) -> {
            remove(metadata);
        });
    }
}
