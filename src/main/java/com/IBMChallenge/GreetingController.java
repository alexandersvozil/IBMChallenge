package com.IBMChallenge;

import com.socrata.api.Soda2Consumer;
import com.socrata.builders.SoqlQueryBuilder;
import com.socrata.exceptions.LongRunningQueryException;
import com.socrata.exceptions.SodaError;
import com.socrata.model.soql.SoqlQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by alex on 25.10.2016.
 */
@RestController
public class GreetingController {
    Soda2Consumer consumer = Soda2Consumer.newConsumer("https://data.sfgov.org");
    SoqlQuery  soqlQuery = new SoqlQueryBuilder()
            .addSelectPhrase("title")
            .addSelectPhrase("locations")
            .setLimit(5000)
            .build();

    @RequestMapping("/challenge")
    public List<Film> greeting(@RequestParam(value="name", defaultValue = "World") String name) throws LongRunningQueryException, SodaError, InterruptedException {

        List<Film> response = consumer.query("yitu-d5am", soqlQuery, Film.LIST_TYPE);
        //System.out.println(response.size()+ " rows!");


        return response;
    }
}
