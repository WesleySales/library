package com.project.library.repositories;


import com.project.library.entities.LB_Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LB_RentRepository extends JpaRepository<LB_Rent, Long> {
}
