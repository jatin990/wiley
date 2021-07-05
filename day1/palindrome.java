package wiley.programs;

import java.util.Scanner;

public class palindrome {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string or alphanumeric string");
		String input = sc.nextLine();
		if (input.matches("[0-9]+")) {
			System.out.println("Number as an input is not allowed");
		} else {
			String rev = "";
			for (int i = input.length() - 1; i >= 0; i--) {
				rev += input.charAt(i);
			}
			if (input.equals(rev)) {
				System.out.println("Entered string is a palindrome");
			} else {
				System.out.println("Not a plaindrome");
			}
		}
	}
}
