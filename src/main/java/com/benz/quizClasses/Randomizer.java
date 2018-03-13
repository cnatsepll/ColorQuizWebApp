package com.benz.quizClasses;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Randomizer {

	public int keyRandomizer(Map<Integer, List> colorQuiz) {

		int key = 0;
		int counter = 0;
		int randomHolder = 1;
		boolean isItEven = true;
		while (counter < 100) {
			int randomChooser = 0;
			Random rand = new Random();
			int chooseColorList = rand.nextInt(5) + 1;
			randomChooser = chooseColorList;
			randomHolder = randomChooser - 1;

			isItEven = (colorQuiz.get(randomHolder).size() >= colorQuiz.get(0).size()
					&& colorQuiz.get(randomHolder).size() >= colorQuiz.get(1).size()
					&& colorQuiz.get(randomHolder).size() >= colorQuiz.get(2).size()
					&& colorQuiz.get(randomHolder).size() >= colorQuiz.get(3).size()
					&& colorQuiz.get(randomHolder).size() >= colorQuiz.get(4).size());

			if (randomChooser == 1 && colorQuiz.get(0).size() > 1 && isItEven) {
				key = 0;
				return key;
			} else if (randomChooser == 2 && colorQuiz.get(1).size() > 1 && isItEven) {
				key = 1;
				return key;
			} else if (randomChooser == 3 && colorQuiz.get(2).size() > 1 && isItEven) {
				key = 2;
				return key;
			} else if (randomChooser == 4 && colorQuiz.get(3).size() > 1 && isItEven) {
				key = 3;
				return key;
			} else if (randomChooser == 5 && colorQuiz.get(4).size() > 1 && isItEven) {
				key = 4;
				return key;
			} else {
				// chooseColorList = rand.nextInt(5) + 1;
				counter++;
			}

		}
		return 5;
	}

	public int newLine(Map colorQuiz, int key) {
		List<String> lineArray = (List<String>) colorQuiz.get(key);
		Random newRandom = new Random();
		if (lineArray.size() > 1) {
			int size = lineArray.size();
			int listSize = size - 1;
			int i = newRandom.nextInt(listSize);
			return i;
		} else {
			int i = newRandom.nextInt(lineArray.size());
			return i;
		}

	}
}