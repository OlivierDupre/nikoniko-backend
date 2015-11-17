package fr.thalaf.athena.eadmin.ground.service;

import fr.thalaf.athena.eadmin.ground.model.Book;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exemple.<br/>
 * TODO ODU Supprimer cette classe dès que le concept est compris.
 *
 * @author odupre
 */
@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceTest.class);

    @InjectMocks
    private BookService bookService;

    /**
     * Test of stupidService method, of class BookService.
     */
    @Test
    public void testStupidService() {
        LOGGER.trace("stupidService");

        final String pattern = "Toto";
        final Book result = bookService.stupidService(pattern);

        assertEquals("TotobookName", result.getName());
    }
}
