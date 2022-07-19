package com.hanye.info.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hanye.info.model.mysql.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
