package com.bytehonor.sdk.server.spring.exception;

import com.bytehonor.protocol.core.server.code.StandardCode;
import com.bytehonor.protocol.core.server.error.StandardException;

public class InternalRestfulException extends StandardException {

	private static final long serialVersionUID = 8241747723232910227L;
	
	public InternalRestfulException() {
		super();
		this.setCode(StandardCode.INTERNAL_ERROR);
	}

	public InternalRestfulException(int code, String message) {
		super(code, format(message));
	}

	private static String format(String message) {
		StringBuilder sb = new StringBuilder();
		sb.append("Remote Error [").append(message).append("]");
		return sb.toString();
	}

}