package com.sandeep.finance.enums;

import java.util.Arrays;

public enum FinanceStatus {
	ACTIVE('A'), COMPLETED('C'), PENDING('P'), INITIATED('I'), DEACTIVATED('D'),;

	public char status;

	private FinanceStatus(char status) {
		this.status = status;
	}

	public char getValue() {
		return this.status;
	}

	public static FinanceStatus getValueOfStatus(char status1) {
		return Arrays.asList(FinanceStatus.values()).stream().filter(status -> status.getValue() == status1).findFirst()
				.orElse(null);
	}
}
