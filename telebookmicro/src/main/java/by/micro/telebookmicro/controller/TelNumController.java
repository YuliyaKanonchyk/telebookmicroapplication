package by.micro.telebookmicro.controller;

import by.micro.telebookmicro.domain.Abonent;
import by.micro.telebookmicro.domain.ListWrapper;
import by.micro.telebookmicro.domain.TelNum;
import by.micro.telebookmicro.repository.TelNumRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/telNum")
@Validated
public class TelNumController {
    private TelNumRepository telNumRepository;

    public TelNumController(TelNumRepository telNumRepository) {
        this.telNumRepository = telNumRepository;
    }

    @PostMapping
    public ResponseEntity<TelNum> create(@Valid @RequestBody TelNum telNum) {
        System.out.println(telNum);
        Optional<TelNum> byTelNum = telNumRepository.findByTelNum(telNum.getTelNum());
        if (!byTelNum.isPresent()) {
            return new ResponseEntity<>(telNumRepository.save(telNum), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.IM_USED);
    }

    @GetMapping(path = "findAll")
    public ResponseEntity<List<TelNum>> findAll() {

        List<TelNum> numList = telNumRepository.findAll();
        return new ResponseEntity<>(numList, HttpStatus.FOUND);
    }

    @GetMapping(path = "findTelNumByTelNum/{telNum}")
    public ResponseEntity<TelNum> findTelNumByTelNum(@PathVariable String telNum) {
        Optional<TelNum> byTelNum = telNumRepository.findByTelNum(telNum);
        return byTelNum.map(num -> new ResponseEntity<>(num, HttpStatus.FOUND)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "findTelNumById/{id}")
    public ResponseEntity<TelNum> findTelNumById(@PathVariable Long id) {
        Optional<TelNum> byId = telNumRepository.findById(id);
        return byId.map(telNum -> new ResponseEntity<>(telNum, HttpStatus.FOUND)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "deleteTelNumById/{id}")
    public ResponseEntity<String> deleteTelNumById(@PathVariable Long id) {
        Optional<TelNum> byId = telNumRepository.findById(id);
        if (byId.isPresent()) {
            telNumRepository.deleteById(id);
            return new ResponseEntity<>(byId.get().getTelNum() + " Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Number with ID-" + id + " not found.", HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "findTelNumByAbonentId/{id}")
    public ResponseEntity<List<TelNum>> findTelNumByAbonentId (@PathVariable Long id){
        Optional<List<TelNum>> telNumsByAbonent_id = telNumRepository.findTelNumsByAbonent_Id(id);
        return telNumsByAbonent_id.map(telNums -> new ResponseEntity<>(telNums, HttpStatus.FOUND)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "findTelNumByTelOperatorId/{id}")
    public ResponseEntity<List<TelNum>> findTelNumByTelOperatorId (@PathVariable Long id){
        Optional<List<TelNum>> telNumsByTelOperatorId = telNumRepository.findTelNumsByTelOperatorId(id);
        return telNumsByTelOperatorId.map(telNums -> new ResponseEntity<>(telNums, HttpStatus.FOUND)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
