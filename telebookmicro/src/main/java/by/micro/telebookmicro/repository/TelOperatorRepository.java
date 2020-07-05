package by.micro.telebookmicro.repository;

import by.micro.telebookmicro.domain.TelOperator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface TelOperatorRepository extends JpaRepository<TelOperator, Long> {
    Optional<TelOperator> findTelOperatorByOperator(String operator);
}
