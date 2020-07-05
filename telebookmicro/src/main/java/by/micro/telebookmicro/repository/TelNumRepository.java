package by.micro.telebookmicro.repository;

import by.micro.telebookmicro.domain.TelNum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface TelNumRepository extends JpaRepository<TelNum, Long> {

    Optional<TelNum> findByTelNum(String telNum);

    Optional<List<TelNum>> findTelNumsByAbonent_Id(Long id);

    Optional<List<TelNum>> findTelNumsByTelOperatorId(Long id);
}
