package com.sandeep.finance.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name = "tbl_salary_saving")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalarySaving {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private char transactionType;
	private Float amount;
	@Column(length = 7)
	private String monthYear;
	@Column(length = 10)
	private String dateCreated;

}
