package com.danaojo.reticatch.mypage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.danaojo.reticatch.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	@Query(value = "SELECT seq_user_id FROM users u WHERE user_name = :user_name", nativeQuery = true )
	Long findByUser_Name(String user_name);
}