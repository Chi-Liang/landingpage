package com.hanye.info.repository.mysql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hanye.info.model.mysql.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
