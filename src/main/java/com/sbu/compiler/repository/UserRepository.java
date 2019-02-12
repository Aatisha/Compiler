package com.sbu.compiler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbu.compiler.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
