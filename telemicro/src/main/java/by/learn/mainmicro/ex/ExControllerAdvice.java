package by.learn.mainmicro.ex;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExControllerAdvice {

    @ExceptionHandler(WrongApiKey.class)
    public ResponseEntity<String> WrongApiKey (WrongApiKey apiKey){
        return new ResponseEntity<>("Wrong api key" +apiKey, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WrongApiKeyOrRole.class)
    public ResponseEntity<String> WrongApiKey (WrongApiKeyOrRole wrongApiKeyOrRole){
        return new ResponseEntity<>("Wrong api-key or User role" +wrongApiKeyOrRole, HttpStatus.BAD_REQUEST);
    }
}
