package com.almoxarifado.empetur.almoxarifado.sin.repository;

import com.almoxarifado.empetur.almoxarifado.sin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
