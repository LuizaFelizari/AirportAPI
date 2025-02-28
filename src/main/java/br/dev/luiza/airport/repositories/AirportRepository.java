package br.dev.luiza.airport.repositories;

import br.dev.luiza.airport.entities.Airport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AirportRepository extends JpaRepository<Airport, Long> {
    
    List<Airport> findByCityIgnoreCase(String city);
}
