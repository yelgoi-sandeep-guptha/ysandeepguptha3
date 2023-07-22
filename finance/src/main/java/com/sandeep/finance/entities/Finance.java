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

@Data
@Builder
@Entity
@Table(name = "tbl_finance")
@NoArgsConstructor
@AllArgsConstructor
public class Finance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "finance_id", insertable = true, nullable = false, unique = true)
	private Long financeId;
	@Column(length = 50)
	private String customerName;
	@Column(length = 10)
	private String customerAccount;
	@Column(length = 10)
	private String companyName;
	@Column(length = 10)
	private String companyAccount;
	private Integer amount;
	@Column(length = 10)
	private String dateCreated;
	private Integer rateOfInterest;
	private Integer collectAmount;
	@Column(length = 10)
	private String collectDate;
	@Column(length = 10)
	private String phoneNumber;
	@Column(length = 1)
	private char status;
	@Column(length = 50)
	private String remarks;

//	@Transient   -- not stored in database
//	@Temporal -- stored temporaray
}
