package com.project.library.repositories;

import com.project.library.entities.LB_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<LB_User, Long> {
}
