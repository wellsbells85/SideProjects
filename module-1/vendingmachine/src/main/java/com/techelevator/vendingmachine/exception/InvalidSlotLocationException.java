package com.techelevator.vendingmachine.exception;

@SuppressWarnings("serial")
public class InvalidSlotLocationException extends RuntimeException {
	public InvalidSlotLocationException() {
		super();
	}

	public InvalidSlotLocationException(String message) {
		super(message);
	}

	public InvalidSlotLocationException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidSlotLocationException(Throwable cause) {
		super(cause);
	}
}
