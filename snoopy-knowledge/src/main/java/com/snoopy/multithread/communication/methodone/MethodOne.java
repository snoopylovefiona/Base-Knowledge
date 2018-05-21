package com.snoopy.multithread.communication.methodone;

import com.snoopy.multithread.communication.Helper;

/**
 * 
 * 类名称：MethodOne.java <br>
 * 内容摘要： //线程通信。<br>
 * 修改备注： 利用最基本的synchronized、notify、wait<br>
 * 创建时间： 2018年4月27日下午3:12:48<br>
 * 
 * @author Snoopy.Li<br>
 */
public class MethodOne {
	private final ThreadToGo threadToGo = new ThreadToGo();

	public Runnable newThreadOne() {
		final String[] inputArr = Helper.buildNoArr(52);
		return new Runnable() {
			private String[] arr = inputArr;

			public void run() {
				try {
					// 遍历52个数，step = 2,因为每次要输出两个
					for (int i = 0; i < arr.length; i = i + 2) {
						synchronized (threadToGo) {
							while (threadToGo.value == 2) {
								// 当前线程进入等待
								threadToGo.wait();
							}
							Helper.print(arr[i], arr[i + 1]);
							// 打印完一组（两个）标志
							threadToGo.value = 2;
							// 随机唤醒另一个等待线程
							threadToGo.notify();
						}
					}
				} catch (InterruptedException e) {
					System.out.println("Oops...");
				}
			}
		};
	}

	public Runnable newThreadTwo() {
		final String[] inputArr = Helper.buildCharArr(26);
		return new Runnable() {
			private String[] arr = inputArr;

			public void run() {
				try {
					// 遍历英文字母，step = 1，因为每次都要输出1个
					for (int i = 0; i < arr.length; i++) {
						synchronized (threadToGo) {
							while (threadToGo.value == 1) {
								// 当前线程进入等待
								threadToGo.wait();
							}
							Helper.print(arr[i]);
							// 打印完一组标志
							threadToGo.value = 1;
							// 随机唤醒其他线程
							threadToGo.notify();
						}
					}
				} catch (InterruptedException e) {
					System.out.println("Oops...");
				}
			}
		};
	}

	class ThreadToGo {
		// 打印标志
		int value = 1;
	}

	public static void main(String args[]) throws InterruptedException {
		MethodOne one = new MethodOne();
		Helper.instance.run(one.newThreadOne());
		Helper.instance.run(one.newThreadTwo());
		Helper.instance.shutdown();
	}
}