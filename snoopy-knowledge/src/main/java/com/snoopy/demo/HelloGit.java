package com.snoopy.demo;

import java.util.HashMap;
import java.util.Map;

public class HelloGit {

	public static void main(String[] args) {
		long a = 2147483648L;
		int b = (int) a;
		System.out.println(b);

		System.out.println("long:" + Long.MAX_VALUE);
		System.out.println("float:" + Float.MAX_VALUE);
		System.out.println("int:" + Integer.MAX_VALUE + "mix:" + Integer.MIN_VALUE);
		System.out.println("double:" + Double.MAX_VALUE);

		Map<String, String> map = new HashMap<>();

		binaryToDecimalLong(2147483647L);

		/**
		 * 2147483648 的二进制表示：
		 * 
		 * 00000000000000000000000000000000 10000000 00000000 00000000 00000000
		 * 
		 * int类型只占4个字节 低位截取 10000000 00000000 00000000 00000000 这个是补码
		 * 
		 * 原码就是：11111111 11111111 11111111 11111111
		 * 
		 * 就是-2147483648
		 * 
		 */
		//
		// 十进制转成十六进制：
		Integer.toHexString(20);

		// 十进制转成八进制
		Integer.toOctalString(30);

		// 十进制转成二进制
		Integer.toBinaryString(40);

		// 十六进制转成十进制
		Integer.valueOf("FFFF", 16).toString();

		// 八进制转成十进制
		Integer.valueOf("876", 8).toString();

		// 二进制转十进制
		Integer.valueOf("0101", 2).toString();

	}

	public static void binaryToDecimalInteger(int n) {
		for (int i = 31; i >= 0; i--)
			System.out.print(n >>> i & 1);
	}

	public static void binaryToDecimalLong(long n) {
		for (long i = 63; i >= 0; i--) {
			System.out.print(n >>> i & 1);
		}
	}
}
