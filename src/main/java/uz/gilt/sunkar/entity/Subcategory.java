package uz.gilt.sunkar.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subcategory")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subcategory extends BaseEntity {
    private String name;
    private boolean status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
}
