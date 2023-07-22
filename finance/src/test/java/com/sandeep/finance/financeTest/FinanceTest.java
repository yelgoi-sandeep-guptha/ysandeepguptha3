package com.sandeep.finance.financeTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.sandeep.finance.dto.FinanceDto;
import com.sandeep.finance.enums.FinanceStatus;
import com.sandeep.finance.service.FinanceService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class FinanceTest {

	@Autowired
	FinanceService financeService;
	
	@Autowired
	MockMvc mockmvc;

//	@Test
	void saveFinanceTest() {
		FinanceDto financeRequestDto = FinanceDto.builder().customerName("Sandeep").amount(100).collectAmount(220)
				.collectDate("2023-03-03").dateCreated("2023-04-03").rateOfInterest(10).phoneNumber("9505307555")
				.status(FinanceStatus.INITIATED).build();
		log.info("financeRequestDto : {} ", financeRequestDto);
		FinanceDto financeResponseDto = financeService.saveFinance(financeRequestDto);
		log.info("financeResponseDto : {}", financeResponseDto);
	}

//	@Test
	void findFinancesByStatusTest() {
		List<FinanceDto> listOfResponses = financeService.getFinanceByStatus(FinanceStatus.INITIATED);
		log.info("listOfResponses : {}", listOfResponses);
	}

	@Test
	void findByToNameContainingTest() {
		List<FinanceDto> listOfResponses = financeService.findByCustomerNameContaining("dee");
		log.info("listOfResponses : {}", listOfResponses);
	}
}
