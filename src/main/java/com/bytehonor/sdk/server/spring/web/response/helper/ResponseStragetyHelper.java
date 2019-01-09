package com.bytehonor.sdk.server.spring.web.response.helper;

import org.springframework.http.HttpHeaders;

import com.bytehonor.protocol.core.server.constant.ForceStatusHeader;

public class ResponseStragetyHelper {

	public static final boolean isForceHttpStatusOk(HttpHeaders headers) {
		String val = headers.getFirst(ForceStatusHeader.FORCE_STATUS_OK_KEY);
		return ForceStatusHeader.FORCE_STATUS_OK_VALUE.equals(val);
	}

}
