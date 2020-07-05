package by.telebookmicroapplication.authservice;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "authResource")
@AllArgsConstructor
public class AuthResourceConsole implements AuthResource {

    private final Map<UUID, UserDTOAuth> authMap;
    private RestTemplate restTemplate;

    @GetMapping(path = "checkIsAuth")
    @Override
    public ResponseEntity<String> checkIsAuth(@RequestParam String uuid) {
        if (authMap.containsKey(UUID.fromString(uuid))) {
            return new ResponseEntity<>("FOUND",HttpStatus.FOUND);
        }
        return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "auth")
    @Override
    public ResponseEntity<Optional<UUID>> authUser(@RequestBody UserDTOAuth userDTOAuth) {
        ResponseEntity<UserDTOAuth> user = restTemplate.getForEntity(Constants.USER_8082 + "login?login={login}&password={password}", UserDTOAuth.class, userDTOAuth.getLogin(), userDTOAuth.getPassword());
        if (user.getBody() != null && !authMap.containsValue(userDTOAuth)) {
                UUID uuid = UUID.randomUUID();
                authMap.put(uuid, userDTOAuth);
                return new ResponseEntity<>(Optional.of(uuid), HttpStatus.OK);
        }
        return new ResponseEntity<>(Optional.empty(),HttpStatus.BAD_REQUEST);
    }
}