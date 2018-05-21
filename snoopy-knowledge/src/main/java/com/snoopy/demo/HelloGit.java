package com.snoopy.demo;

public class HelloGit {

	// 类型强制转换原理

	public static void main(String[] args) {


		System.out.println("long:" + Long.MAX_VALUE);

		System.out.println("float:" + Float.MAX_VALUE);

		System.out.println("int:" + Integer.MAX_VALUE + "mix:" + Integer.MIN_VALUE);

		System.out.println("double:" + Double.MAX_VALUE);

		binaryToDecimalLong(2147483647L);

		System.out.println(Long.toBinaryString(2147483647L));
		
		/**
		 * 
		 * 2147483648 Long类型的的二进制表示：
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
		Integer.valueOf("555", 8).toString();

		// 二进制转十进制
		Integer.valueOf("0101", 2).toString();
		
		
		Long.toBinaryString(2147483647L);

	}

	public static void binaryToDecimalInteger(int n) {
		for (int i = 31; i >= 0; i--) {
			System.out.print(n >>> i & 1);
		}
	}

	public static void binaryToDecimalLong(long n) {
		for (long i = 63; i >= 0; i--) {
			System.out.print(n >>> i & 1);
		}
	}
}
