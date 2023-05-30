package uz.tripai.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Table(name = "feedback")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Feedback extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "place_id")
    private Place place;
    private double rating;
    private String comment;
    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<String> images;
}
