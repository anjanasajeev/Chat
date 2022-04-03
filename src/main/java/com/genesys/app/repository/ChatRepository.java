package com.genesys.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.genesys.app.model.PSVChatMessage;

@Repository
public interface ChatRepository extends JpaRepository<PSVChatMessage, Integer> {

	@Query("SELECT content FROM messages m WHERE m.employeeID =:senderId OR m.employeeID =:recipientId")
	List<String> findChatConversation(@Param("senderId")String senderId, @Param("recipientId") String recipientId);
	
	@Query("SELECT employeeID, sender FROM messages m WHERE m.employeeID =:emp_id")
	String getUser(@Param("emp_id")String emp_id);
	
	@Query("SELECT distinct employeeID, sender FROM messages")
	List<String> togetAllUsers();
	
	
	
	

}
