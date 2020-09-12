package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ecommerce.api.User;
@Service
@Repository
public interface UserLoginRepository extends JpaRepository<User, Long> {
}
