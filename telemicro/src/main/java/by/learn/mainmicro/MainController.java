package by.learn.mainmicro;

import by.learn.mainmicro.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(path = "api/v2")
@AllArgsConstructor
public class MainController {

    private RestTemplate restTemplate;

    @GetMapping(path = "findAllCities")
    public ResponseEntity<List<CityDTOMain>> findAllCities() {

            ResponseEntity<CityList> entity = restTemplate.getForEntity(Constants.CITY_8081 + "findAll", CityList.class);
            CityList entityBody = entity.getBody();
            if (entityBody!=null) return ResponseEntity.ok(entityBody.getCityDTOMainList());
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "findAllAbonents")
    public ResponseEntity<List<AbonentDTOMain>> findAllAbonents() {
        ResponseEntity<AbonentList> entity = restTemplate.getForEntity(Constants.ABONENT_8081 + "findAll", AbonentList.class);
        AbonentList body = entity.getBody();
        if (body != null) return ResponseEntity.ok(body.getAbonentDTOMainList());
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping(path = "create/user")
    public ResponseEntity<String> createUser( @RequestBody UserDTOMain userDTOMain) {
        return restTemplate.postForEntity(Constants.USER_8082 + "registration", userDTOMain, String.class);
    }
}
