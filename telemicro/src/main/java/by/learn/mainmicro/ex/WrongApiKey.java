package by.learn.mainmicro.ex;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.ACCEPTED)
public class WrongApiKey extends RuntimeException {
    public WrongApiKey(String key) {
        System.out.println("Wrong key" + key);
    }
}
