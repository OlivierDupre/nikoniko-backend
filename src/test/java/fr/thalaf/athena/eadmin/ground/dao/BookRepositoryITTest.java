package fr.thalaf.athena.eadmin.ground.dao;

import fr.thalaf.athena.eadmin.ground.Main;
import fr.thalaf.athena.eadmin.ground.dao.configuration.CouchDbConfiguration;
import fr.thalaf.athena.eadmin.ground.dao.configuration.DbManager;
import fr.thalaf.athena.eadmin.ground.service.BookService;
import java.util.Collections;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Exemple. <br/>
 * TODO ODU Supprimer cette classe dès que le concept est compris. <br/>
 *
 * Ici, on utilise le Runner {@linkplain SpringJUnit4ClassRunner} car on fait de
 * l'intégration, et plus du bouchonnage. Donc on n'utilise plus Mockito.
 *
 * @author odupre
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackageClasses = Main.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = BookRepositoryITTest.class)
@TestPropertySource(locations = "classpath:/fr/thalaf/athena/eadmin/ground/dao/dbAthena.properties")
public class BookRepositoryITTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookRepositoryITTest.class);

    private BookRepository bookRepository;

    @Autowired
    private DbManager dbManager;
    @Autowired
    private BookService bookService;
    @Autowired
    private CouchDbConfiguration couchDbConfiguration;

    @Before
    public void setup() {
        bookRepository = new BookRepositoryImpl(dbManager);
    }

    @Test
    public void testFindAll() {
        LOGGER.trace("testFindAll on {} with {}", bookRepository, dbManager);
        assertEquals(Collections.EMPTY_LIST, bookRepository.find("UNKNOWN"));
    }

    /**
     * This is just a truly dumb test, to demonstrate Value injection from
     * properties in a Spring tests context, in case it might ever be needed.
     */
    @Test
    public void testPropertyValueInjection() {
        assertEquals("This is just a sample", bookService.getBookPatternName());
    }
}
