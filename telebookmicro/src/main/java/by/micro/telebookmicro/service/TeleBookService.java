package by.micro.telebookmicro.service;

import by.micro.telebookmicro.domain.TeleBook;
import by.micro.telebookmicro.repository.TeleBookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeleBookService {
    private TeleBookRepository teleBookRepository;

    public Optional<TeleBook> findTeleBookByCity(String city) {
        return teleBookRepository.findTeleBookByCityCity(city);
    }

    public List<TeleBook> findAll() {
        return teleBookRepository.findAll();
    }

    public Optional<TeleBook> findTeleBookById(Long id) {
        return teleBookRepository.findById(id);
    }

    public void deleteTeleBookById(Long id) {
        teleBookRepository.deleteById(id);
    }
}
