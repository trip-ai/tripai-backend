package uz.gilt.sunkar.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "article")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Service extends BaseEntity {
    private String name;
    private BigDecimal price;
    private String description;
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> instructions;
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> preparations;
    private String result;
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> locations;
    private boolean status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;
}
