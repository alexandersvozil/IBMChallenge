package IBMChallenge.Controller;

import IBMChallenge.Model.Film;
import IBMChallenge.Service.SodaService;
import com.socrata.api.Soda2Consumer;
import com.socrata.builders.SoqlQueryBuilder;
import com.socrata.exceptions.LongRunningQueryException;
import com.socrata.exceptions.SodaError;
import com.socrata.model.soql.SoqlQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by alex on 25.10.2016.
 */
@RestController
public class GreetingController {

    @Autowired
    private SodaService ss;

    @RequestMapping(value = "/challenge", method= RequestMethod.GET)
    public List<Film> greeting(@RequestParam(value="title", defaultValue = "") String title)
            throws LongRunningQueryException, SodaError, InterruptedException {
        List<Film> response;
        if(title.equals("")) {
            response = ss.query();
        }else{
            response = ss.query(title);
        }



        return response;
    }
}
