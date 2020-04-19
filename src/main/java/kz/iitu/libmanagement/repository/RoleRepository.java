package kz.iitu.libmanagement.repository;

import kz.iitu.libmanagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}