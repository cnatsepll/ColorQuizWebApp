package com.benz.quizClasses;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Quiz {
	private Integer whiteCounter = 0;
	private Integer blueCounter = 0;
	private Integer blackCounter = 0;
	private Integer redCounter = 0;
	private Integer greenCounter = 0;



	public List<String> getColorQualities(Map colorQuiz, int key, int i) {
		Randomizer randomKey = new Randomizer();
		List<String> lineArray = (List<String>) colorQuiz.get(key);
		return lineArray;
	}

	public String getQuestion(Map colorQuiz, List<String> lineArray, int i, int key) {
		String question = (lineArray.get(i).substring(1));
		lineArray.remove(i);
		colorQuiz.remove(key);
		if (lineArray.size() > 0) {
			colorQuiz.put(key, lineArray);
		}
		return question;
	}

	public int getAnswer(Scanner answerReader, Map colorQuiz, String colorTypeKey) {
		// while (answerReader) {
		String answerAsString = answerReader.nextLine();
		// answerReader.close();
		try {
			int answer = Integer.parseInt(answerAsString);
			return answer;
		} catch (NumberFormatException e) {
			return -1;
		}
		// }

	}

	public int storeResult(Map<String, Integer> colorResult, String colorTypeKey, int answer) {
		Integer isListEmpty = colorResult.get(colorTypeKey);
		if (isListEmpty != null) {
			answer += (colorResult.get(colorTypeKey));
			return answer;
		} else {
			return answer;
		}

	}

	public void fillCounters(Map<String, Integer> colorResult) {
		if (colorResult.get("w") != null) {
			whiteCounter = colorResult.get("w");
		}
		if (colorResult.get("u") != null) {
			blueCounter = colorResult.get("u");
		}
		if (colorResult.get("b") != null) {
			blackCounter = colorResult.get("b");
		}
		if (colorResult.get("r") != null) {
			redCounter = colorResult.get("r");
		}
		if (colorResult.get("g") != null) {
			greenCounter = colorResult.get("g");
		}
	}

	public int[] gatherCounters() {
		int resultsArray[] = { whiteCounter, blueCounter, blackCounter, redCounter, greenCounter };
		return resultsArray;
	}

	public String printScores(Map<String, Integer> colorResult, int questionCounter) {
		String mage = "You are a ";

		int resultsArray[] = { whiteCounter, blueCounter, blackCounter, redCounter, greenCounter };

		Arrays.sort(resultsArray);
		int firstPlace = resultsArray[4];
		int secondPlace = resultsArray[3];
		int thirdPlace = resultsArray[2];
		int fourthPlace = resultsArray[1];
		int fifthPlace = resultsArray[0];

		// multicolor
		if (firstPlace == secondPlace && firstPlace == thirdPlace && firstPlace == fourthPlace
				&& firstPlace == fifthPlace) {
			mage += "a Multicolored Wonder. The Planes are at your fingertips";

			// monocolor
		} else if (whiteCounter == firstPlace && (firstPlace / 2) >= secondPlace) {
			mage += "Mono White Mage, peace be with you";
		} else if (blueCounter == firstPlace && (firstPlace / 2) >= secondPlace) {
			mage += "Mono Blue Mage, stay curoius";
		} else if (blackCounter == firstPlace && (firstPlace / 2) >= secondPlace) {
			mage += "Mono Black Mage, behold";
		} else if (redCounter == firstPlace && (firstPlace / 2) >= secondPlace) {
			mage += "Mono Red Mage, stay true";
		} else if (greenCounter == firstPlace && (firstPlace / 2) >= secondPlace) {
			mage += "Mono Green Mage, one with the world";

			// tricolor
		} else if ((blackCounter == firstPlace && redCounter == secondPlace && greenCounter == thirdPlace
				|| blackCounter == firstPlace && greenCounter == secondPlace && redCounter == thirdPlace
				|| redCounter == firstPlace && blackCounter == secondPlace && greenCounter == thirdPlace
				|| redCounter == firstPlace && greenCounter == secondPlace && blackCounter == thirdPlace
				|| greenCounter == firstPlace && blackCounter == secondPlace && redCounter == thirdPlace
				|| greenCounter == firstPlace && redCounter == secondPlace && blackCounter == thirdPlace)
				&& thirdPlace / 2 > fourthPlace || (secondPlace + (questionCounter / 2)) / 2 <= thirdPlace) {
			mage += " a Mage of Jund";
		} else if ((whiteCounter == firstPlace && blueCounter == secondPlace && greenCounter == thirdPlace
				|| whiteCounter == firstPlace && greenCounter == secondPlace && blueCounter == thirdPlace
				|| blueCounter == firstPlace && whiteCounter == secondPlace && greenCounter == thirdPlace
				|| blueCounter == firstPlace && greenCounter == secondPlace && whiteCounter == thirdPlace
				|| greenCounter == firstPlace && whiteCounter == secondPlace && blueCounter == thirdPlace
				|| greenCounter == firstPlace && blueCounter == secondPlace && whiteCounter == thirdPlace)
				&& thirdPlace / 2 > fourthPlace || (secondPlace + (questionCounter / 2)) / 2 <= thirdPlace) {
			mage += " a Mage of Bant";
		} else if ((blackCounter == firstPlace && redCounter == secondPlace && blueCounter == thirdPlace
				|| blackCounter == firstPlace && blueCounter == secondPlace && redCounter == thirdPlace
				|| redCounter == firstPlace && blackCounter == secondPlace && blueCounter == thirdPlace
				|| redCounter == firstPlace && blueCounter == secondPlace && blackCounter == thirdPlace
				|| blueCounter == firstPlace && blackCounter == secondPlace && redCounter == thirdPlace
				|| blueCounter == firstPlace && redCounter == secondPlace && blackCounter == thirdPlace)
				&& thirdPlace / 2 > fourthPlace || (secondPlace + (questionCounter / 2)) / 2 <= thirdPlace) {
			mage += " a Mage of Grixis";
		} else if ((whiteCounter == firstPlace && redCounter == secondPlace && greenCounter == thirdPlace
				|| whiteCounter == firstPlace && greenCounter == secondPlace && redCounter == thirdPlace
				|| redCounter == firstPlace && whiteCounter == secondPlace && greenCounter == thirdPlace
				|| redCounter == firstPlace && greenCounter == secondPlace && whiteCounter == thirdPlace
				|| greenCounter == firstPlace && whiteCounter == secondPlace && redCounter == thirdPlace
				|| greenCounter == firstPlace && redCounter == secondPlace && whiteCounter == thirdPlace)
				&& thirdPlace / 2 > fourthPlace || (secondPlace + (questionCounter / 2)) / 2 <= thirdPlace) {
			mage += " a Mage of Naya";
		} else if ((blackCounter == firstPlace && whiteCounter == secondPlace && blueCounter == thirdPlace
				|| blackCounter == firstPlace && blueCounter == secondPlace && whiteCounter == thirdPlace
				|| whiteCounter == firstPlace && blackCounter == secondPlace && blueCounter == thirdPlace
				|| whiteCounter == firstPlace && blueCounter == secondPlace && blackCounter == thirdPlace
				|| blueCounter == firstPlace && blackCounter == secondPlace && whiteCounter == thirdPlace
				|| blueCounter == firstPlace && whiteCounter == secondPlace && blackCounter == thirdPlace)
				&& thirdPlace / 2 > fourthPlace || (secondPlace + (questionCounter / 2)) / 2 <= thirdPlace) {
			mage += " a Mage of Esper";
		} else if ((redCounter == firstPlace && whiteCounter == secondPlace && blueCounter == thirdPlace
				|| redCounter == firstPlace && blueCounter == secondPlace && whiteCounter == thirdPlace
				|| whiteCounter == firstPlace && redCounter == secondPlace && blueCounter == thirdPlace
				|| whiteCounter == firstPlace && blueCounter == secondPlace && redCounter == thirdPlace
				|| blueCounter == firstPlace && redCounter == secondPlace && whiteCounter == thirdPlace
				|| blueCounter == firstPlace && whiteCounter == secondPlace && redCounter == thirdPlace)
				&& thirdPlace / 2 > fourthPlace || (secondPlace + (questionCounter / 2)) / 2 <= thirdPlace) {
			mage += " a Mage of Jeskai";
		} else if ((redCounter == firstPlace && whiteCounter == secondPlace && blackCounter == thirdPlace
				|| redCounter == firstPlace && blackCounter == secondPlace && whiteCounter == thirdPlace
				|| whiteCounter == firstPlace && redCounter == secondPlace && blackCounter == thirdPlace
				|| whiteCounter == firstPlace && blackCounter == secondPlace && redCounter == thirdPlace
				|| blackCounter == firstPlace && redCounter == secondPlace && whiteCounter == thirdPlace
				|| blackCounter == firstPlace && whiteCounter == secondPlace && redCounter == thirdPlace)
				&& thirdPlace / 2 > fourthPlace || (secondPlace + (questionCounter / 2)) / 2 <= thirdPlace) {
			mage += " a Mage of Mardu";
		} else if ((blackCounter == firstPlace && blueCounter == secondPlace && greenCounter == thirdPlace
				|| blackCounter == firstPlace && greenCounter == secondPlace && blueCounter == thirdPlace
				|| blueCounter == firstPlace && blackCounter == secondPlace && greenCounter == thirdPlace
				|| blueCounter == firstPlace && greenCounter == secondPlace && blackCounter == thirdPlace
				|| greenCounter == firstPlace && blackCounter == secondPlace && blueCounter == thirdPlace
				|| greenCounter == firstPlace && blueCounter == secondPlace && blackCounter == thirdPlace)
				&& thirdPlace / 2 > fourthPlace || (secondPlace + (questionCounter / 2)) / 2 <= thirdPlace) {
			mage += " a Mage of Bant";
		} else if ((blueCounter == firstPlace && redCounter == secondPlace && greenCounter == thirdPlace
				|| blueCounter == firstPlace && greenCounter == secondPlace && redCounter == thirdPlace
				|| redCounter == firstPlace && blueCounter == secondPlace && greenCounter == thirdPlace
				|| redCounter == firstPlace && greenCounter == secondPlace && blueCounter == thirdPlace
				|| greenCounter == firstPlace && blueCounter == secondPlace && redCounter == thirdPlace
				|| greenCounter == firstPlace && redCounter == secondPlace && blueCounter == thirdPlace)
				&& thirdPlace / 2 > fourthPlace || (secondPlace + (questionCounter / 2)) / 2 <= thirdPlace) {
			mage += " a Mage of Temur";
		} else if ((blackCounter == firstPlace && whiteCounter == secondPlace && greenCounter == thirdPlace
				|| blackCounter == firstPlace && greenCounter == secondPlace && whiteCounter == thirdPlace
				|| whiteCounter == firstPlace && blackCounter == secondPlace && greenCounter == thirdPlace
				|| whiteCounter == firstPlace && greenCounter == secondPlace && blackCounter == thirdPlace
				|| greenCounter == firstPlace && blackCounter == secondPlace && whiteCounter == thirdPlace
				|| greenCounter == firstPlace && whiteCounter == secondPlace && blackCounter == thirdPlace)
				&& thirdPlace / 2 > fourthPlace || (secondPlace + (questionCounter / 2)) / 2 <= thirdPlace) {
			mage += " a Mage of Azban";

			// guilds
		} else if (whiteCounter == firstPlace && blueCounter == secondPlace) {
			mage += "White/Blue Mage (Welcome to the Azorius Senate)";
		} else if (whiteCounter == firstPlace && blackCounter == secondPlace) {
			mage += "White/Black Mage (Welcome to the Orzhov Syndicate)";
		} else if (whiteCounter == firstPlace && redCounter == secondPlace) {
			mage += "White/Red Mage (Welcome to the Boros Legion)";
		} else if (whiteCounter == firstPlace && greenCounter == secondPlace) {
			mage += "White/Green Mage (Welcome to the Selesnya Conclave)";

		} else if (blueCounter == firstPlace && whiteCounter == secondPlace) {
			mage += "Blue/White Mage (Welcome to the Welcome to the Azorius Senate)";
		} else if (blueCounter == firstPlace && blackCounter == secondPlace) {
			mage += "Blue/Black Mage (Welcome to House Dimir)";
		} else if (blueCounter == firstPlace && redCounter == secondPlace) {
			mage += "Blue/Red Mage (Welcome to the Izzet League)";
		} else if (blueCounter == firstPlace && greenCounter == secondPlace) {
			mage += "Blue/Green Mage (Welcome to the Simic Combine)";

		} else if (blackCounter == firstPlace && whiteCounter == secondPlace) {
			mage += "Black/White Mage (Welcome to the Orzhov Syndicate)";
		} else if (blueCounter == firstPlace && blueCounter == secondPlace) {
			mage += "Black/Blue Mage (Welcome to House Dimir)";
		} else if (blackCounter == firstPlace && redCounter == secondPlace) {
			mage += "Black/red Mage (Welcome to the Cult of Rakdos)";
		} else if (blackCounter == firstPlace && greenCounter == secondPlace) {
			mage += "Black/Green Mage (Welcome to the Golgari Swarm)";

		} else if (redCounter == firstPlace && whiteCounter == secondPlace) {
			mage += "Red/White Mage (Welcome to the Boros Legion)";
		} else if (redCounter == firstPlace && blueCounter == secondPlace) {
			mage += "Red/Blue Mage (Welcome to the Izzet League)";
		} else if (redCounter == firstPlace && blackCounter == secondPlace) {
			mage += "Red/Black Mage (Welcome to the Cult of Rakdos)";
		} else if (redCounter == firstPlace && greenCounter == secondPlace) {
			mage += "Red/Gren Mage (Welcome to the Gruul Clans)";

		} else if (greenCounter == firstPlace && whiteCounter == secondPlace) {
			mage += "Green/White Mage (Welcome to the Selesnya Conclave)";
		} else if (greenCounter == firstPlace && blueCounter == secondPlace) {
			mage += "Green/Blue Mage (Welcome to the Simic Combine)";
		} else if (greenCounter == firstPlace && blackCounter == secondPlace) {
			mage += "Green/Black Mage (Welcome to the Golgari Swarm)";
		} else if (greenCounter == firstPlace && redCounter == secondPlace) {
			mage += "Green/Red Mage (Welcome to the Gruul Clans)";
		}

		String results = " <<Your scores are>> | White: " + whiteCounter + " | Blue: " + blueCounter + " | Black: "
				+ blackCounter + " | Red: " + redCounter + " | Green: " + greenCounter + " | <You answered " + questionCounter
				+ " questions>";

		return mage + results;
	}

}
