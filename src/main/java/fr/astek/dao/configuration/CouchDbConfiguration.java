package fr.thalaf.athena.eadmin.ground.dao.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Database configuration. TODO ODU Externaliser dans un projet à part.
 *
 * @author Astek
 */
@Configuration
@ConfigurationProperties(prefix = "db")
public class CouchDbConfiguration {

    /**
     * Couchdb host name with default value
     */
    private String host = "localhost";
    /**
     * Couchdb port
     */
    private String port = "5984";
    /**
     * Couchdb data base name
     */
    private String databaseName = "eadmin";

    /**
     * Couchdb data base name.<br/>
     * TODO ODU Use Optional (JDK8) -> Impact DbManager. Théoriquement, Spring Inject gère bien les Optional. TODO ODU. Devrait marcher a null mais sur nos
     * machines local ne fonctionne pas.
     */
    private String username = "couchdb";

    /**
     * Couchdb data base name.<br/>
     * TODO ODU Use Optional (JDK8) -> Impact DbManager. Théoriquement, Spring Inject gère bien les Optional. TODO ODU. Devrait marcher a null mais sur nos
     * machines local ne fonctionne pas.
     */
    private String password = "8o#pq-CKMx";

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @return the databaseName
     */
    public String getDatabaseName() {
        return databaseName;
    }

    /**
     * @param databaseName the databaseName to set
     */
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
