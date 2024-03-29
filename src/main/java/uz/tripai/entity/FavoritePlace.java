package uz.tripai.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "favorite_place")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavoritePlace extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "place_id")
    private Place place;
    private boolean status;
}
