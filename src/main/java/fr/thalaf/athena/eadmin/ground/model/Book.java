package fr.thalaf.athena.eadmin.ground.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.ektorp.support.CouchDbDocument;

/**
 * Model Exemple.<br/>
 * TODO ODU Supprimer cette classe dès que le concept est compris.
 *
 * @author odupre
 * @version $Id: $
 */
@JsonIgnoreProperties
public class Book extends CouchDbDocument {

    private final String id;
    private final String name;
    private final int size;
    private final int version;

    public Book(String id, String name, int size, int version) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.version = version;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getVersion() {
        return version;
    }

    /**
     * redefine equals
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        Book other = (Book) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    /**
     * redefine hashcode
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
