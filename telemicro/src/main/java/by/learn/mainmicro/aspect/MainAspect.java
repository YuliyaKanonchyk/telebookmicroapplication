package by.learn.mainmicro.aspect;

import by.learn.mainmicro.ex.WrongApiKey;
import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Aspect
@Component
@AllArgsConstructor
public class MainAspect {

    @Autowired
    private RestTemplate restTemplate;

    @Before(value = "target(by.learn.mainmicro.MainControllerAsp) && args(key, role, *)")
    public void operator(String key, String role) {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8070/authResource/checkIsAuth?uuid={key}", String.class, key);
        if (forEntity.getStatusCode().is4xxClientError()) System.out.println("no");
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("role", "ADMIN");
//        httpHeaders.add("key", "asdsadjas0as0das-d-asd-sa-d");
//        forEntity.getHeaders().addAll(httpHeaders);

    }

}

