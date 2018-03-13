package com.benz.quizApp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddKey {

	public static void main(String[] args) {

		String newFilePath = "";
		String existingFilepath = "";
		String key = "";

		Scanner userInput = new Scanner(System.in);

		key = getKey(userInput);

		existingFilepath = getExistingFilePath(userInput);
		newFilePath = getNewFilePath(userInput);

		try {
			addWord(existingFilepath, newFilePath, key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("File created, please check your folder");
		System.exit(0);
	}

	private static String getExistingFilePath(Scanner userInput) {
		String existingFilepath;
		System.out.println();
		System.out.println("Please enter absolute file path of the original file");
		existingFilepath = userInput.nextLine();
		return existingFilepath;
	}

	private static String getNewFilePath(Scanner userInput) {
		String newFilePath;
		System.out.println();
		System.out.println("Please enter absolute file path of the new file");
		newFilePath = userInput.nextLine();
		return newFilePath;
	}

	private static String getKey(Scanner userInput) {
		String key = "";
		System.out.println("Please enter a 'w'u'b'r'g' key to identify the color of this file.");
		key = userInput.nextLine();
		return key;
	}

	private static void addWord(String existingFilePath, String newFilePath, String key) throws FileNotFoundException {
		int counter = 0;
		String line = "";
		String addedLine = "";

		File newFile = new File(newFilePath);
		try {
			newFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (PrintWriter writer = new PrintWriter(newFile)) {

			File existingFile = new File(existingFilePath);
			try (Scanner lineReader = new Scanner(existingFile)) {
				while (lineReader.hasNextLine()) {
					line = lineReader.nextLine();
					addedLine = key + line;
					writer.println(addedLine);
				}
			}
			return;
		}
	}

	private static String getSearchWord(Scanner userInput) {
		String addedWord;
		while (true) {
			System.out.println("Which word would you like to add?: ");
			addedWord = userInput.nextLine();
			if (addedWord.length() > 0) {
				break;
			}
		}

		return addedWord;
	}
}
