package com.snoopy.multithread.communication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * 类名称：Helper.java <br>
 * 内容摘要： //说明主要功能。<br>
 * 修改备注： <br>
 * 创建时间： 2018年4月27日下午3:09:15<br>
 * 
 * @author Snoopy.Li<br>
 */
public enum Helper {

	instance;

	private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(2);

	public static String[] buildNoArr(int max) {
		String[] noArr = new String[max];
		for (int i = 0; i < max; i++) {
			noArr[i] = Integer.toString(i + 1);
		}
		return noArr;
	}

	public static String[] buildCharArr(int max) {
		String[] charArr = new String[max];
		int tmp = 65;
		for (int i = 0; i < max; i++) {
			charArr[i] = String.valueOf((char) (tmp + i));
		}
		return charArr;
	}

	public static void print(String... input) {
		if (input == null)
			return;
		for (String each : input) {
			System.out.print(each);
		}
	}

	public void run(Runnable r) {
		EXECUTOR_SERVICE.submit(r);
	}

	public void shutdown() {
		EXECUTOR_SERVICE.shutdown();
	}

}