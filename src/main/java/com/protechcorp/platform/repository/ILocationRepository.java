package com.protechcorp.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.protechcorp.platform.model.Location;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Long> {

}
