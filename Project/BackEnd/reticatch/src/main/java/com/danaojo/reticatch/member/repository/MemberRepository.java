package com.danaojo.reticatch.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.danaojo.reticatch.entity.Users;
import com.danaojo.reticatch.member.dto.AddMemberDTO;

import jakarta.transaction.Transactional;

public interface MemberRepository extends JpaRepository<Users, Long> {
	@Query(value = "SELECT * FROM users u WHERE user_id = :user_id", nativeQuery = true)
	Optional<Users> findByUser_id(@Param("user_id") String user_id);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO USERS u (SEQ_USER_ID , LOGIN_TYPE, U_CREATE_DATE, U_UPDATE_DATE, USER_EMAIL, USER_NAME, USER_PHONE, USER_PW, USER_ID) VALUES (SEQ_USERS_ID.nextVAL, :loginType, :createDate, :updateDate, :userEmail, :userName, :userPhone, :loginPW, :loginId)", nativeQuery = true)
	void addUserData(@Param("loginId") String loginId, 
			@Param("loginPW") String loginPW, 
			@Param("userName") String userName, 
			@Param("userPhone") String userPhone, 
			@Param("userEmail") String userEmail,
			@Param("loginType") String loginType, 
			@Param("createDate") String createDate, 
			@Param("updateDate") String updateDate);

}