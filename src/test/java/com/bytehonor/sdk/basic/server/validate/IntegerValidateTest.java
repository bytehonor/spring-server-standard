package com.bytehonor.sdk.basic.server.validate;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IntegerValidateTest {

	@Test
	public void testRange() {
		boolean isOk = true;
		try {
			IntegerValidate.range(2, 1, 3, "key");
		} catch (Exception e) {
			isOk = false;
		}
		assertTrue("testCheckLength", isOk);
	}

}
