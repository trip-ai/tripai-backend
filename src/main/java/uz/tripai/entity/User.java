package uz.tripai.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.tripai.security.oauth2.EProvider;

import java.util.Set;

@Entity
@Table(name = "`user`")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private EProvider provider;
    @Column(name = "provider_id")
    private String providerId;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
