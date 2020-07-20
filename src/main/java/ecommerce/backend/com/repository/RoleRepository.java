package ecommerce.backend.com.repository;

import ecommerce.backend.com.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
