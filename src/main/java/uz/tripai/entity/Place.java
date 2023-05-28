package uz.tripai.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "place")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Place extends BaseEntity {

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Location {
        Double longitude;
        Double latitude;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Workday {
        int dayOfWeek;
        LocalTime from;
        LocalTime to;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
    private String name;
    private String address;
    private String description;
    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<String> images;
    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private Location location;
    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<Workday> workdays;
    private boolean status;
    private double rating;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "place_tag",
            joinColumns = @JoinColumn(name = "place_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;
}
