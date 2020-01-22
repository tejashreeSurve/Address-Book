package com.bridgelabz.fellowshipprogram.oops.addressbook.utility;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility {

	static Scanner scanner = new Scanner(System.in);

	// This method sort the string value using bubble sort
	public static String[] bubblesortForStringArray(String[] arr) {
		String temp;
		for (int i = 0; i < (arr.length) - 1; i++)
			for (int j = 0; j < (arr.length) - 1; j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		return arr;
	}

	// This method sort the integer value using bubble sort
	public static int[] bubblesort(int[] arr) {
		int temp;
		for (int i = 0; i < (arr.length) - 1; i++)
			for (int j = 0; j < (arr.length) - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		return arr;
	}

	// This method read integer value
	public int integerValue() {
		int number = 0;
		try {
			number = scanner.nextInt();
			return number;
		} catch (Exception e) {
			System.out.println("Enter the Only Integer");
			scanner.next();
			number = integerValue();
		}
		scanner.close();
		return number;
	}

	// This method read String value
	public static String stringValue() {
		try {
			return scanner.next();
		} catch (Exception e) {
			System.out.println("Please enter valide option\\n");
		}
		scanner.close();
		return null;
	}

	// This method read long value
	public static long longValue() {
		try {
			return scanner.nextLong();
		} catch (Exception e) {
			System.out.println("Please enter valide option\n");
		}
		scanner.close();
		return 9;
	}

	// This method validate contact number value
	public static boolean phoneNumberValidation(String contact) {
		String value = "^\\d{10}";
		if (contact.matches(value))
			return true;
		else
			return false;
	}

	// This method validate date value
	public static boolean dateValidation(String date) {
		String value = "((([0]{1}[1-9]{1})|([1]{1}[0-9]{1})|([2]{1}[0-9]{1})|([3]{1}[0-1]{1}))/(([0]{1}[1-9]{1})|([1]{1}[0-2]{1}))/([1-9]{1}[0-9]{1}[0-9]{1}[1-9]{1}))";
		if (date.matches(value))
			return true;
		else
			return false;

	}
}
