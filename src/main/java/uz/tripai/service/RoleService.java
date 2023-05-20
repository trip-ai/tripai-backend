package uz.tripai.service;

import uz.tripai.entity.Role;
import uz.tripai.entity.enumerate.ERole;

public interface RoleService {
    Role getRole(ERole role);
}
