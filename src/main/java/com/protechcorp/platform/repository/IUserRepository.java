package com.protechcorp.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.protechcorp.platform.model.Users;

@Repository
public interface IUserRepository extends JpaRepository<Users, Long> {
	public Users findByUsername(String username);
}