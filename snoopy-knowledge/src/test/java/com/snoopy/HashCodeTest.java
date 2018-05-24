package com.snoopy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HashCodeTest {

	public static void main(String[] args) {
		String hash = new String("hello world");
		System.out.println(hash.hashCode());

		String hash2 = new String("hello world");
		System.out.println(hash2.hashCode());

		List<String> array = new ArrayList<>();
		array.add(hash);
		array.add(hash2);
		System.out.println(array.get(0).hashCode());
		System.out.println(randomString(-229985452) + " " + randomString(-147909649));

		Long seed = -229985452L;
		Long multiplier = 25214903917L;
		Long mask = 281474976710655L;
		Long result = (seed ^ multiplier) & mask;
		System.out.println(result);
		
//		281449956005177
		
	}

	public static String randomString(int seed) {
		Random rand = new Random(seed);
		StringBuilder sb = new StringBuilder();
		while (true) {
			int n = rand.nextInt(27);
			if (n == 0) {
				break;
			}
			System.out.println(n);
			sb.append((char) ('`' + n));
		}
		return sb.toString();
	}

}
/**
 * 
 * 1 1794106083
 * 
 */
