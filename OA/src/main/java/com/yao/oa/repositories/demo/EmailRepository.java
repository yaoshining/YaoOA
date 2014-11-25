/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yao.oa.repositories.demo;

import com.yao.oa.domains.demo.Email;
import com.yao.oa.domains.user.Users;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yao
 */
@Repository
public interface EmailRepository extends JpaRepository<Email, Integer>{
    @Query("select e from Email e where e.subject like %?1")    //JPQL
    public List<Email> findBySubjectEndsWith(String subject);
    @Query(value = "select * from email where sender_id = ?0",nativeQuery = true)  //SQL
    public List<Email> findBySenderId(Integer senderId);
    @Query("select e from Email e where e.sender = :sender or e.subject like %:subject")
    public Email findBySenderOrSubjectEndsWith(@Param("sender") Users sender,@Param("subject") String subject);
}
