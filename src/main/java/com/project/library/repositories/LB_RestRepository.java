package com.project.library.repositories;


import com.project.library.entities.LB_Rest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LB_RestRepository extends JpaRepository<LB_Rest, Long> {
}
