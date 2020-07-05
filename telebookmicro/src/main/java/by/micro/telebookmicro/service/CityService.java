package by.micro.telebookmicro.service;

import by.micro.telebookmicro.domain.City;
import by.micro.telebookmicro.repository.CityRepository;
import by.micro.telebookmicro.service.DTO.CityDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityService {

    private CityRepository cityRepository;

    public boolean create(CityDTO city) {
        Optional<City> cityByCity = cityRepository.findCityByCity(city.getCity());
        if (cityByCity.isPresent()) {
            return false;
        }
        City city1 = new City();
        city1.setCity(city.getCity());
        cityRepository.save(city1);
        return true;
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public City findCityById(Long id) {
        final Optional<City> cityById = cityRepository.findById(id);
        return cityById.orElse(null);
    }

    public City findCityByTitle(String city) {
        Optional<City> cityByCity = cityRepository.findCityByCity(city);
        return cityByCity.orElse(null);
    }

    public Boolean deleteCityById(Long id) {
        Optional<City> city1 = cityRepository.findById(id);
        if (city1.isPresent()) {
            cityRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public City updateCityTitleById(String city, Long id) {
        Optional<City> city1 = cityRepository.findById(id);
        if (city1.isPresent()) {
            city1.get().setCity(city);
            return city1.get();
        }
        return null;
    }
}

