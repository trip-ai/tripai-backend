package uz.gilt.sunkar.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "banner")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Banner extends BaseEntity {
    @Column(name = "image_url")
    private String imageUrl;
    private boolean status;
}
