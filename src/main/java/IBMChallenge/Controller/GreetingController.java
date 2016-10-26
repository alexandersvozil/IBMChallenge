package IBMChallenge.Controller;

import IBMChallenge.Model.Film;
import IBMChallenge.Service.SodaService;
import com.socrata.exceptions.LongRunningQueryException;
import com.socrata.exceptions.SodaError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by alex on 25.10.2016.
 */
@RestController
public class GreetingController {

    @Autowired
    private SodaService ss;

    @RequestMapping(value = "/challenge", method = RequestMethod.GET)
    public List<Film> challenge()
            throws LongRunningQueryException, SodaError, InterruptedException {
        List<Film> response;
        response = ss.query();
        return response;
    }
    @RequestMapping(value = "/challenge/title", method= RequestMethod.GET)
    public List<Film> challenge_title()
            throws LongRunningQueryException, SodaError, InterruptedException {
        List<Film> response;
        response = ss.query();
        return response;
    }
    @RequestMapping(value = "/challenge/title/{title}", method= RequestMethod.GET)
    public List<Film> challenge_title(@PathVariable String title)
            throws LongRunningQueryException, SodaError, InterruptedException {
        List<Film> response;
        response = ss.query(title);
        return response;
    }
}
