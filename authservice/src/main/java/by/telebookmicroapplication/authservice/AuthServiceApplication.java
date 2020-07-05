package by.telebookmicroapplication.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class AuthServiceApplication {

    @Bean
    public List<UUID> uuidList(){
        return new ArrayList<>();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

}
