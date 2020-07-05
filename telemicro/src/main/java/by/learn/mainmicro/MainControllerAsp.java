package by.learn.mainmicro;

import by.learn.mainmicro.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "api/v1")
@AllArgsConstructor
public class MainControllerAsp {
    private RestTemplate restTemplate;

    @PostMapping(path = "createAbonent")
    public ResponseEntity<String> createAbonent(@RequestHeader("api_key") String key
            , @RequestHeader("role") String role
            , @RequestBody AbonentDTOMain abonent) {
        return restTemplate.postForEntity(Constants.ABONENT_8081, abonent, String.class);
    }

    @PostMapping(path = "createCity")
    public ResponseEntity<String> createCity(@RequestHeader("api_key") String key,
                                             @RequestHeader("role") String role,
                                             @RequestBody CityDTOMain cityDTOMain) {
            return restTemplate.postForEntity(Constants.CITY_8081, cityDTOMain, String.class);
    }


//    @GetMapping(path = "auth")
//    public ResponseEntity<UUID> auth(@RequestHeader() String role
//            , String login
//            , String password) {
//        ResponseEntity<UserDTOMain> user = restTemplate.getForEntity(Constants.USER_8082 + "login?login={login}&password={password}", UserDTOMain.class, login, password);
//        if (user.getBody() != null) {
//            UUID uuid = UUID.randomUUID();
//            authMap.put(uuid, user.getBody());
//            return new ResponseEntity<>(uuid, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }

    @PostMapping(path = "createOperator")
    public ResponseEntity<String> createOperator(@RequestHeader() String role
            , @RequestHeader("api_key") String key
            , @RequestBody TelOperatorDTOMain telOperatorDTOMain) {
        return restTemplate.postForEntity(Constants.TELOPERATOR_8081, telOperatorDTOMain, String.class);
    }

    @PostMapping(path = "deleteOperator/{title}")
    public void deleteOperator(@RequestHeader("api_key") String key, @RequestHeader String role, @RequestParam Long id) {

        restTemplate.delete(Constants.TELOPERATOR_8081 + "/deleteTelOperatorById/{id}", id, String.class);
    }

    @PostMapping(path = "createNumber")
    public ResponseEntity<String> createNumber(@RequestHeader("api_key") String key
            , @RequestHeader String role
            , @RequestBody NumberDTOMain numberDTOMain) {
        return restTemplate.postForEntity(Constants.TELNUM_8081, numberDTOMain, String.class);
    }

    @PostMapping(path = "create/teleBook")
    public ResponseEntity<String> create(@RequestHeader("api_key") String key
            , @RequestHeader String role
            , @RequestBody CityDTOMain cityDTOMain) {
        return restTemplate.postForEntity(Constants.TELEBOOK_8081, cityDTOMain, String.class);
    }
}
