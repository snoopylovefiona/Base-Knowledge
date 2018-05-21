package com.snoopy.jvm;

import java.util.ArrayList;
import java.util.List;

public class ListGC {

	public static void main(String[] args) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<String> array = new ArrayList<>();
		for (int i = 0; i < 2000000; i++) {
			String temp = new String("Snoopy-" + i);
			array.add(temp);
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 2000000; i++) {
			String temp = new String("Snoopy-" + i);
			array.add(temp);
		}
		System.err.println("end");
//		array.clear();
		array = null;
		System.gc();
		try {
			Thread.sleep(2000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
