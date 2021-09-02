package com.br.cefops.cefopsBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.cefops.cefopsBD.domain.Permission;
import com.br.cefops.cefopsBD.domain.User;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
	@Query("SELECT u FROM Permission u WHERE u.description =:description")
	Permission findByName(@Param("description") String description);

}
