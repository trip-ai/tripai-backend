package uz.tripai.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "event")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event extends BaseEntity {
    private String title;
    private String description;
    private String content;
    private boolean status;
}
