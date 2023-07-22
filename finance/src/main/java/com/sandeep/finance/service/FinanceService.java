package com.sandeep.finance.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.finance.dto.FinanceDto;
import com.sandeep.finance.entities.Finance;
import com.sandeep.finance.enums.FinanceStatus;
import com.sandeep.finance.repository.FinanceRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FinanceService {

	@Autowired
	FinanceRepository financeRepository;

	public FinanceDto saveFinance(FinanceDto financeDto) {
		log.info("FinanceDto : {}", financeDto);
		return mapFinanceDtoFromFinance(financeRepository.save(mapFinancefromFinanceDto(financeDto)));
	}

	public List<FinanceDto> getFinanceByStatus(FinanceStatus status) {
		log.info("status : {}", status);
		return financeRepository.findByStatus(status.getValue()).stream()
				.map(finance -> mapFinanceDtoFromFinance(finance)).collect(Collectors.toList());
	}

	public List<FinanceDto> getFinances() {
		return financeRepository.findAll().stream().map(finance -> mapFinanceDtoFromFinance(finance))
				.collect(Collectors.toList());
	}

	public List<FinanceDto> getFinancesByCollectDate(String collectDate) {
		log.info("collectDate : {}", collectDate);
		return financeRepository.findByCollectDate(collectDate).stream()
				.map(finance -> mapFinanceDtoFromFinance(finance)).collect(Collectors.toList());
	}

	public List<FinanceDto> getFinancesByCollectDateAfter(String collectDate) {
		log.info("after collectDate finances : {}", collectDate);
		return financeRepository.findByCollectDateAfter(collectDate).stream()
				.map(finance -> mapFinanceDtoFromFinance(finance)).collect(Collectors.toList());
	}

	public List<FinanceDto> findByCustomerNameContaining(String name) {
		log.info("name : {} ", name);
		return financeRepository.findByCustomerNameContaining(name).stream()
				.map(finance -> mapFinanceDtoFromFinance(finance)).collect(Collectors.toList());
	}

	public FinanceDto updateFinance(FinanceDto financeDto) {
		log.info("FinanceRequestDto : {}", financeDto);
		return mapFinanceDtoFromFinance(financeRepository.save(mapFinancefromFinanceDto(financeDto)));
	}

	private Finance mapFinancefromFinanceDto(FinanceDto financeDto) {
		return Finance.builder().financeId(financeDto.getFinanceId()).customerName(financeDto.getCustomerName())
				.customerAccount(financeDto.getCustomerAccount()).companyName(financeDto.getCompanyName())
				.companyAccount(financeDto.getCompanyName()).amount(financeDto.getAmount())
				.dateCreated(financeDto.getDateCreated()).rateOfInterest(financeDto.getRateOfInterest())
				.collectAmount(financeDto.getCollectAmount()).collectDate(financeDto.getCollectDate())
				.phoneNumber(financeDto.getPhoneNumber()).status(FinanceStatus.INITIATED.getValue())
				.remarks(financeDto.getRemarks()).build();
	}

	private FinanceDto mapFinanceDtoFromFinance(Finance finance) {
		log.info(" finance : {}", finance);
		return FinanceDto.builder().financeId(finance.getFinanceId()).customerName(finance.getCustomerName())
				.customerAccount(finance.getCustomerAccount()).companyName(finance.getCompanyName())
				.companyAccount(finance.getCompanyName()).amount(finance.getAmount())
				.dateCreated(finance.getDateCreated()).rateOfInterest(finance.getRateOfInterest())
				.collectAmount(finance.getCollectAmount()).collectDate(finance.getCollectDate())
				.phoneNumber(finance.getPhoneNumber()).status(FinanceStatus.getValueOfStatus(finance.getStatus()))
				.remarks(finance.getRemarks()).build();
	}
}
