package com.xyzxc.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Arrays_Collection {
	public static void main(String[] args) {

		int[] arr;
		arr = new int[5];

		int[] arr2 = { 1, 2, 3, 4, 5 };

		Integer[] arr3 = { 1, 2, 3, 4, 5 };

		String[] stringArray = { "1", "2", "3", "4", "5" };

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// length
		int lengh = arr.length;

		// iterate
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}

		for (int i : arr2) {
			System.out.println(i);
		}

		Arrays.stream(arr2).forEach(System.out::println);

		/*
		 * Parallel streams split the data and process it across multiple threads,
		 * providing potential performance benefits for large datasets. should not use
		 * when we have to work with element ordering
		 */
		Arrays.stream(arr2).parallel().forEach(System.out::println);

		// convert
		List<String> listString = Arrays.asList(stringArray);

		// Create a modifiable list
		List<String> listString1 = new ArrayList<String>(Arrays.asList(stringArray));

		List<Integer> listInteger = Arrays.stream(arr3).toList();

		List<Integer> listInteger1 = Arrays.stream(arr3).collect(Collectors.toList());

		List<Integer> evenList = Arrays.stream(arr3).filter(i -> i % 2 == 0).collect(Collectors.toList());

		List<Integer> primitiveIntList = Arrays.stream(arr).boxed().toList();

		Set<String> setString = new HashSet<String>(Arrays.asList(stringArray));

		Set<String> setString1 = Arrays.asList(stringArray).stream().collect(Collectors.toSet());

		Set<Integer> setInteger = IntStream.of(arr2).boxed().collect(Collectors.toSet());

		Set<Integer> setInteger1 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());

		Map<Integer, Integer> IntegerMap = IntStream.range(0, arr2.length).boxed()
				.collect(Collectors.toMap(i -> i, i -> 1, Integer::sum));

		// filter
		Arrays.stream(arr2).filter(i -> i % 2 == 0).map(i -> i * 2).forEach(System.out::println);

	}

}
