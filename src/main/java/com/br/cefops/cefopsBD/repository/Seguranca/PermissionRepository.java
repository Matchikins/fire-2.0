package com.br.cefops.cefopsBD.repository.Seguranca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.cefops.cefopsBD.domain.seguranca.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
	@Query("SELECT u FROM Permission u WHERE u.description =:description")
	Permission findByName(@Param("description") String description);

}
