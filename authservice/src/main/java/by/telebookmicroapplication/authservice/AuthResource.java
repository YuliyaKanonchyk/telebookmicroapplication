package by.telebookmicroapplication.authservice;

import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.UUID;

public interface AuthResource {

    ResponseEntity<String> checkIsAuth(String uuid);
    ResponseEntity<Optional<UUID>> authUser (UserDTOAuth userDTOAuth);
}
