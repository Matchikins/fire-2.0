package com.br.cefops.cefopsBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cefops.cefopsBD.domain.Posts;

public interface PostRepository extends JpaRepository<Posts,Integer>{

}
