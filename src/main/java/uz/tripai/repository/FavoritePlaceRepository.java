package uz.tripai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.tripai.entity.FavoritePlace;

@Repository
public interface FavoritePlaceRepository extends JpaRepository<FavoritePlace, Long> {
}
