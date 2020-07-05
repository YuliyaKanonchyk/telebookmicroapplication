package by.micro.telebookmicro.repository;

import by.micro.telebookmicro.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findCityByCity(String city);
}
