package IBMChallenge.Service;

import IBMChallenge.Model.Film;
import com.socrata.api.Soda2Consumer;
import com.socrata.builders.SoqlQueryBuilder;
import com.socrata.exceptions.SodaError;
import com.socrata.model.soql.SoqlQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex on 25.10.2016.
 */

public class SodaService {
    private Soda2Consumer consumer = Soda2Consumer.newConsumer("https://data.sfgov.org");

    public List<Film> query() throws SodaError, InterruptedException {
        SoqlQuery soqlQuery = new SoqlQueryBuilder().addSelectPhrase("title")
                .addSelectPhrase("locations")
                .setLimit(5000)
                .build();
        List<Film> result = consumer.query("yitu-d5am",soqlQuery, Film.LIST_TYPE);
        return result;
    }
    public List<Film> query(String title) throws SodaError, InterruptedException {

        SoqlQuery soqlQuery = new SoqlQueryBuilder().addSelectPhrase("title")
                .addSelectPhrase("locations")
                .setWhereClause("title='"+title+"'")
                .setLimit(5000)
                .build();

        List<Film> result = consumer.query("yitu-d5am",soqlQuery, Film.LIST_TYPE);
        return result;
    }

}
