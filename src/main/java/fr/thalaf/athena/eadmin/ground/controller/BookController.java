package fr.thalaf.athena.eadmin.ground.controller;

import fr.thalaf.athena.eadmin.ground.model.Book;
import fr.thalaf.athena.eadmin.ground.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller Rest Exemple. <br/>
 * Comme tous les Controller Rest, l'objectif est JUSTE d'être un passe plat
 * vers le service. Ce qui permet d'externaliser les services, de les
 * réutiliser, etc... Exemple.<br/>
 * TODO ODU Supprimer cette classe dès que le concept est compris.
 *
 * @author odupre
 * @version $Id: $
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = GET, value = "/list")
    public Book list(@RequestParam(value = "pattern", defaultValue = "*", required = false) String pattern) {
        return bookService.stupidService(pattern);
    }
}
