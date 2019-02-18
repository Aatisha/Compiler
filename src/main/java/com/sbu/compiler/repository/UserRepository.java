package com.sbu.compiler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sbu.compiler.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	User findByUserId(String user_id);
	User findByUserIdAndPassword(String user_id, String password);
	List<User>findByDeptAndProfile(String dept,String profile);

}
