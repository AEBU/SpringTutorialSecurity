package securityinmemory.restService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import securityinmemory.model.Canton;
import securityinmemory.repository.CantonRepository;

import java.util.List;

/**
 * Created by Alexis on 07/04/2017.
 */
@RestController
@RequestMapping(value = "/cnt")
public class RestCanton {

    @Autowired
    CantonRepository cantonRepository;


    @RequestMapping(value = "/canton/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Canton> getOrden(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        Canton ordens= cantonRepository.findByCntId(id);
        if (ordens==null) {
            return new ResponseEntity<Canton>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Canton>(ordens, HttpStatus.OK);
    }

}
