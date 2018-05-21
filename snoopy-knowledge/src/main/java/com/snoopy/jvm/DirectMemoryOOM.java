package com.snoopy.jvm;

import java.nio.ByteBuffer;

/**
 * 
 * 类名称：DirectMemoryOOM.java <br>
 * 内容摘要： //说明主要功能。<br>
 * 修改备注： <br>
 * 创建时间： 2018年5月21日下午1:12:49<br>
 * 
 * @author Snoopy.Li<br>
 */
public class DirectMemoryOOM {
	/**
	 * 本机内存DirectMemory，属于C Heap，可以通过参数-XX:MaxDirectMemorySize指定。<br>
	 * 如果不指定，该参数的默认值为Xmx的值减去1个Survior区的值。如设置启动参数-Xmx20M -Xmn10M -XX:SurvivorRatio=8,那么申请20M-1M=19M的DirectMemory是没有问题的<br>
	 * 
	 * VM Args: -Xmx20M -Xmn10M -XX:MaxDirectMemorySize=10M -XX:+PrintGCDetails
	 */

	private static final int _1MB = 1024 * 1024;

	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(5000);
		methodTwo();
		Thread.sleep(500000);
	}

	public static void methodOne() {
		ByteBuffer.allocateDirect(11 * _1MB);
	}

	public static void methodTwo() throws InterruptedException {
		/**
		 * 先申请10M，再申请1M，此时会发现JVM不会出现OOM的现象。
		 */
		ByteBuffer.allocateDirect(10 * _1MB);
		Thread.sleep(5000);
		ByteBuffer.allocateDirect(_1MB);
	}

	public static void methodThree() {
		/**
		 * 这里需要说明的是，如果DirectByteBuffer的空间够用，那么System.gc()是不会触发FullGC的。 <br>
		 * 而如果使用了参数-XX:+DisableExplicitGC,那么调用System.gc()时也不会触发FullGC。
		 */
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10 * _1MB);
		byteBuffer.allocateDirect(_1MB);

		/**
		 * 说明DirectBuffer的GC规则与堆对象的回收规则是一样的，只有垃圾对象才会被回收，而判定是否为垃圾对象依然是根据引用树中的存活节点来判定。 <br>
		 * 
		 * 在垃圾收集时，虽然虚拟机会对DirectMemory进行回收，但是DirectMemory却不像新生代和老年代那样，发现空间不足了就通知收集器进行垃圾回收，它只能等待老年代满了后FullGC，然后“顺便地”帮它清理掉内存中废弃的对象。 <br>
		 * 否则，只能等到抛出内存溢出异常时，在catch块里调用System.gc()。
		 * 
		 */
	}

}