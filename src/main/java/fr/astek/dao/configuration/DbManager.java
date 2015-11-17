package fr.thalaf.athena.eadmin.ground.dao.configuration;

import javax.annotation.PostConstruct;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DbManager for couchDB connection. TODO ODU Externaliser dans un projet à
 * part. Partager avec les autres équipes.
 *
 * @author astek
 */
@Service
public class DbManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbManager.class);

    @Autowired
    private CouchDbConfiguration couchDbConfiguration;

    /**
     * db connection
     */
    private CouchDbConnector db;

    @PostConstruct
    protected void dbInit() {
        LOGGER.info("Instanciating DbManager for db {}:{}/{}", couchDbConfiguration.getHost(), couchDbConfiguration.getPort(),
                couchDbConfiguration.getDatabaseName());

        final StdHttpClient.Builder httpClientBuilder = new StdHttpClient.Builder()
                .host(couchDbConfiguration.getHost())
                .port(Integer.parseInt(couchDbConfiguration.getPort()));

        // TODO ODU Use Optional.isPresent() (JDK8) -> Impact CouchDbConfiguration. Théoriquement, Spring Inject gère bien les Optional.
        if (couchDbConfiguration.getUsername() != null && couchDbConfiguration.getPassword() != null) {
            LOGGER.trace("Connection to Db with Username {}", couchDbConfiguration.getUsername());
            httpClientBuilder.username(couchDbConfiguration.getUsername());
            httpClientBuilder.password(couchDbConfiguration.getPassword());
        }

        final HttpClient httpClient = httpClientBuilder.build();

        CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
        LOGGER.trace("dbInstance retrieved.");

        db = new StdCouchDbConnector(couchDbConfiguration.getDatabaseName(), dbInstance);

        LOGGER.trace("Db connector instanciated");

        db.createDatabaseIfNotExists();
    }

    /**
     * getDb
     *
     * @return CouchDbConnector
     */
    public CouchDbConnector getDb() {
        return db;
    }

    public CouchDbConfiguration getCouchDbConfiguration() {
        return couchDbConfiguration;
    }

    public void setCouchDbConfiguration(CouchDbConfiguration couchDbConfiguration) {
        this.couchDbConfiguration = couchDbConfiguration;
    }
}
