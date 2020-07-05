package by.micro.telebookmicro.controller;

import by.micro.telebookmicro.domain.Abonent;
import by.micro.telebookmicro.domain.TelNum;
import by.micro.telebookmicro.repository.AbonentRepository;
import by.micro.telebookmicro.repository.TelNumRepository;
import by.micro.telebookmicro.service.AbonentService;
import by.micro.telebookmicro.service.DTO.AbonentDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/abonent")
@Validated
@AllArgsConstructor
public class AbonentController {

    private AbonentRepository abonentRepository;
    private AbonentService abonentService;
    private TelNumRepository telNumRepository;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody AbonentDTO abonent) {
        if (abonentRepository.existsAbonentByNameAndSurName(abonent.getName(), abonent.getSurName())) {
            return new ResponseEntity<>("Abonent with name " + abonent.getName() + " and surName"
                    + abonent.getSurName() + " already exists.", HttpStatus.IM_USED);
        }
        abonentService.create(abonent);
        return new ResponseEntity<>("Abonent with name " + abonent.getName() + " and surName"
                + abonent.getSurName() + " successfully registered.", HttpStatus.CREATED);
    }

    @GetMapping(path = "findAll")
    public ResponseEntity<List<Abonent>> findAll() {
        return new ResponseEntity<>(abonentService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping(path = "findAbonent/byNameAndSurName/{name}/{surName}")
    public ResponseEntity<Abonent> findAbonentByNameAndSurName(@PathVariable String name,
                                                               @PathVariable String surName) {
        Optional<Abonent> abonentByNameAndSurName = abonentRepository.findAbonentByNameAndSurName(name, surName);
        return abonentByNameAndSurName.map(abonent -> new ResponseEntity<>(abonent, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "findAbonent/byId/{id}")
    public ResponseEntity<Abonent> findAbonentById(@PathVariable Long id) {
        Optional<Abonent> abonentById = abonentRepository.findById(id);
        return abonentById.map(abonent -> new ResponseEntity<>(abonent, HttpStatus.FOUND)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "delete/byId/{id}")
    public ResponseEntity<String> deleteAbonentById(@PathVariable Long id) {
        Optional<Abonent> abonentById = abonentRepository.findById(id);
        if (abonentById.isPresent()) {
            abonentRepository.deleteById(id);
            return new ResponseEntity<>("Abonent with Id " + id + " successfully deleted.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Abonent with Id " + id + " not found.", HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "delete/ByNameAndSurName/{name}/{surName}")
    public ResponseEntity<String> deleteAbonentById(@PathVariable String name,
                                                    @PathVariable String surName) {
        Optional<Abonent> abonentByNameAndSurName = abonentRepository.findAbonentByNameAndSurName(name, surName);
        if (abonentByNameAndSurName.isPresent()) {
            abonentRepository.deleteById(abonentByNameAndSurName.get().getId());
            return new ResponseEntity<>("Abonent with Name " + name + " and Surname " + surName + " successfully deleted.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Abonent with Name " + name + " and Surname " + surName + " not found.", HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "updateAbonentById/name/{id}")
    public ResponseEntity<String> updateAbonentNameById(@PathVariable Long id, @RequestParam String newName) {
        Optional<Abonent> byId = abonentRepository.findById(id);
        if (byId.isPresent()) {
            byId.get().setName(newName);
            abonentRepository.save(byId.get());
            return new ResponseEntity<>("Abonent's Name with Id " + id + " successfully updated to " + newName, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "updateAbonentById/surName/{id}")
    public ResponseEntity<String> updateAbonentSurNameById(@PathVariable Long id, @RequestParam String newSurName) {
        Optional<Abonent> byId = abonentRepository.findById(id);
        if (byId.isPresent()) {
            byId.get().setSurName(newSurName);
            abonentRepository.save(byId.get());
            return new ResponseEntity<>("Abonent's SurName with Id " + id + " successfully updated to " + newSurName, HttpStatus.OK);
        }
        return new ResponseEntity<>("Abonent with Id " + id + " not found.", HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "updateAbonentById/teleBook/{id}")
    public ResponseEntity<String> updateAbonentTeleBookByAbonentId(@PathVariable Long id, @Valid @RequestParam String city) {
        Abonent abonent = abonentService.updateAbonentTeleBookByAbonentId(id, city);
        if (abonent != null) {
            return new ResponseEntity<>("Abonent's TeleBook with Id " + id + " successfully updated to " + abonent.getTeleBook(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Abonent with Id " + id + " not found.", HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "/updateAbonentById/number/{id}")
    public ResponseEntity<String> updateAbonentNumberById(@PathVariable("id") Long id , @RequestBody TelNum telNum) {
        abonentService.addTelNum(id, telNum);
        return new ResponseEntity<>("Abonent's number list with Id " + telNum.getId()+ "successfully updated.", HttpStatus.OK);
    }

}
