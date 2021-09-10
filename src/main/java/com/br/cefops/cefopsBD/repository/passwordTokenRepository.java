package com.br.cefops.cefopsBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cefops.cefopsBD.domain.User;
import com.br.cefops.cefopsBD.domain.Model.PasswordResetToken;

public interface passwordTokenRepository extends JpaRepository<PasswordResetToken, Long> {

}
