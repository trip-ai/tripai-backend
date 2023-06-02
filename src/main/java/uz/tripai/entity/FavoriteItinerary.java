package uz.tripai.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "favorite_itinerary")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteItinerary extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "itinerary_id")
    private Itinerary itinerary;
    private boolean status;
}
