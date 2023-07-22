package com.sandeep.finance.dto;

import com.sandeep.finance.enums.FinanceStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FinanceDto {
	private Long financeId;
	private String customerName;
	private String customerAccount;
	private String companyName;
	private String companyAccount;
	private Integer amount;
	private String dateCreated;
	private Integer rateOfInterest;
	private Integer collectAmount;
	private String collectDate;
	private String phoneNumber;
	private FinanceStatus status;
	private String remarks;
}
