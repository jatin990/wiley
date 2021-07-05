package wiley.programs;

import java.util.Scanner;

public class palindromeoptimised {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string or alphanumeric string");
		String input = sc.nextLine();
		if (input.matches("[0-9]+")) {
			System.out.println("Number as an input is not allowed");
		} else {
			Boolean flag=false;
			int l=input.length();
			for (int i = input.length() - 1; i >= input.length()/2; i--) {
				if( input.charAt(i) != input.charAt(l-i-1)) {
					flag=true;
					break;
				}
			}
			if (!flag) {
				System.out.println("Entered string is a palindrome");
			} else {
				System.out.println("Not a plaindrome");
			}
		}
	}
}
