package uz.tripai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.tripai.entity.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
}
