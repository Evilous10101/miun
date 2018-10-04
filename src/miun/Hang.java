package miun;

import java.util.Scanner;

public class Hang {
	
	private static String[] words = {"cat", "dog", "spider", "chicken", "word", "coke" };
	private static String word = words[(int) (Math.random() * words.length)];
	private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
	private static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (count < 7 && asterisk.contains("*")) {
			System.out.println("Guess any letter in the word");
			System.out.println(asterisk);
			String guess = sc.next();
			hang(guess);
		}
		sc.close();
	}
	
	public static void hang(String guess) {
		String newasterisk = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess.charAt(0)) {
				newasterisk += guess.charAt(0);
			} else if (asterisk.charAt(i) != '*') {
				newasterisk += word.charAt(i);
			} else {
				newasterisk += "*";
			}
		}

		if (asterisk.equals(newasterisk)) {
			count++;
			hangmanWrongguesses();
		} else {
			asterisk = newasterisk;
		}
		if (asterisk.equals(word)) {
			System.out.println("Correct! You win! The word was " + word);
			System.exit(0);
		}
	}
	
	public static void hangmanWrongguesses() {
		if (count == 1) {
			System.out.println("Wrong guess, you have 6 trys left");
			
		}
		if (count == 2) {
			System.out.println("Wrong guess, you have 5 trys left");
			
		}
		if (count == 3) {
			System.out.println("Wrong guess, you have 4 trys left");
			
		}
		if (count == 4) {
			System.out.println("Wrong guess, you have 3 trys left");
			
		}
		if (count == 5) {
			System.out.println("Wrong guess, you have 2 trys left");
			
		}
		if (count == 6) {
			System.out.println("Wrong guess, you have one try left");
			
		}
		if (count == 7) {
			System.out.println("You used all of your trys");
			
			System.out.println("GAME OVER! The word was " + word);
			
			System.exit(0); 
		}
	}
}

