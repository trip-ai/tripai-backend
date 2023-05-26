package uz.tripai.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "place")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Place extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    private String name;
    private String address;
    private String description;
    private List<String> images;
}
