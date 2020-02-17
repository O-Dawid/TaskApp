package com.taskapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskapp.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {

}
