package fr.thalaf.athena.eadmin.ground.service;

import fr.thalaf.athena.eadmin.ground.model.Book;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Exemple. <br/>
 * TODO ODU Supprimer cette classe dès que le concept est compris. null {@linkplain http://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/testing.html}
 * {@linkplain http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/test/context/TestPropertySource.html}
 *
 * @author odupre
 */
@RunWith(MockitoJUnitRunner.class)
public class BookServiceWithMockAndExternalDependencyTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceWithMockAndExternalDependencyTest.class);
    private static final String TEST_ID = "42";

    /**
     * Cette annotation ne marche pas avec ce Runner
     * {@linkplain SpringJUnit4ClassRunner}. Il faudrait utiliser le Runner
     * Unitils.. mais il est incompatible avec la valorisation des attribut
     * annoté {@linkplain Value}....
     *
     * On instancie donc cet object dans le {@linkplain Before}.
     */
    @InjectMocks
    private BookServiceWithExternalDependency bookServiceWithExternalDependency;

    /**
     * {@linkplain http://site.mockito.org/#how} <br/>
     * {@linkplain http://unitils.org/tutorial-inject.html}
     */
    @Mock
    private BookService bookServiceMock;

    /**
     * {@linkplain http://site.mockito.org/#how} <br/>
     * {@linkplain http://unitils.org/tutorial-inject.html}
     */
    @Mock
    private Book bookMock;

    public BookServiceWithMockAndExternalDependencyTest() {
    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test of stupidServiceWithExternalDependency method, of class
     * BookServiceWithExternalDependency.
     */
    @Test
    public void testStupidServiceWithExternalDependency() {
        final String pattern = "Toto";
        LOGGER.trace("stupidService with pattern {}", pattern);

        when(bookServiceMock.stupidService(pattern)).thenReturn(bookMock);
        when(bookMock.getId()).thenReturn(TEST_ID);

        final Book result = bookServiceWithExternalDependency.stupidServiceWithExternalDependency(pattern);

        assertEquals(TEST_ID, result.getId());

        verify(bookServiceMock).stupidService(pattern);
    }

    @Test(expected = NullPointerException.class)
    public void testRinsingAnException() {
        bookServiceWithExternalDependency.setBookService(null);
        // Ça va lever une belle exception... qu'on expect ci-dessus...
        bookServiceWithExternalDependency.getBookService().getBookPatternName();
    }
}
