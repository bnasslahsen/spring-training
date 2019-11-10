package com.bnpparibas.dojo.user.userapp.dao;

import com.bnpparibas.dojo.user.userapp.domaine.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {



	
}
