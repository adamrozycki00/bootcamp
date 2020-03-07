package pl.sda.Bootcamp.rest;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.sda.Bootcamp.model.PeopleList;
import pl.sda.Bootcamp.model.Person;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestApi {

    @GetMapping("/")
    public List<Person> getPeople() {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.add("accept", MediaType.APPLICATION_JSON_VALUE);
//        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<PeopleList> people = rest.exchange(
                "https://swapi.co/api/people",
                HttpMethod.GET,
                entity,
                PeopleList.class);

        return people.getBody().getResults();
    }

}



