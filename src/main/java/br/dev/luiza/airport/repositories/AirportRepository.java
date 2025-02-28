package br.dev.luiza.airport.repositories;

import br.dev.luiza.airport.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sesidevb
 */
public interface AirportRepository extends JpaRepository<Airport, Long> {
    
}
