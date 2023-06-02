package uz.tripai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.tripai.entity.FavoriteItinerary;

@Repository
public interface FavoriteItineraryRepository extends JpaRepository<FavoriteItinerary, Long> {
}
