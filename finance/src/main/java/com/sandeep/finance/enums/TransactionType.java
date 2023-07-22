package com.sandeep.finance.enums;

import java.util.Arrays;

public enum TransactionType {

	DEBIT('D'), CREDIT('C');

	private char transactionType;

	TransactionType(char transactionType) {
		this.transactionType = transactionType;
	}

	public char getType() {
		return this.transactionType;
	}

	public static TransactionType getTransactionType(char transactionType1) {
		return Arrays.asList(TransactionType.values()).stream()
				.filter(transactionType -> transactionType.getType() == transactionType1).findFirst().orElse(null);
	}
}
