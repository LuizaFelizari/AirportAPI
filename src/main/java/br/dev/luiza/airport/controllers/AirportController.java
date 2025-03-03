package br.dev.luiza.airport.controllers;

import br.dev.luiza.airport.DTO.AirportMinDTO;
import br.dev.luiza.airport.entities.Airport;
import br.dev.luiza.airport.services.AirportServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirportController {
    
    @Autowired
    private AirportServices airportServices;
    
    @GetMapping("/airport")
    public List<Airport> findAll() {
        List<Airport> result = airportServices.findAll();
        return result;
    }
            
    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<Airport>> findByCityIgnoreCase(@PathVariable String cityName) {
        List<Airport> result = airportServices.findByCity(cityName);
        
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
            
        }else{
            return ResponseEntity.ok(result);
        }
    }
    
    @GetMapping("/country/{countryName}")
    public ResponseEntity<List<AirportMinDTO>> findByCountryIgnoreCase(@PathVariable String countryName){
        
        List<AirportMinDTO> result = airportServices.findByCountry(countryName);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
             
        }else{
            return ResponseEntity.ok(result);
        }
    }
    
    @GetMapping("/iatacode/{iataCode}")
    public ResponseEntity<Airport> findByIataCode(@PathVariable String iataCode){
        Airport result = airportServices.findByIataCode(iataCode);
        
        if (result == null) {
            return ResponseEntity.notFound().build();
          
        } else {
            return ResponseEntity.ok(result);
        }
    }
    
}
