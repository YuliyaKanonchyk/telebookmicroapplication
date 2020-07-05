package by.micro.telebookmicro.repository;

import by.micro.telebookmicro.domain.City;
import by.micro.telebookmicro.domain.TeleBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface TeleBookRepository extends JpaRepository<TeleBook, Long> {
    Optional<TeleBook> findTeleBookByCityCity(String city);
}
