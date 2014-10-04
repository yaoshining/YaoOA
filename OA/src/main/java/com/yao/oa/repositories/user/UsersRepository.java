package com.yao.oa.repositories.user;

import com.yao.oa.domains.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 世宁 on 2014/10/4 0004.
 */
@Repository
public interface UsersRepository extends JpaRepository<Users,String> {
}
