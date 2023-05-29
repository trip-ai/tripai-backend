package uz.tripai.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "itinerary")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Itinerary extends BaseEntity {
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "is_public")
    private boolean isPublic;
    private boolean status;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "itinerary_place",
            joinColumns = @JoinColumn(name = "itinerary_id"),
            inverseJoinColumns = @JoinColumn(name = "place_id"))
    private Set<Place> places;
}
