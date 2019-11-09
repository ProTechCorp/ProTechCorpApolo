package com.protechcorp.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.protechcorp.platform.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	public Users findByUsername(String username);
}
