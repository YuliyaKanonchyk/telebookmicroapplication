package by.micro.telebookmicro.service;

import by.micro.telebookmicro.domain.Abonent;
import by.micro.telebookmicro.domain.TelNum;
import by.micro.telebookmicro.domain.TeleBook;
import by.micro.telebookmicro.repository.AbonentRepository;
import by.micro.telebookmicro.repository.TelNumRepository;
import by.micro.telebookmicro.repository.TeleBookRepository;
import by.micro.telebookmicro.service.DTO.AbonentDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AbonentService {
    private AbonentRepository abonentRepository;
    private TeleBookRepository teleBookRepository;
    private TelNumRepository telNumRepository;

    public Abonent create (AbonentDTO abonent){
        Abonent abonent1 = new Abonent();
        abonent1.setTeleBook(new TeleBook(abonent.getTelebookId(), null, null));
        abonent1.setName(abonent.getName());
        abonent1.setSurName(abonent.getSurName());
        return abonentRepository.save(abonent1);
    }

    public Abonent updateAbonentTeleBookByAbonentId(Long id, String city) {
        Optional<TeleBook> teleBookByCityCity = teleBookRepository.findTeleBookByCityCity(city);
        Optional<Abonent> byId = abonentRepository.findById(id);
        if (byId.isPresent() && teleBookByCityCity.isPresent()) {
            Abonent abonent = byId.get();
            abonent.setTeleBook(teleBookByCityCity.get());
            return abonentRepository.save(abonent);
        }
        return null;
    }

    public TelNum addTelNum(Long id, TelNum telNum){
        Abonent abonent = new Abonent();
        abonent.setId(id);

        telNum.setAbonent(abonent);
        return telNumRepository.save(telNum);
    }

    public List<Abonent> findAll() {
        return abonentRepository.findAll();
    }
}
