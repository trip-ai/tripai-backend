package uz.tripai.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.tripai.entity.Role;
import uz.tripai.entity.enumerate.ERole;
import uz.tripai.repository.RoleRepository;
import uz.tripai.service.RoleService;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;


    @Override
    public Role getRole(ERole role) {
        return repository.findByName(role)
                .orElseGet(() -> repository.save(Role.builder().name(role).build()));
    }
}
