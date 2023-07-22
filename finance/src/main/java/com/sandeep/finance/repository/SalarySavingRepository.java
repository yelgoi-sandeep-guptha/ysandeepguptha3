package com.sandeep.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandeep.finance.entities.SalarySaving;

@Repository
public interface SalarySavingRepository extends JpaRepository<SalarySaving, Long> {

}
