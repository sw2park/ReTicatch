package com.danaojo.reticatch.mypage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.danaojo.reticatch.entity.Users;

import jakarta.transaction.Transactional;

public interface UsersRepository extends JpaRepository<Users, Long> {
	@Query(value = "SELECT seq_user_id FROM users u WHERE user_name = :user_name", nativeQuery = true)
	Long findByUser_Name(@Param("user_name") String user_name);

	@Query(value = "SELECT * FROM users u WHERE seq_user_id = :userSeq", nativeQuery = true)
	Users searchUserData(@Param("userSeq") Long userSeq);

	@Transactional
	@Modifying
	@Query(value = "UPDATE users SET user_id = :userId, user_pw = :userPW, user_phone = :userPhone, user_name = :userName, user_email = :userEmail, u_update_date = :updateDate WHERE seq_user_id = :seq_user_id", nativeQuery = true)
	void updateUserDB(@Param("seq_user_id") Long seq_user_id, @Param("userId") String userId,
			@Param("userPW") String userPW, @Param("userPhone") String userPhone, @Param("userName") String userName,
			@Param("userEmail") String userEmail, @Param("updateDate") String updateDate);
}