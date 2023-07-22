package com.sandeep.finance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandeep.finance.entities.Finance;

@Repository
public interface FinanceRepository extends JpaRepository<Finance, Long> {

	List<Finance> findByStatus(char status);

	List<Finance> findByCollectDate(String collectDate);

	List<Finance> findByCollectDateAfter(String collectDate);

//	@Query("SELECT * FROM tbl_salary_saving a WHERE a.toName = ?1")
	List<Finance> findByCustomerNameContaining(String customerName);
//	or

//	@Query("SELECT * FROM tbl_salary_saving a WHERE a.toName = :toName")
//	List<Finance> findByToNameContaining(@Param("toName") String name);

}
