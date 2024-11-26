package com.example.amitlal.mvcProj.repository;

 import org.springframework.data.jpa.repository.JpaRepository;

import com.example.amitlal.mvcProj.entity.Movies;

public interface crudRepository extends JpaRepository<Movies,Integer> {

}
