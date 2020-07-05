package by.micro.telebookmicro.controller;

import by.micro.telebookmicro.domain.City;
import by.micro.telebookmicro.service.DTO.CityDTO;
import by.micro.telebookmicro.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/city")
@AllArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CityDTO city) {
        if (cityService.create(city)) {
            return new ResponseEntity<>("Created "+city.getCity(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @GetMapping(path = "findAll")
    private ResponseEntity<List<City>> findAll() {
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping(path = "findCity/byId/{id}")
    public ResponseEntity<City> findCityById(@PathVariable Long id) {
        City city = cityService.findCityById(id);
        if (city != null) {
            return new ResponseEntity<>(city, HttpStatus.FOUND);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "findCity/byTitle/{city}")
    public ResponseEntity<City> findCityByTitle(@PathVariable String city) {
        City cityByTitle = cityService.findCityByTitle(city);
        if (cityByTitle != null) {
            return new ResponseEntity<>(cityByTitle, HttpStatus.FOUND);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "deleteCityById/{id}")
    public ResponseEntity<String> deleteCityById(@PathVariable Long id) {
        if (cityService.deleteCityById(id)) {
            return new ResponseEntity<>("City with ID " + id + " deleted."
                    , HttpStatus.OK);
        } else return new ResponseEntity<>("City with ID " + id + " not found.", HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "updateCityTitleById/{id}")
    public ResponseEntity<City> updateCityTitleById(@RequestParam String city, @PathVariable Long id) {
        City city1 = cityService.updateCityTitleById(city, id);
        if (city1 != null) {
            return new ResponseEntity<>(city1, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
