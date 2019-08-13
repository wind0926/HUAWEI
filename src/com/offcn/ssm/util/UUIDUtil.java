package com.offcn.ssm.util;

import java.util.UUID;

import org.junit.Test;

public class UUIDUtil {

	public static String getUUId() {
		
		return UUID.randomUUID().toString().replace("-", "");
		
		
	//	return null;
	}
	
}
