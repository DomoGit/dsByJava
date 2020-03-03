package com.mj;

public class Assert {
	public static void test(boolean condition) {
		try {
			if (!condition) {
				throw new Exception("测试未通过");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
