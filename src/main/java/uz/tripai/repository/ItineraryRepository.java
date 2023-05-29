package uz.tripai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.tripai.entity.Itinerary;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {
}
