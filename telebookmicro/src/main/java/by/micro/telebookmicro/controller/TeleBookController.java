package by.micro.telebookmicro.controller;

import by.micro.telebookmicro.domain.TeleBook;
import by.micro.telebookmicro.repository.AbonentRepository;
import by.micro.telebookmicro.repository.TeleBookRepository;
import by.micro.telebookmicro.service.TeleBookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/teleBook")
@Validated
@AllArgsConstructor
public class TeleBookController {
    private TeleBookService teleBookService;

    @PostMapping
    public ResponseEntity<TeleBook> create (@Valid @RequestBody TeleBook teleBook){
        Optional<TeleBook> teleBookByCity = teleBookService.findTeleBookByCity(teleBook.getCity().getCity());
        if (!teleBookByCity.isPresent()) {
            return new ResponseEntity<>(teleBookByCity.get(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.IM_USED);
    }

    @GetMapping(path = "findAll")
    public ResponseEntity<List<TeleBook>> findAll(){
       return new ResponseEntity<>(teleBookService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping(path = "findTeleBookById/{id}")
    public ResponseEntity<TeleBook> findTeleBookById(@PathVariable Long id){
        Optional<TeleBook> teleBookById = teleBookService.findTeleBookById(id);
        return teleBookById.map(teleBook -> new ResponseEntity<>(teleBook, HttpStatus.FOUND)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "deleteTeleBookById/{id}")
    public ResponseEntity<String> deleteTeleBookById(@PathVariable Long id){
        Optional<TeleBook> byId = teleBookService.findTeleBookById(id);
        if (byId.isPresent()) {
            teleBookService.deleteTeleBookById(id);
            return new ResponseEntity<>("TeleBook with Id "+id+" successfully deleted.", HttpStatus.OK);
        }
        return new ResponseEntity<>("TeleBook with Id "+id+" not found.", HttpStatus.NOT_FOUND);
    }
}
