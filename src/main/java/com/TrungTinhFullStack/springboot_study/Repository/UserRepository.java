package com.TrungTinhFullStack.springboot_study.Repository;

import com.TrungTinhFullStack.springboot_study.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
