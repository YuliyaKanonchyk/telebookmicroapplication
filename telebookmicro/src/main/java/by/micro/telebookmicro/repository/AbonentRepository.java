package by.micro.telebookmicro.repository;

import by.micro.telebookmicro.domain.Abonent;
import by.micro.telebookmicro.domain.TelNum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface AbonentRepository extends JpaRepository<Abonent, Long> {
    Optional<Abonent> findAbonentByNameAndSurName(String name, String surName);
    Boolean existsAbonentByNameAndSurName(String name, String surName);
}
