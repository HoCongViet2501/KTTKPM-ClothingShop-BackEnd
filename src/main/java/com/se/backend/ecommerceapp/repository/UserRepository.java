package com.se.backend.ecommerceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.se.backend.ecommerceapp.model.entity.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>{

}
