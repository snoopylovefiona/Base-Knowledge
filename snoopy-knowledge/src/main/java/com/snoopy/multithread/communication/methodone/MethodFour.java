package com.snoopy.multithread.communication.methodone;

import java.util.concurrent.atomic.AtomicInteger;

import com.snoopy.multithread.communication.Helper;

/**
 * 
 * 类名称：MethodFour.java <br>
 * 内容摘要： //说明主要功能。<br>
 * 修改备注： 利用AtomicInteger <br>
 * 创建时间： 2018年4月27日下午3:18:00<br>
 * 
 * @author Snoopy.Li<br>
 */
public class MethodFour {
	private AtomicInteger threadToGo = new AtomicInteger(1);

	public Runnable newThreadOne() {
		final String[] inputArr = Helper.buildNoArr(52);
		return new Runnable() {
			private String[] arr = inputArr;

			public void run() {
				for (int i = 0; i < arr.length; i = i + 2) {
					while (threadToGo.get() == 2) {
					}
					Helper.print(arr[i], arr[i + 1]);
					threadToGo.set(2);
				}
			}
		};
	}

	public Runnable newThreadTwo() {
		final String[] inputArr = Helper.buildCharArr(26);
		return new Runnable() {
			private String[] arr = inputArr;

			public void run() {
				for (int i = 0; i < arr.length; i++) {
					while (threadToGo.get() == 1) {
					}
					Helper.print(arr[i]);
					threadToGo.set(1);
				}
			}
		};
	}

	public static void main(String args[]) throws InterruptedException {
		MethodFour five = new MethodFour();
		Helper.instance.run(five.newThreadOne());
		Helper.instance.run(five.newThreadTwo());
		Helper.instance.shutdown();
	}
}