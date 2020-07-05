package by.micro.telebookmicro.controller;

import by.micro.telebookmicro.domain.TelOperator;
import by.micro.telebookmicro.repository.TelOperatorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/telOperator")
@Validated
public class TelOperatorController {

    private TelOperatorRepository telOperatorRepository;

    public TelOperatorController(TelOperatorRepository telOperatorRepository) {
        this.telOperatorRepository = telOperatorRepository;
    }

    @PostMapping
    public ResponseEntity<TelOperator> create(@Valid @RequestBody TelOperator telOperator) {
        Optional<TelOperator> telOperatorByOperator = telOperatorRepository.findTelOperatorByOperator(telOperator.getOperator());
        if (!telOperatorByOperator.isPresent()) {
            return new ResponseEntity<>(telOperatorRepository.save(telOperator), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping(path = "findAll")
    public List<TelOperator> findAll() {
        return telOperatorRepository.findAll();
    }

    @GetMapping(path = "findTelOperator/byId/{id}")
    public ResponseEntity<TelOperator> findTelOperatorById(@PathVariable Long id) {
        final Optional<TelOperator> byId = telOperatorRepository.findById(id);
        return byId.map(telOperator -> new ResponseEntity<>(telOperator, HttpStatus.FOUND)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "findTelOperator/byName/{operator}")
    public ResponseEntity<TelOperator> findTelOperatorByName(@PathVariable String operator) {
        Optional<TelOperator> byName = telOperatorRepository.findTelOperatorByOperator(operator);
        return byName.map(telOperator -> new ResponseEntity<>(telOperator, HttpStatus.FOUND)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "deleteTelOperatorById/{id}")
    public ResponseEntity<String> deleteTelOperatorById(@PathVariable Long id){
        final Optional<TelOperator> byId = telOperatorRepository.findById(id);
        if (byId.isPresent()) {
            telOperatorRepository.delete(byId.get());
            return new ResponseEntity<>("TelOperator with Id "+id+" successfully deleted.", HttpStatus.OK);
        }
        return new ResponseEntity<>("TelOperator with Id "+id+" not found.", HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "updateTelOperatorById/{id}")
    public ResponseEntity<String> updateTelOperatorById(@RequestParam String name, @PathVariable Long id) {
        Optional<TelOperator> byId = telOperatorRepository.findById(id);
        if (byId.isPresent()) {
            byId.get().setOperator(name);
            telOperatorRepository.save(byId.get());
            return new ResponseEntity<>(byId.get() + " Updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("TelOperator with ID-" + id + " not found.", HttpStatus.NOT_FOUND);
    }
}
