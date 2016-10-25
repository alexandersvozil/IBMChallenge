package IBMChallenge.Model;

import com.sun.jersey.api.client.GenericType;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Created by alex on 25.10.2016.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class Film {
    public static final GenericType<List<Film>> LIST_TYPE = new GenericType<List<Film>>() {};
    private final String title;
    private final String locations;

    @JsonCreator
    public Film(@JsonProperty("title") String title,@JsonProperty("locations") String locations){
        this.title = title;
        this.locations = locations;
    }

    public String getTitle(){
        return this.title;
    }
    public String getLocation(){
        return this.locations;
    }

}
