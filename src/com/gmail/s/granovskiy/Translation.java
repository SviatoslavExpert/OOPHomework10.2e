package com.gmail.s.granovskiy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Translation implements Interface {
	
	public String[] loadTextAndSplit() {
		String englishText = loadFromFile(new File("English.in.txt"));
		String[] arrayOne = englishText.split(" "); 
		return arrayOne;
	}

	public void addWordsToDictionary(Map<String, String> hm) {
		Scanner sc = new Scanner(System.in);
		boolean k = true;
		while (k == true) {
			System.out.println("Would you like to make an entry to the dictionary? Y/N " + " ");
			String userAnswerStart = sc.nextLine();

			if (userAnswerStart.equals("Y")) {
				System.out.println("Please, enter English word: ");
				String englishWord = sc.nextLine();
				if (!englishWord.equals(null)) {
					System.out.println("Please, enter Ukrainian word: ");
					String ukrainianWord = sc.nextLine();
					hm.put(englishWord, ukrainianWord);
				}
			} else {
				System.out.println("Well, Good-bye!");
				k = false;
			}
		}
		sc.close();
	}

	public void translateTheText(Map<String, String> hm, String[] arrayOne) {
		try (PrintWriter pw = new PrintWriter("Ukrainian.out.txt")) {

			// printing the content of arrayOne to the console
			System.out.println(Arrays.toString(arrayOne));
			System.out.println();

			// printing the translation: arrayOne -> Map -> print
			for (String key : arrayOne) {
				System.out.print(hm.get(key) + " ");
				pw.print(hm.get(key) + " ");
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR FILE WRITE");
		}
	}

	public String loadFromFile(File file) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = "";
			for (; (text = br.readLine()) != null;) {
				sb.append(text).append(System.lineSeparator());
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return sb.toString();
	}
}
