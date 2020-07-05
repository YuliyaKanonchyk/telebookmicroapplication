package by.learn.mainmicro;

import by.learn.mainmicro.dto.UserDTOMain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Configuration
@SpringBootApplication
public class MainmicroApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainmicroApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Map<UUID, UserDTOMain> authMap(){
        return new HashMap<>();
    }

}
