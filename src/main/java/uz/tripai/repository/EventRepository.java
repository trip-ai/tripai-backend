package uz.tripai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.tripai.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
