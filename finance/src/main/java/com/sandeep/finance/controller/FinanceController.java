package com.sandeep.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sandeep.finance.dto.FinanceDto;
import com.sandeep.finance.enums.FinanceStatus;
import com.sandeep.finance.service.FinanceService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/finance/")
@RestController
@Slf4j
public class FinanceController {

	@Autowired
	private FinanceService financeService;

	@PostMapping("/save")
	public ResponseEntity<FinanceDto> saveFinance(@RequestBody String financeInfo) {
		log.info("financeInfo 1 : {}", financeInfo);
		FinanceDto financeDto = (new Gson()).fromJson(financeInfo, FinanceDto.class);
		financeDto.setCollectAmount((financeDto.getAmount() * financeDto.getRateOfInterest()) / 100);
		log.info(" FinanceDto 2 : {}", financeDto);
		return ResponseEntity.ok(financeService.saveFinance(financeDto));
	}

	@GetMapping("/get/{status}")
	public ResponseEntity<List<FinanceDto>> getFinancesByStatus(@RequestParam FinanceStatus status) {
		return new ResponseEntity<List<FinanceDto>>(financeService.getFinanceByStatus(status), HttpStatus.OK);
	}

	@GetMapping("/get/")
	public ResponseEntity<List<FinanceDto>> getFinances() {
		return new ResponseEntity<>(financeService.getFinances(), HttpStatus.OK);
	}

	@GetMapping("/get/collectDate/{collectDate}")
	public ResponseEntity<List<FinanceDto>> getFinancesByCollectDate(@RequestParam String collectDate) {
		return new ResponseEntity<List<FinanceDto>>(financeService.getFinancesByCollectDate(collectDate),
				HttpStatus.OK);
	}

	@GetMapping("/get/afterCollectDate/{collectDate}")
	public ResponseEntity<List<FinanceDto>> getFinancesByCollectDateAfter(@RequestParam String collectDate) {
		return new ResponseEntity<List<FinanceDto>>(financeService.getFinancesByCollectDateAfter(collectDate),
				HttpStatus.OK);
	}

	@RequestMapping("/get/name/{customerName}")
	public ResponseEntity<List<FinanceDto>> findByCustomerNameContaining(@RequestParam String customerName) {
		return new ResponseEntity<List<FinanceDto>>(financeService.findByCustomerNameContaining(customerName),
				HttpStatus.OK);
	}
}
