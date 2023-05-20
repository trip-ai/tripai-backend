package uz.tripai.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;
import uz.tripai.entity.enumerate.ERole;


@Entity
@Table(name = "`role`")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private ERole name;
}
