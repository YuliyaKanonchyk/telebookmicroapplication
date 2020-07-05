package by.micro.telebookmicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TelebookmicroApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelebookmicroApplication.class, args);
    }

}
