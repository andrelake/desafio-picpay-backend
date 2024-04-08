package com.andrelake.desafiopicpaybackend.repositories;

import com.andrelake.desafiopicpaybackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
