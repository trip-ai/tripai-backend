package uz.tripai.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tag")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tag extends BaseEntity {
    private String name;
}
