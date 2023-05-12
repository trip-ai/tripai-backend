package uz.tripai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.tripai.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
