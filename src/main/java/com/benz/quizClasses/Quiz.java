package com.benz.quizClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Quiz {
	private Integer whiteCounter = 0;
	private Integer blueCounter = 0;
	private Integer blackCounter = 0;
	private Integer redCounter = 0;
	private Integer greenCounter = 0;


	public List<String> getColorQualities(Map<Integer, List> colorQuiz, int key, int i) {
		Randomizer randomKey = new Randomizer();
		List<String> lineArray = (List<String>) colorQuiz.get(key);
		return lineArray;
	}
//	public String getQuestion(Map<Integer, List> colorQuiz, List<String> lineArray, int i, int key) {
//		String question = (lineArray.get(i).substring(1));
//		lineArray.remove(i);
//		colorQuiz.remove(key);
//		if (lineArray.size() > 0) {
//			colorQuiz.put(key, lineArray);
//		}
//		return question;
//	}
	public String getQuestion(Map<Integer, List> colorQuiz, List<String> lineArray, int i, int key) {
		String question = (lineArray.get(i).substring(1));
		return question;
	}
	public void removeQuestion(Map<Integer, List> colorQuiz, List<String> lineArray, int i, int key) {
		lineArray.remove(i);
		colorQuiz.remove(key);
		if (lineArray.size() > 0) {
			colorQuiz.put(key, lineArray);
		}
	}

	public int getAnswer(Scanner answerReader, Map<Integer, List<String>> colorQuiz, String colorTypeKey) {
		String answerAsString = answerReader.nextLine();
		try {
			int answer = Integer.parseInt(answerAsString);
			return answer;
		} catch (NumberFormatException e) {
			return -1;
		}
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

	public List<String> printMageResult() {
		List<String> mage = new ArrayList<>();

		int resultsArray[] = { whiteCounter, blueCounter, blackCounter, redCounter, greenCounter };

		Arrays.sort(resultsArray);
		int firstPlace = resultsArray[4];
		int secondPlace = resultsArray[3];
		int thirdPlace = resultsArray[2];
		int fourthPlace = resultsArray[1];
		int fifthPlace = resultsArray[0];

		// multicolor
		if (firstPlace *.9 <= secondPlace && firstPlace *.9 <= thirdPlace && firstPlace *.9 <= fourthPlace) {
			mage.add("You are a Multicolored Wonder. The Planes are at your fingertips");
			mage.add("There is no holding you back. You are intertwined with all of the facets of life and, when given the chance, use them to your full advantage.");
			mage.add("https://www.lesserwrong.com/posts/KbaJsfBtdpGv7EKbC/the-mtg-color-wheel");
			
			// monocolor
		} else if (whiteCounter == firstPlace && (firstPlace *.72) > secondPlace) {
			mage.add("You are a Mono White Mage, all for one one for all.");
			mage.add("White wants peace.");
			mage.add("A White Mage, when presented with a decision or quandary, asks what is the right course of action to take, where \"right\" depends on their moral or cultural framework.");
			mage.add("White wants to create a world where there is no unnecessary suffering, a world where life is as good as it can be for each individual. The key to making this happen is teaching individuals the importance of taking actions which benefit the group as a whole, even if those actions might not benefit them personally.");
			mage.add("White does want as many as possible to understand its motives and share them. But white realizes that in order to accomplish its larger goal, some individuals will have to be lead down the path rather than venture there of their own accord.");
			mage.add("https://magic.wizards.com/en/articles/archive/making-magic/great-white-way-revisited-2015-07-13");
		} else if (blueCounter == firstPlace && (firstPlace *.72) > secondPlace) {
			mage.add("You are a Mono Blue Mage, stay curoius.");
			mage.add("Blue wants perfection");
			mage.add("A Blue Mage, when presented with a decision or quandary, asks what course of action makes the most sense, where \"sense\" is determined by careful thought and the application of knowledge and expertise.");
			mage.add("Blue believes that each and every one of us is born a blank slate with the potential to become anything. The entire point of life is figuring out what you could achieve with the right education, experience, and tools. Note that this is not a task with an end goal, but one that continues throughout your life. There will always be things you can do to improve, change, or adapt. The journey of life is one of constant discovery as you keep seeking to better yourself.");
			mage.add("Much as blue wishes to perfect itself, it also wants to perfect the world it lives in. Part of this is to ensure that blue has access to the resources it needs, but part of it is the belief that an element of reaching one's potential is living within a world that has reached its own potential. As such, blue is the color most interested in technology and wants the latest and greatest version of whatever it is using.");
			mage.add("https://magic.wizards.com/en/articles/archive/making-magic/true-blue-revisited-2015-07-20");
		} else if (blackCounter == firstPlace && (firstPlace *.72) > secondPlace) {
			mage.add("You are a Mono Black Mage, be uninhibited.");
			mage.add("Black wants power.");
			mage.add("A Black Mage, when presented with a decision or quandary, asks what course of action will leave me best off, where \"best off\" includes having power, influence, safety, and wealth, as well as having moved closer to one's goals.");
			mage.add("Black believes it is the only realist, the only color to look and see the world as it is. An individual is free to have whatever they want, provided they have the power to obtain and keep it. This makes power the most important resource, because it's the one thing that can guarantee your ability to control your life and thus your happiness.");
			mage.add("Black's philosophy is very simple: There's no one better suited to look after your own interests than you. Therefore, if everyone looks out after their own interests, you've created a system where everyone has someone looking out for them. In addition, black's system allows everyone the opportunity to succeed. Will everyone succeed? Of course not—but once again, that's not black's doing. That's just how the world works.");
			mage.add("https://magic.wizards.com/en/articles/archive/making-magic/black-revisited-2015-07-27");
		} else if (redCounter == firstPlace && (firstPlace *.72) > secondPlace) {
			mage.add("You are a Mono Red Mage, stay true to yourself.");
			mage.add("Red wants freedom.");
			mage.add("A Red Mage, when presented with a decision or quandary, asks what do I feel like doing?");
			mage.add("Everyone seems preoccupied with the meaning of life. Red's not, because red already knows the answer. You see, your heart tells you what it needs in order to be fulfilled. All you have to do is listen to it and act accordingly. It's not a mystery. You are literally bombarded with constant feelings that guide you down the correct path. The problem is all the other colors ignore the message.");
			mage.add("To outsiders, red might seem a bit chaotic; but that's only because others can't see what's in red's heart. They cannot feel red's emotions guiding them. Living life to its fullest takes a lot of dedication and perseverance, but red is always up to the task.");
			mage.add("https://magic.wizards.com/en/articles/archive/making-magic/seeing-red-revisited-2015-08-03");
		} else if (greenCounter == firstPlace && (firstPlace *.72) > secondPlace) {
			mage.add("You are a Mono Green Mage, one with the world.");
			mage.add("Green wants harmony.");
			mage.add("A Green Mage, when presented with a decision or quandary, asks how are these things usually done? What is the established wisdom?");
			mage.add("The other colors are all focused on how they'd change the world to make it better. Green is the one color that doesn't want to change the world, because green is convinced that the world already got everything right. The natural order is a thing of beauty and has all the answers to life's problems. The key is learning to sit back and recognize what is right in front of you.");
			mage.add("Each individual is born with all the potential they need. The secret to a happy life is to recognize the role you were born into and then embrace it. Do what you were destined to do. The world is this elaborate system, and each one of us gets to play a part. And it's not something we have to guess about; it's imprinted on us, it's in our genes. Just look within.");
			mage.add("https://magic.wizards.com/en/articles/archive/making-magic/its-not-easy-being-green-revisited-2015-08-10");
			// tricolor
		} else if ((blackCounter == firstPlace && redCounter == secondPlace && greenCounter == thirdPlace
				|| blackCounter == firstPlace && greenCounter == secondPlace && redCounter == thirdPlace
				|| redCounter == firstPlace && blackCounter == secondPlace && greenCounter == thirdPlace
				|| redCounter == firstPlace && greenCounter == secondPlace && blackCounter == thirdPlace
				|| greenCounter == firstPlace && blackCounter == secondPlace && redCounter == thirdPlace
				|| greenCounter == firstPlace && redCounter == secondPlace && blackCounter == thirdPlace)
				&& (secondPlace *.89) <= thirdPlace) {
			mage.add("You are a Mage of The Jund Shard.");
			mage.add("Jund is a combination of the Red, Green and Black colors.");
			mage.add("Red wants freedom.");
			mage.add("Everyone seems preoccupied with the meaning of life. Red's not, because red already knows the answer. You see, your heart tells you what it needs in order to be fulfilled. All you have to do is listen to it and act accordingly. It's not a mystery. You are literally bombarded with constant feelings that guide you down the correct path. The problem is all the other colors ignore the message.");
			mage.add("Green wants harmony.");
			mage.add("The other colors are all focused on how they'd change the world to make it better. Green is the one color that doesn't want to change the world, because green is convinced that the world already got everything right. The natural order is a thing of beauty and has all the answers to life's problems. The key is learning to sit back and recognize what is right in front of you.");
			mage.add("Black wants power.");
			mage.add("Black believes it is the only realist, the only color to look and see the world as it is. An individual is free to have whatever they want, provided they have the power to obtain and keep it. This makes power the most important resource, because it's the one thing that can guarantee your ability to control your life and thus your happiness.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/108917215108/color-pie-friday-the-philosophies-of");
		} else if ((whiteCounter == firstPlace && blueCounter == secondPlace && greenCounter == thirdPlace
				|| whiteCounter == firstPlace && greenCounter == secondPlace && blueCounter == thirdPlace
				|| blueCounter == firstPlace && whiteCounter == secondPlace && greenCounter == thirdPlace
				|| blueCounter == firstPlace && greenCounter == secondPlace && whiteCounter == thirdPlace
				|| greenCounter == firstPlace && whiteCounter == secondPlace && blueCounter == thirdPlace
				|| greenCounter == firstPlace && blueCounter == secondPlace && whiteCounter == thirdPlace)
				&& (secondPlace *.89) <= thirdPlace) {
			mage.add("You are a Mage of The Bant Shard.");
			mage.add("Bant is a combination of the White, Green, and Blue colors.");
			mage.add("White wants peace.");
			mage.add("White wants to create a world where there is no unnecessary suffering, a world where life is as good as it can be for each individual. The key to making this happen is teaching individuals the importance of taking actions which benefit the group as a whole, even if those actions might not benefit them personally.");
			mage.add("Green wants harmony.");
			mage.add("The other colors are all focused on how they'd change the world to make it better. Green is the one color that doesn't want to change the world, because green is convinced that the world already got everything right. The natural order is a thing of beauty and has all the answers to life's problems. The key is learning to sit back and recognize what is right in front of you.");
			mage.add("Blue wants perfection");
			mage.add("Blue believes that each and every one of us is born a blank slate with the potential to become anything. The entire point of life is figuring out what you could achieve with the right education, experience, and tools. Note that this is not a task with an end goal, but one that continues throughout your life. There will always be things you can do to improve, change, or adapt. The journey of life is one of constant discovery as you keep seeking to better yourself.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/106906015782/color-pie-friday-the-philosophies-of");
		} else if ((blackCounter == firstPlace && redCounter == secondPlace && blueCounter == thirdPlace
				|| blackCounter == firstPlace && blueCounter == secondPlace && redCounter == thirdPlace
				|| redCounter == firstPlace && blackCounter == secondPlace && blueCounter == thirdPlace
				|| redCounter == firstPlace && blueCounter == secondPlace && blackCounter == thirdPlace
				|| blueCounter == firstPlace && blackCounter == secondPlace && redCounter == thirdPlace
				|| blueCounter == firstPlace && redCounter == secondPlace && blackCounter == thirdPlace)
				&& (secondPlace *.89) <= thirdPlace) {
			mage.add("You are a Mage of The Grixis Shard");
			mage.add("Grixis is a combination of Black, Blue, and Red.");
			mage.add("Black wants power.");
			mage.add("Black believes it is the only realist, the only color to look and see the world as it is. An individual is free to have whatever they want, provided they have the power to obtain and keep it. This makes power the most important resource, because it's the one thing that can guarantee your ability to control your life and thus your happiness.");
			mage.add("Blue wants perfection");
			mage.add("Blue believes that each and every one of us is born a blank slate with the potential to become anything. The entire point of life is figuring out what you could achieve with the right education, experience, and tools. Note that this is not a task with an end goal, but one that continues throughout your life. There will always be things you can do to improve, change, or adapt. The journey of life is one of constant discovery as you keep seeking to better yourself.");
			mage.add("Red wants freedom.");
			mage.add("Everyone seems preoccupied with the meaning of life. Red's not, because red already knows the answer. You see, your heart tells you what it needs in order to be fulfilled. All you have to do is listen to it and act accordingly. It's not a mystery. You are literally bombarded with constant feelings that guide you down the correct path. The problem is all the other colors ignore the message.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/108258878851/color-pie-friday-the-philosophies-of");
		} else if ((whiteCounter == firstPlace && redCounter == secondPlace && greenCounter == thirdPlace
				|| whiteCounter == firstPlace && greenCounter == secondPlace && redCounter == thirdPlace
				|| redCounter == firstPlace && whiteCounter == secondPlace && greenCounter == thirdPlace
				|| redCounter == firstPlace && greenCounter == secondPlace && whiteCounter == thirdPlace
				|| greenCounter == firstPlace && whiteCounter == secondPlace && redCounter == thirdPlace
				|| greenCounter == firstPlace && redCounter == secondPlace && whiteCounter == thirdPlace)
				&& (secondPlace *.89) <= thirdPlace) {
			mage.add("You are a Mage of The Naya Shard.");
			mage.add("Naya is a combination of Green, White, and Red.");
			mage.add("Green wants harmony.");
			mage.add("The other colors are all focused on how they'd change the world to make it better. Green is the one color that doesn't want to change the world, because green is convinced that the world already got everything right. The natural order is a thing of beauty and has all the answers to life's problems. The key is learning to sit back and recognize what is right in front of you.");
			mage.add("White wants peace.");
			mage.add("White wants to create a world where there is no unnecessary suffering, a world where life is as good as it can be for each individual. The key to making this happen is teaching individuals the importance of taking actions which benefit the group as a whole, even if those actions might not benefit them personally.");
			mage.add("Red wants freedom.");
			mage.add("Everyone seems preoccupied with the meaning of life. Red's not, because red already knows the answer. You see, your heart tells you what it needs in order to be fulfilled. All you have to do is listen to it and act accordingly. It's not a mystery. You are literally bombarded with constant feelings that guide you down the correct path. The problem is all the other colors ignore the message.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/109581932013/color-pie-friday-the-philosophies-of");
		} else if ((blackCounter == firstPlace && whiteCounter == secondPlace && blueCounter == thirdPlace
				|| blackCounter == firstPlace && blueCounter == secondPlace && whiteCounter == thirdPlace
				|| whiteCounter == firstPlace && blackCounter == secondPlace && blueCounter == thirdPlace
				|| whiteCounter == firstPlace && blueCounter == secondPlace && blackCounter == thirdPlace
				|| blueCounter == firstPlace && blackCounter == secondPlace && whiteCounter == thirdPlace
				|| blueCounter == firstPlace && whiteCounter == secondPlace && blackCounter == thirdPlace)
				&& (secondPlace *.89) <= thirdPlace) {
			mage.add("You are a Mage of The Esper Shard.");
			mage.add("Esper is a combination of Blue, Black, and White.");
			mage.add("Blue wants perfection");
			mage.add("Blue believes that each and every one of us is born a blank slate with the potential to become anything. The entire point of life is figuring out what you could achieve with the right education, experience, and tools. Note that this is not a task with an end goal, but one that continues throughout your life. There will always be things you can do to improve, change, or adapt. The journey of life is one of constant discovery as you keep seeking to better yourself.");
			mage.add("Black wants power.");
			mage.add("Black believes it is the only realist, the only color to look and see the world as it is. An individual is free to have whatever they want, provided they have the power to obtain and keep it. This makes power the most important resource, because it's the one thing that can guarantee your ability to control your life and thus your happiness.");
			mage.add("White wants peace.");
			mage.add("White wants to create a world where there is no unnecessary suffering, a world where life is as good as it can be for each individual. The key to making this happen is teaching individuals the importance of taking actions which benefit the group as a whole, even if those actions might not benefit them personally.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/107598843293/color-pie-friday-the-philosophies-of");
		} else if ((redCounter == firstPlace && whiteCounter == secondPlace && blueCounter == thirdPlace
				|| redCounter == firstPlace && blueCounter == secondPlace && whiteCounter == thirdPlace
				|| whiteCounter == firstPlace && redCounter == secondPlace && blueCounter == thirdPlace
				|| whiteCounter == firstPlace && blueCounter == secondPlace && redCounter == thirdPlace
				|| blueCounter == firstPlace && redCounter == secondPlace && whiteCounter == thirdPlace
				|| blueCounter == firstPlace && whiteCounter == secondPlace && redCounter == thirdPlace)
				&& (secondPlace *.89) <= thirdPlace) {
			mage.add("You are a Mage of The Jeskai Way");
			mage.add("Jeskai is a combination of Blue, Red, and White.");
			mage.add("Blue wants perfection");
			mage.add("Blue believes that each and every one of us is born a blank slate with the potential to become anything. The entire point of life is figuring out what you could achieve with the right education, experience, and tools. Note that this is not a task with an end goal, but one that continues throughout your life. There will always be things you can do to improve, change, or adapt. The journey of life is one of constant discovery as you keep seeking to better yourself.");
			mage.add("Red wants freedom.");
			mage.add("Everyone seems preoccupied with the meaning of life. Red's not, because red already knows the answer. You see, your heart tells you what it needs in order to be fulfilled. All you have to do is listen to it and act accordingly. It's not a mystery. You are literally bombarded with constant feelings that guide you down the correct path. The problem is all the other colors ignore the message.");
			mage.add("White wants peace.");
			mage.add("White wants to create a world where there is no unnecessary suffering, a world where life is as good as it can be for each individual. The key to making this happen is teaching individuals the importance of taking actions which benefit the group as a whole, even if those actions might not benefit them personally.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/116027609956/color-pie-friday-the-philosophies-of");
		} else if ((redCounter == firstPlace && whiteCounter == secondPlace && blackCounter == thirdPlace
				|| redCounter == firstPlace && blackCounter == secondPlace && whiteCounter == thirdPlace
				|| whiteCounter == firstPlace && redCounter == secondPlace && blackCounter == thirdPlace
				|| whiteCounter == firstPlace && blackCounter == secondPlace && redCounter == thirdPlace
				|| blackCounter == firstPlace && redCounter == secondPlace && whiteCounter == thirdPlace
				|| blackCounter == firstPlace && whiteCounter == secondPlace && redCounter == thirdPlace)
				&& (secondPlace *.89) <= thirdPlace) {
			mage.add("You are a Mage of The Mardu Horde.");
			mage.add("Mardu is a combination of Red, White, and Black.");
			mage.add("Red wants freedom.");
			mage.add("Everyone seems preoccupied with the meaning of life. Red's not, because red already knows the answer. You see, your heart tells you what it needs in order to be fulfilled. All you have to do is listen to it and act accordingly. It's not a mystery. You are literally bombarded with constant feelings that guide you down the correct path. The problem is all the other colors ignore the message.");
			mage.add("White wants peace.");
			mage.add("White wants to create a world where there is no unnecessary suffering, a world where life is as good as it can be for each individual. The key to making this happen is teaching individuals the importance of taking actions which benefit the group as a whole, even if those actions might not benefit them personally.");
			mage.add("Black wants power.");
			mage.add("Black believes it is the only realist, the only color to look and see the world as it is. An individual is free to have whatever they want, provided they have the power to obtain and keep it. This makes power the most important resource, because it's the one thing that can guarantee your ability to control your life and thus your happiness.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/114130029894/color-pie-friday-the-philosophies-of");
		} else if ((blackCounter == firstPlace && blueCounter == secondPlace && greenCounter == thirdPlace
				|| blackCounter == firstPlace && greenCounter == secondPlace && blueCounter == thirdPlace
				|| blueCounter == firstPlace && blackCounter == secondPlace && greenCounter == thirdPlace
				|| blueCounter == firstPlace && greenCounter == secondPlace && blackCounter == thirdPlace
				|| greenCounter == firstPlace && blackCounter == secondPlace && blueCounter == thirdPlace
				|| greenCounter == firstPlace && blueCounter == secondPlace && blackCounter == thirdPlace)
				&& (secondPlace *.89) <= thirdPlace) {
			mage.add("You are a Mage of The Sultai Brood.");
			mage.add("Sultai is a combination of Black, Blue and Green.");
			mage.add("Black wants power.");
			mage.add("Black believes it is the only realist, the only color to look and see the world as it is. An individual is free to have whatever they want, provided they have the power to obtain and keep it. This makes power the most important resource, because it's the one thing that can guarantee your ability to control your life and thus your happiness.");
			mage.add("Blue wants perfection");
			mage.add("Blue believes that each and every one of us is born a blank slate with the potential to become anything. The entire point of life is figuring out what you could achieve with the right education, experience, and tools. Note that this is not a task with an end goal, but one that continues throughout your life. There will always be things you can do to improve, change, or adapt. The journey of life is one of constant discovery as you keep seeking to better yourself.");
			mage.add("Green wants harmony.");
			mage.add("The other colors are all focused on how they'd change the world to make it better. Green is the one color that doesn't want to change the world, because green is convinced that the world already got everything right. The natural order is a thing of beauty and has all the answers to life's problems. The key is learning to sit back and recognize what is right in front of you.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/116642252104/color-pie-friday-the-philosophies-of");
		} else if ((blueCounter == firstPlace && redCounter == secondPlace && greenCounter == thirdPlace
				|| blueCounter == firstPlace && greenCounter == secondPlace && redCounter == thirdPlace
				|| redCounter == firstPlace && blueCounter == secondPlace && greenCounter == thirdPlace
				|| redCounter == firstPlace && greenCounter == secondPlace && blueCounter == thirdPlace
				|| greenCounter == firstPlace && blueCounter == secondPlace && redCounter == thirdPlace
				|| greenCounter == firstPlace && redCounter == secondPlace && blueCounter == thirdPlace)
				&& (secondPlace *.89) <= thirdPlace) {
			mage.add("You are a Mage of The Temur Frontier.");
			mage.add("Temur is a combination of Green, Red, and Blue.");
			mage.add("Green wants harmony.");
			mage.add("The other colors are all focused on how they'd change the world to make it better. Green is the one color that doesn't want to change the world, because green is convinced that the world already got everything right. The natural order is a thing of beauty and has all the answers to life's problems. The key is learning to sit back and recognize what is right in front of you.");
			mage.add("Red wants freedom.");
			mage.add("Everyone seems preoccupied with the meaning of life. Red's not, because red already knows the answer. You see, your heart tells you what it needs in order to be fulfilled. All you have to do is listen to it and act accordingly. It's not a mystery. You are literally bombarded with constant feelings that guide you down the correct path. The problem is all the other colors ignore the message.");
			mage.add("Blue wants perfection");
			mage.add("Blue believes that each and every one of us is born a blank slate with the potential to become anything. The entire point of life is figuring out what you could achieve with the right education, experience, and tools. Note that this is not a task with an end goal, but one that continues throughout your life. There will always be things you can do to improve, change, or adapt. The journey of life is one of constant discovery as you keep seeking to better yourself.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/114754805201/color-pie-friday-the-philosophies-of");
		} else if ((blackCounter == firstPlace && whiteCounter == secondPlace && greenCounter == thirdPlace
				|| blackCounter == firstPlace && greenCounter == secondPlace && whiteCounter == thirdPlace
				|| whiteCounter == firstPlace && blackCounter == secondPlace && greenCounter == thirdPlace
				|| whiteCounter == firstPlace && greenCounter == secondPlace && blackCounter == thirdPlace
				|| greenCounter == firstPlace && blackCounter == secondPlace && whiteCounter == thirdPlace
				|| greenCounter == firstPlace && whiteCounter == secondPlace && blackCounter == thirdPlace)
				&& (secondPlace *.89) <= thirdPlace) {
			mage.add("You are a Mage of The Azban Houses.");
			mage.add("Azban is a combination of White, Green, and Black");
			mage.add("White wants peace.");
			mage.add("White wants to create a world where there is no unnecessary suffering, a world where life is as good as it can be for each individual. The key to making this happen is teaching individuals the importance of taking actions which benefit the group as a whole, even if those actions might not benefit them personally.");
			mage.add("Green wants harmony.");
			mage.add("The other colors are all focused on how they'd change the world to make it better. Green is the one color that doesn't want to change the world, because green is convinced that the world already got everything right. The natural order is a thing of beauty and has all the answers to life's problems. The key is learning to sit back and recognize what is right in front of you.");
			mage.add("Black wants power.");
			mage.add("Black believes it is the only realist, the only color to look and see the world as it is. An individual is free to have whatever they want, provided they have the power to obtain and keep it. This makes power the most important resource, because it's the one thing that can guarantee your ability to control your life and thus your happiness.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/115386845739/color-pie-friday-the-philosophies-of");
			
			
			
			
			// guilds
		} else if (whiteCounter == firstPlace && blueCounter == secondPlace) {
			mage.add("You are a White/Blue Mage (Welcome to the Azorius Senate).");
			mage.add("A White/Blue Mage asks the question how do we know what's right and good? The whole concept of a \"rationality technique\" is extremely white/blue—the idea that we might create carefully defined, algorithmic heuristics for doing things better according to some outside standard is not one that other color combinations are likely to produce. Effective Altruism is also a white/blue movement, though it makes efforts to reach out to red (compassion) and black (taking the long view on self-interest)");
			mage.add("White wants peace.");
			mage.add("White wants to create a world where there is no unnecessary suffering, a world where life is as good as it can be for each individual. The key to making this happen is teaching individuals the importance of taking actions which benefit the group as a whole, even if those actions might not benefit them personally.");
			mage.add("White does want as many as possible to understand its motives and share them. But white realizes that in order to accomplish its larger goal, some individuals will have to be lead down the path rather than venture there of their own accord.");
			mage.add("Blue wants perfection");
			mage.add("Blue believes that each and every one of us is born a blank slate with the potential to become anything. The entire point of life is figuring out what you could achieve with the right education, experience, and tools. Note that this is not a task with an end goal, but one that continues throughout your life. There will always be things you can do to improve, change, or adapt. The journey of life is one of constant discovery as you keep seeking to better yourself.");
			mage.add("Much as blue wishes to perfect itself, it also wants to perfect the world it lives in. Part of this is to ensure that blue has access to the resources it needs, but part of it is the belief that an element of reaching one's potential is living within a world that has reached its own potential. As such, blue is the color most interested in technology and wants the latest and greatest version of whatever it is using.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/97300998181/color-pie-friday-the-philosophy-of-whiteblue");
			
		} else if (whiteCounter == firstPlace && blackCounter == secondPlace) {
			mage.add("You are a White/Black Mage (Welcome to the Orzhov Syndicate).");
			mage.add("A White/Black Mage asks the question who's in my circle of concern? The colors White and Black combine to form tribalism—the \"us versus them\" mentality. Think Don Corleone and the other gangsters from The Godfather—a strict system of codes and honor within the group, and almost total impunity with outsiders. You can also see the white/black ingroup-outgroup dynamic in certain swaths of social justice culture.");
			mage.add("White wants peace.");
			mage.add("White wants to create a world where there is no unnecessary suffering, a world where life is as good as it can be for each individual. The key to making this happen is teaching individuals the importance of taking actions which benefit the group as a whole, even if those actions might not benefit them personally.");
			mage.add("White does want as many as possible to understand its motives and share them. But white realizes that in order to accomplish its larger goal, some individuals will have to be lead down the path rather than venture there of their own accord.");	
			mage.add("Black wants power.");
			mage.add("Black believes it is the only realist, the only color to look and see the world as it is. An individual is free to have whatever they want, provided they have the power to obtain and keep it. This makes power the most important resource, because it's the one thing that can guarantee your ability to control your life and thus your happiness.");
			mage.add("Black's philosophy is very simple: There's no one better suited to look after your own interests than you. Therefore, if everyone looks out after their own interests, you've created a system where everyone has someone looking out for them. In addition, black's system allows everyone the opportunity to succeed. Will everyone succeed? Of course not—but once again, that's not black's doing. That's just how the world works.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/100239449499/color-pie-friday-the-philosophy-of-whiteblack");
			
		} else if (whiteCounter == firstPlace && redCounter == secondPlace) {
			mage.add("You are a White/Red Mage (Welcome to the Boros Legion).");
			mage.add("A White/Red Mage asks the question what needs to be done? What would a good person do? red and white are the colors of heroism—of passion channeled through morality, and adherence to laws that may be higher than law. The best of warriors, soldiers, and vigilantes is red/white, as are heroes and martyrs. Examples include Daredevil, Robin Hood, and the Weasley twins from Harry Potter (Gryffindor is a red/white House), as well as V from V for Vendetta and Prince Zuko from Avatar: The Last Airbender (at least, near the end of their arcs).");
			mage.add("White wants peace.");
			mage.add("White wants to create a world where there is no unnecessary suffering, a world where life is as good as it can be for each individual. The key to making this happen is teaching individuals the importance of taking actions which benefit the group as a whole, even if those actions might not benefit them personally.");
			mage.add("White does want as many as possible to understand its motives and share them. But white realizes that in order to accomplish its larger goal, some individuals will have to be lead down the path rather than venture there of their own accord.");	
			mage.add("Red wants freedom.");
			mage.add("Everyone seems preoccupied with the meaning of life. Red's not, because red already knows the answer. You see, your heart tells you what it needs in order to be fulfilled. All you have to do is listen to it and act accordingly. It's not a mystery. You are literally bombarded with constant feelings that guide you down the correct path. The problem is all the other colors ignore the message.");
			mage.add("To outsiders, red might seem a bit chaotic; but that's only because others can't see what's in red's heart. They cannot feel red's emotions guiding them. Living life to its fullest takes a lot of dedication and perseverance, but red is always up to the task.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/102010667888/color-pie-friday-the-philosophy-of-redwhite");
			
		} else if (whiteCounter == firstPlace && greenCounter == secondPlace) {
			mage.add("You are a White/Green Mage (Welcome to the Selesnya Conclave).");
			mage.add("A White/Green Mage asks the question what's fair and good? They both agree on community—on the sense that the whole can be greater than the sum of its parts, and that there are things larger than oneself that are worth sacrificing for. Green/white institutions tend to be centered around compassionate endeavors, but if they go astray it's in the direction of well-meaning lost purposes and wasted signaling (a lack of blue's epistemic hygiene) rather than in the direction of cold, heartless efficiency or relentless pursuit of knowledge or the bottom line. They include institutions like the YMCA, Habitat for Humanity, Teach for America, and most small-town churches—basically any organization whose primary purpose is to foster the web of connection between people and to maintain the society's culture.");
			mage.add("White wants peace.");
			mage.add("White wants to create a world where there is no unnecessary suffering, a world where life is as good as it can be for each individual. The key to making this happen is teaching individuals the importance of taking actions which benefit the group as a whole, even if those actions might not benefit them personally.");
			mage.add("White does want as many as possible to understand its motives and share them. But white realizes that in order to accomplish its larger goal, some individuals will have to be lead down the path rather than venture there of their own accord.");
			mage.add("Green wants harmony.");
			mage.add("The other colors are all focused on how they'd change the world to make it better. Green is the one color that doesn't want to change the world, because green is convinced that the world already got everything right. The natural order is a thing of beauty and has all the answers to life's problems. The key is learning to sit back and recognize what is right in front of you.");
			mage.add("Each individual is born with all the potential they need. The secret to a happy life is to recognize the role you were born into and then embrace it. Do what you were destined to do. The world is this elaborate system, and each one of us gets to play a part. And it's not something we have to guess about; it's imprinted on us, it's in our genes. Just look within.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/99645143496/color-pie-friday-the-philosophy-of-greenwhite");
			
		} else if (blueCounter == firstPlace && whiteCounter == secondPlace) {
			mage.add("You are a Blue/White Mage (Welcome to the Azorius Senate).");
			mage.add("A Blue/White Mage asks the question how do we know what's right and good? The whole concept of a \"rationality technique\" is extremely white/blue—the idea that we might create carefully defined, algorithmic heuristics for doing things better according to some outside standard is not one that other color combinations are likely to produce. Effective Altruism is also a white/blue movement, though it makes efforts to reach out to red (compassion) and black (taking the long view on self-interest)");
			mage.add("Blue wants perfection");
			mage.add("Blue believes that each and every one of us is born a blank slate with the potential to become anything. The entire point of life is figuring out what you could achieve with the right education, experience, and tools. Note that this is not a task with an end goal, but one that continues throughout your life. There will always be things you can do to improve, change, or adapt. The journey of life is one of constant discovery as you keep seeking to better yourself.");
			mage.add("Much as blue wishes to perfect itself, it also wants to perfect the world it lives in. Part of this is to ensure that blue has access to the resources it needs, but part of it is the belief that an element of reaching one's potential is living within a world that has reached its own potential. As such, blue is the color most interested in technology and wants the latest and greatest version of whatever it is using.");
			mage.add("White wants peace.");
			mage.add("White wants to create a world where there is no unnecessary suffering, a world where life is as good as it can be for each individual. The key to making this happen is teaching individuals the importance of taking actions which benefit the group as a whole, even if those actions might not benefit them personally.");
			mage.add("White does want as many as possible to understand its motives and share them. But white realizes that in order to accomplish its larger goal, some individuals will have to be lead down the path rather than venture there of their own accord.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/97300998181/color-pie-friday-the-philosophy-of-whiteblue");
			
		} else if (blueCounter == firstPlace && blackCounter == secondPlace) {
			mage.add("You are a Blue/Black Mage (Welcome to House Dimir).");
			mage.add("A Blue/Black Mage asks the question how can I best achieve my goals? It's fair to describe blue/black as the combination of \"enlightened self-interest\". Blue and black both agree on growth mindset, the idea that one is not defined by one's origins or constrained to the role society has set. Blue/black characters are often intelligent, clever, arrogant, and aloof. Notable examples include Odysseus from The Odyssey, Sherlock Holmes, and Lex Luthor. Transhumanism is a fundamentally blue-black worldview, in opposition to the imperative to accept death as a crucial and inevitable part of life.");
			mage.add("Blue wants perfection");
			mage.add("Blue believes that each and every one of us is born a blank slate with the potential to become anything. The entire point of life is figuring out what you could achieve with the right education, experience, and tools. Note that this is not a task with an end goal, but one that continues throughout your life. There will always be things you can do to improve, change, or adapt. The journey of life is one of constant discovery as you keep seeking to better yourself.");
			mage.add("Much as blue wishes to perfect itself, it also wants to perfect the world it lives in. Part of this is to ensure that blue has access to the resources it needs, but part of it is the belief that an element of reaching one's potential is living within a world that has reached its own potential. As such, blue is the color most interested in technology and wants the latest and greatest version of whatever it is using.");
			mage.add("Black wants power.");
			mage.add("Black believes it is the only realist, the only color to look and see the world as it is. An individual is free to have whatever they want, provided they have the power to obtain and keep it. This makes power the most important resource, because it's the one thing that can guarantee your ability to control your life and thus your happiness.");
			mage.add("Black's philosophy is very simple: There's no one better suited to look after your own interests than you. Therefore, if everyone looks out after their own interests, you've created a system where everyone has someone looking out for them. In addition, black's system allows everyone the opportunity to succeed. Will everyone succeed? Of course not—but once again, that's not black's doing. That's just how the world works.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/97887622155/color-pie-friday-the-philosophy-of-blueblack");
			
		} else if (blueCounter == firstPlace && redCounter == secondPlace) {
			mage.add("You are a Blue/Red Mage (Welcome to the Izzet League).");
			mage.add("A Blue/Red Mage asks the question what can be achieved? What might be possible? Blue and red taken together are the colors of creativity. Passion combined with perfection, freedom combined with investigation—blue/red is the pairing that most typifies wild artistry and mad science. Elon Musk's endeavors are one of our strongest examples of blue/red mentality in today's society. Tony Stark from Iron Man started out blue/black, he ended up blue/red. Willy Wonka is also a blue/red archetype, as are Doc Brown from Back to the Future and Indiana Jones.");
			mage.add("Blue wants perfection");
			mage.add("Blue believes that each and every one of us is born a blank slate with the potential to become anything. The entire point of life is figuring out what you could achieve with the right education, experience, and tools. Note that this is not a task with an end goal, but one that continues throughout your life. There will always be things you can do to improve, change, or adapt. The journey of life is one of constant discovery as you keep seeking to better yourself.");
			mage.add("Much as blue wishes to perfect itself, it also wants to perfect the world it lives in. Part of this is to ensure that blue has access to the resources it needs, but part of it is the belief that an element of reaching one's potential is living within a world that has reached its own potential. As such, blue is the color most interested in technology and wants the latest and greatest version of whatever it is using.");
			mage.add("Red wants freedom.");
			mage.add("Everyone seems preoccupied with the meaning of life. Red's not, because red already knows the answer. You see, your heart tells you what it needs in order to be fulfilled. All you have to do is listen to it and act accordingly. It's not a mystery. You are literally bombarded with constant feelings that guide you down the correct path. The problem is all the other colors ignore the message.");
			mage.add("To outsiders, red might seem a bit chaotic; but that's only because others can't see what's in red's heart. They cannot feel red's emotions guiding them. Living life to its fullest takes a lot of dedication and perseverance, but red is always up to the task.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/100829012113/color-pie-friday-the-philosophy-of-bluered");
			
		} else if (blueCounter == firstPlace && greenCounter == secondPlace) {
			mage.add("You are a Blue/Green Mage (Welcome to the Simic Combine).");
			mage.add("A Blue/Green Mage asks the question what do I not yet understand? Blue/Green is the combination of truth seeking. While they disagree strongly about what to do with understanding, both blue and green are deeply committed to seeing and understanding the world as it is, with blue pursuing knowledge and green striving for wisdom. A resonant example in today's society is Genetic Engineering. Genetic engineering is maybe the central case of \"see what's there, so that you can rearrange it to make it better.\"  Albus Dumbledore was blue/green in his old age, as was Uncle Iroh from Avatar: The Last Airbender. The character Morpheus from The Matrix played a blue/green role in the plot.");
			mage.add("Blue wants perfection");
			mage.add("Blue believes that each and every one of us is born a blank slate with the potential to become anything. The entire point of life is figuring out what you could achieve with the right education, experience, and tools. Note that this is not a task with an end goal, but one that continues throughout your life. There will always be things you can do to improve, change, or adapt. The journey of life is one of constant discovery as you keep seeking to better yourself.");
			mage.add("Much as blue wishes to perfect itself, it also wants to perfect the world it lives in. Part of this is to ensure that blue has access to the resources it needs, but part of it is the belief that an element of reaching one's potential is living within a world that has reached its own potential. As such, blue is the color most interested in technology and wants the latest and greatest version of whatever it is using.");
			mage.add("Green wants harmony.");
			mage.add("The other colors are all focused on how they'd change the world to make it better. Green is the one color that doesn't want to change the world, because green is convinced that the world already got everything right. The natural order is a thing of beauty and has all the answers to life's problems. The key is learning to sit back and recognize what is right in front of you.");
			mage.add("Each individual is born with all the potential they need. The secret to a happy life is to recognize the role you were born into and then embrace it. Do what you were destined to do. The world is this elaborate system, and each one of us gets to play a part. And it's not something we have to guess about; it's imprinted on us, it's in our genes. Just look within.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/102612121140/the-philosophy-of-greenblue");
			
		} else if (blackCounter == firstPlace && whiteCounter == secondPlace) {
			mage.add("You are a Black/White Mage (Welcome to the Orzhov Syndicate).");
			mage.add("A White/Black Mage asks the question who's in my circle of concern? The colors White and Black combine to form tribalism—the \"us versus them\" mentality. Think Don Corleone and the other gangsters from The Godfather—a strict system of codes and honor within the group, and almost total impunity with outsiders. You can also see the white/black ingroup-outgroup dynamic in certain swaths of social justice culture.");
			mage.add("Black wants power.");
			mage.add("Black believes it is the only realist, the only color to look and see the world as it is. An individual is free to have whatever they want, provided they have the power to obtain and keep it. This makes power the most important resource, because it's the one thing that can guarantee your ability to control your life and thus your happiness.");
			mage.add("Black's philosophy is very simple: There's no one better suited to look after your own interests than you. Therefore, if everyone looks out after their own interests, you've created a system where everyone has someone looking out for them. In addition, black's system allows everyone the opportunity to succeed. Will everyone succeed? Of course not—but once again, that's not black's doing. That's just how the world works.");
			mage.add("White wants peace.");
			mage.add("White wants to create a world where there is no unnecessary suffering, a world where life is as good as it can be for each individual. The key to making this happen is teaching individuals the importance of taking actions which benefit the group as a whole, even if those actions might not benefit them personally.");
			mage.add("White does want as many as possible to understand its motives and share them. But white realizes that in order to accomplish its larger goal, some individuals will have to be lead down the path rather than venture there of their own accord.");	
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/100239449499/color-pie-friday-the-philosophy-of-whiteblack");

		} else if (blackCounter == firstPlace && blueCounter == secondPlace) {
			mage.add("You are a Black/Blue Mage (Welcome to House Dimir).");
			mage.add("A Black/Blue Mage asks the question how can I best achieve my goals? It's fair to describe blue/black as the combination of \"enlightened self-interest\". Blue and black both agree on growth mindset, the idea that one is not defined by one's origins or constrained to the role society has set. Blue/black characters are often intelligent, clever, arrogant, and aloof. Notable examples include Odysseus from The Odyssey, Sherlock Holmes, and Lex Luthor. Transhumanism is a fundamentally blue-black worldview, in opposition to the imperative to accept death as a crucial and inevitable part of life.");
			mage.add("Black wants power.");
			mage.add("Black believes it is the only realist, the only color to look and see the world as it is. An individual is free to have whatever they want, provided they have the power to obtain and keep it. This makes power the most important resource, because it's the one thing that can guarantee your ability to control your life and thus your happiness.");
			mage.add("Black's philosophy is very simple: There's no one better suited to look after your own interests than you. Therefore, if everyone looks out after their own interests, you've created a system where everyone has someone looking out for them. In addition, black's system allows everyone the opportunity to succeed. Will everyone succeed? Of course not—but once again, that's not black's doing. That's just how the world works.");
			mage.add("Blue wants perfection");
			mage.add("Blue believes that each and every one of us is born a blank slate with the potential to become anything. The entire point of life is figuring out what you could achieve with the right education, experience, and tools. Note that this is not a task with an end goal, but one that continues throughout your life. There will always be things you can do to improve, change, or adapt. The journey of life is one of constant discovery as you keep seeking to better yourself.");
			mage.add("Much as blue wishes to perfect itself, it also wants to perfect the world it lives in. Part of this is to ensure that blue has access to the resources it needs, but part of it is the belief that an element of reaching one's potential is living within a world that has reached its own potential. As such, blue is the color most interested in technology and wants the latest and greatest version of whatever it is using.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/97887622155/color-pie-friday-the-philosophy-of-blueblack");

		} else if (blackCounter == firstPlace && redCounter == secondPlace) {
			mage.add("You are a Black/Red Mage (Welcome to the Cult of Rakdos).");
			mage.add("A Black/Red Mage asks the question how do I get what I want? Because of its dismissive attitude toward judgment and social mores, black/red is often the combination of endorsed hedonism and \"live and let live.\" Black and Red both agree that independence. For red it is something to be fostered and defended in an attempt to avoid coercion or pressure, and for black it is out of a desire for selfreliance and agency. Many black/red characters lean evil, such as the Joker from Batman and Voldemort from canon Harry Potter, but the combination can also be one of impishness or chaotic selfishness, as with Peter Pan, Deadpool, or Cap'n Jack Sparrow. ");
			mage.add("Black wants power.");
			mage.add("Black believes it is the only realist, the only color to look and see the world as it is. An individual is free to have whatever they want, provided they have the power to obtain and keep it. This makes power the most important resource, because it's the one thing that can guarantee your ability to control your life and thus your happiness.");
			mage.add("Black's philosophy is very simple: There's no one better suited to look after your own interests than you. Therefore, if everyone looks out after their own interests, you've created a system where everyone has someone looking out for them. In addition, black's system allows everyone the opportunity to succeed. Will everyone succeed? Of course not—but once again, that's not black's doing. That's just how the world works.");
			mage.add("Red wants freedom.");
			mage.add("Everyone seems preoccupied with the meaning of life. Red's not, because red already knows the answer. You see, your heart tells you what it needs in order to be fulfilled. All you have to do is listen to it and act accordingly. It's not a mystery. You are literally bombarded with constant feelings that guide you down the correct path. The problem is all the other colors ignore the message.");
			mage.add("To outsiders, red might seem a bit chaotic; but that's only because others can't see what's in red's heart. They cannot feel red's emotions guiding them. Living life to its fullest takes a lot of dedication and perseverance, but red is always up to the task.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/98467516137/color-pie-friday-the-philosophy-of-blackred");
			
		} else if (blackCounter == firstPlace && greenCounter == secondPlace) {
			mage.add("You are a Black/Green Mage (Welcome to the Golgari Swarm).");
			mage.add("A Black/Green Mage asks the question what costs must be paid to achieve the ideal? Black and green share a sense of profanity (the absence of the sacred). Black/green is the combination that gets down in the dirt, the combination that embraces the cycle of life and death and rebirth. It's Tyler Durden shouting at his minions \"You are not special; you are made of the same decaying organic matter as everything else; you are all a part of the same compost heap.\" Notable black/green characters are; Bagheera from The Jungle Book, and Poison Ivy from Batman. Circe from The Odyssey is black/green, as are the eponymous Shrek and the Borg from Star Trek. In our own society, certain branches of ecoterrorists and social justice activists are firmly in this class");
			mage.add("Black wants power.");
			mage.add("Black believes it is the only realist, the only color to look and see the world as it is. An individual is free to have whatever they want, provided they have the power to obtain and keep it. This makes power the most important resource, because it's the one thing that can guarantee your ability to control your life and thus your happiness.");
			mage.add("Black's philosophy is very simple: There's no one better suited to look after your own interests than you. Therefore, if everyone looks out after their own interests, you've created a system where everyone has someone looking out for them. In addition, black's system allows everyone the opportunity to succeed. Will everyone succeed? Of course not—but once again, that's not black's doing. That's just how the world works.");
			mage.add("Green wants harmony.");
			mage.add("The other colors are all focused on how they'd change the world to make it better. Green is the one color that doesn't want to change the world, because green is convinced that the world already got everything right. The natural order is a thing of beauty and has all the answers to life's problems. The key is learning to sit back and recognize what is right in front of you.");
			mage.add("Each individual is born with all the potential they need. The secret to a happy life is to recognize the role you were born into and then embrace it. Do what you were destined to do. The world is this elaborate system, and each one of us gets to play a part. And it's not something we have to guess about; it's imprinted on us, it's in our genes. Just look within.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/101418588295/color-pie-friday-the-philosophy-of-blackgreen");
			
		} else if (redCounter == firstPlace && whiteCounter == secondPlace) {
			mage.add("You are a Red/White Mage (Welcome to the Boros Legion).");
			mage.add("A Red/White Mage asks the question what needs to be done? What would a good person do? red and white are the colors of heroism—of passion channeled through morality, and adherence to laws that may be higher than law. The best of warriors, soldiers, and vigilantes is red/white, as are heroes and martyrs. Examples include Daredevil, Robin Hood, and the Weasley twins from Harry Potter (Gryffindor is a red/white House), as well as V from V for Vendetta and Prince Zuko from Avatar: The Last Airbender (at least, near the end of their arcs).");
			mage.add("Red wants freedom.");
			mage.add("Everyone seems preoccupied with the meaning of life. Red's not, because red already knows the answer. You see, your heart tells you what it needs in order to be fulfilled. All you have to do is listen to it and act accordingly. It's not a mystery. You are literally bombarded with constant feelings that guide you down the correct path. The problem is all the other colors ignore the message.");
			mage.add("To outsiders, red might seem a bit chaotic; but that's only because others can't see what's in red's heart. They cannot feel red's emotions guiding them. Living life to its fullest takes a lot of dedication and perseverance, but red is always up to the task.");
			mage.add("White wants peace.");
			mage.add("White wants to create a world where there is no unnecessary suffering, a world where life is as good as it can be for each individual. The key to making this happen is teaching individuals the importance of taking actions which benefit the group as a whole, even if those actions might not benefit them personally.");
			mage.add("White does want as many as possible to understand its motives and share them. But white realizes that in order to accomplish its larger goal, some individuals will have to be lead down the path rather than venture there of their own accord.");	
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/102010667888/color-pie-friday-the-philosophy-of-redwhite");

		} else if (redCounter == firstPlace && blueCounter == secondPlace) {
			mage.add("You are a Red/Blue Mage (Welcome to the Izzet League).");
			mage.add("A Red/Blue Mage asks the question what can be achieved? What might be possible? Blue and red taken together are the colors of creativity. Passion combined with perfection, freedom combined with investigation—blue/red is the pairing that most typifies wild artistry and mad science. Elon Musk's endeavors are one of our strongest examples of blue/red mentality in today's society. Tony Stark from Iron Man started out blue/black, he ended up blue/red. Willy Wonka is also a blue/red archetype, as are Doc Brown from Back to the Future and Indiana Jones.");
			mage.add("Red wants freedom.");
			mage.add("Everyone seems preoccupied with the meaning of life. Red's not, because red already knows the answer. You see, your heart tells you what it needs in order to be fulfilled. All you have to do is listen to it and act accordingly. It's not a mystery. You are literally bombarded with constant feelings that guide you down the correct path. The problem is all the other colors ignore the message.");
			mage.add("To outsiders, red might seem a bit chaotic; but that's only because others can't see what's in red's heart. They cannot feel red's emotions guiding them. Living life to its fullest takes a lot of dedication and perseverance, but red is always up to the task.");
			mage.add("Blue wants perfection");
			mage.add("Blue believes that each and every one of us is born a blank slate with the potential to become anything. The entire point of life is figuring out what you could achieve with the right education, experience, and tools. Note that this is not a task with an end goal, but one that continues throughout your life. There will always be things you can do to improve, change, or adapt. The journey of life is one of constant discovery as you keep seeking to better yourself.");
			mage.add("Much as blue wishes to perfect itself, it also wants to perfect the world it lives in. Part of this is to ensure that blue has access to the resources it needs, but part of it is the belief that an element of reaching one's potential is living within a world that has reached its own potential. As such, blue is the color most interested in technology and wants the latest and greatest version of whatever it is using.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/100829012113/color-pie-friday-the-philosophy-of-bluered");

		} else if (redCounter == firstPlace && blackCounter == secondPlace) {
			mage.add("You are a Red/Black Mage (Welcome to the Cult of Rakdos).");
			mage.add("A Red/Black Mage asks the question how do I get what I want? Because of its dismissive attitude toward judgment and social mores, black/red is often the combination of endorsed hedonism and \"live and let live.\" Black and Red both agree that independence. For red it is something to be fostered and defended in an attempt to avoid coercion or pressure, and for black it is out of a desire for selfreliance and agency. Many black/red characters lean evil, such as the Joker from Batman and Voldemort from canon Harry Potter, but the combination can also be one of impishness or chaotic selfishness, as with Peter Pan, Deadpool, or Cap'n Jack Sparrow. ");
			mage.add("Red wants freedom.");
			mage.add("Everyone seems preoccupied with the meaning of life. Red's not, because red already knows the answer. You see, your heart tells you what it needs in order to be fulfilled. All you have to do is listen to it and act accordingly. It's not a mystery. You are literally bombarded with constant feelings that guide you down the correct path. The problem is all the other colors ignore the message.");
			mage.add("To outsiders, red might seem a bit chaotic; but that's only because others can't see what's in red's heart. They cannot feel red's emotions guiding them. Living life to its fullest takes a lot of dedication and perseverance, but red is always up to the task.");
			mage.add("Black wants power.");
			mage.add("Black believes it is the only realist, the only color to look and see the world as it is. An individual is free to have whatever they want, provided they have the power to obtain and keep it. This makes power the most important resource, because it's the one thing that can guarantee your ability to control your life and thus your happiness.");
			mage.add("Black's philosophy is very simple: There's no one better suited to look after your own interests than you. Therefore, if everyone looks out after their own interests, you've created a system where everyone has someone looking out for them. In addition, black's system allows everyone the opportunity to succeed. Will everyone succeed? Of course not—but once again, that's not black's doing. That's just how the world works.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/98467516137/color-pie-friday-the-philosophy-of-blackred");

		} else if (redCounter == firstPlace && greenCounter == secondPlace) {
			mage.add("You are a Red/Gren Mage (Welcome to the Gruul Clans).");
			mage.add("A Red/Gren Mage asks the question where am I now, and where should I go? Red and green both agree on the importance of authenticity. Green, from a place of wildness and immediacy, and red from a place of passion and self-actualization.A real-life activity that embodies red/green is Circling (à la the Authentic Relating community), which in part emphasizes setting aside narratives and frames and just being present, in the moment, with yourself and other people. Dionysian archetypes are red/green, as is Tinkerbell and the Hulk, and the parts of Wolverine that aren't green are usually red. On the gentler side of things, Aang from Avatar: The Last Airbender is firmly red/green and is often torn between his innate red playfulness and the gravity and responsibility required of his green role and destiny.");
			mage.add("Red wants freedom.");
			mage.add("Everyone seems preoccupied with the meaning of life. Red's not, because red already knows the answer. You see, your heart tells you what it needs in order to be fulfilled. All you have to do is listen to it and act accordingly. It's not a mystery. You are literally bombarded with constant feelings that guide you down the correct path. The problem is all the other colors ignore the message.");
			mage.add("To outsiders, red might seem a bit chaotic; but that's only because others can't see what's in red's heart. They cannot feel red's emotions guiding them. Living life to its fullest takes a lot of dedication and perseverance, but red is always up to the task.");
			mage.add("Green wants harmony.");
			mage.add("The other colors are all focused on how they'd change the world to make it better. Green is the one color that doesn't want to change the world, because green is convinced that the world already got everything right. The natural order is a thing of beauty and has all the answers to life's problems. The key is learning to sit back and recognize what is right in front of you.");
			mage.add("Each individual is born with all the potential they need. The secret to a happy life is to recognize the role you were born into and then embrace it. Do what you were destined to do. The world is this elaborate system, and each one of us gets to play a part. And it's not something we have to guess about; it's imprinted on us, it's in our genes. Just look within.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/99053685935/color-pie-friday-the-philosophy-of-redgreen");
			
		} else if (greenCounter == firstPlace && whiteCounter == secondPlace) {
			mage.add("You are a Green/White Mage (Welcome to the Selesnya Conclave).");
			mage.add("A Green/White Mage asks the question what's fair and good? They both agree on community—on the sense that the whole can be greater than the sum of its parts, and that there are things larger than oneself that are worth sacrificing for. Green/white institutions tend to be centered around compassionate endeavors, but if they go astray it's in the direction of well-meaning lost purposes and wasted signaling (a lack of blue's epistemic hygiene) rather than in the direction of cold, heartless efficiency or relentless pursuit of knowledge or the bottom line. They include institutions like the YMCA, Habitat for Humanity, Teach for America, and most small-town churches—basically any organization whose primary purpose is to foster the web of connection between people and to maintain the society's culture.");
			mage.add("Green wants harmony.");
			mage.add("The other colors are all focused on how they'd change the world to make it better. Green is the one color that doesn't want to change the world, because green is convinced that the world already got everything right. The natural order is a thing of beauty and has all the answers to life's problems. The key is learning to sit back and recognize what is right in front of you.");
			mage.add("Each individual is born with all the potential they need. The secret to a happy life is to recognize the role you were born into and then embrace it. Do what you were destined to do. The world is this elaborate system, and each one of us gets to play a part. And it's not something we have to guess about; it's imprinted on us, it's in our genes. Just look within.");
			mage.add("White wants peace.");
			mage.add("White wants to create a world where there is no unnecessary suffering, a world where life is as good as it can be for each individual. The key to making this happen is teaching individuals the importance of taking actions which benefit the group as a whole, even if those actions might not benefit them personally.");
			mage.add("White does want as many as possible to understand its motives and share them. But white realizes that in order to accomplish its larger goal, some individuals will have to be lead down the path rather than venture there of their own accord.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/99645143496/color-pie-friday-the-philosophy-of-greenwhite");

		} else if (greenCounter == firstPlace && blueCounter == secondPlace) {
			mage.add("You are a Green/Blue Mage (Welcome to the Simic Combine).");
			mage.add("A Green/Blue Mage asks the question what do I not yet understand? Blue/Green is the combination of truth seeking. While they disagree strongly about what to do with understanding, both blue and green are deeply committed to seeing and understanding the world as it is, with blue pursuing knowledge and green striving for wisdom. A resonant example in today's society is Genetic Engineering. Genetic engineering is maybe the central case of \"see what's there, so that you can rearrange it to make it better.\"  Albus Dumbledore was blue/green in his old age, as was Uncle Iroh from Avatar: The Last Airbender. The character Morpheus from The Matrix played a blue/green role in the plot.");
			mage.add("Green wants harmony.");
			mage.add("The other colors are all focused on how they'd change the world to make it better. Green is the one color that doesn't want to change the world, because green is convinced that the world already got everything right. The natural order is a thing of beauty and has all the answers to life's problems. The key is learning to sit back and recognize what is right in front of you.");
			mage.add("Each individual is born with all the potential they need. The secret to a happy life is to recognize the role you were born into and then embrace it. Do what you were destined to do. The world is this elaborate system, and each one of us gets to play a part. And it's not something we have to guess about; it's imprinted on us, it's in our genes. Just look within.");
			mage.add("Blue wants perfection");
			mage.add("Blue believes that each and every one of us is born a blank slate with the potential to become anything. The entire point of life is figuring out what you could achieve with the right education, experience, and tools. Note that this is not a task with an end goal, but one that continues throughout your life. There will always be things you can do to improve, change, or adapt. The journey of life is one of constant discovery as you keep seeking to better yourself.");
			mage.add("Much as blue wishes to perfect itself, it also wants to perfect the world it lives in. Part of this is to ensure that blue has access to the resources it needs, but part of it is the belief that an element of reaching one's potential is living within a world that has reached its own potential. As such, blue is the color most interested in technology and wants the latest and greatest version of whatever it is using.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/102612121140/the-philosophy-of-greenblue");

		} else if (greenCounter == firstPlace && blackCounter == secondPlace) {
			mage.add("You are a Green/Black Mage (Welcome to the Golgari Swarm).");
			mage.add("A Black/Green Mage asks the question what costs must be paid to achieve the ideal? Black and green share a sense of profanity (the absence of the sacred). Black/green is the combination that gets down in the dirt, the combination that embraces the cycle of life and death and rebirth. It's Tyler Durden shouting at his minions \"You are not special; you are made of the same decaying organic matter as everything else; you are all a part of the same compost heap.\" Notable black/green characters are; Bagheera from The Jungle Book, and Poison Ivy from Batman. Circe from The Odyssey is black/green, as are the eponymous Shrek and the Borg from Star Trek. In our own society, certain branches of ecoterrorists and social justice activists are firmly in this class");
			mage.add("Green wants harmony.");
			mage.add("The other colors are all focused on how they'd change the world to make it better. Green is the one color that doesn't want to change the world, because green is convinced that the world already got everything right. The natural order is a thing of beauty and has all the answers to life's problems. The key is learning to sit back and recognize what is right in front of you.");
			mage.add("Each individual is born with all the potential they need. The secret to a happy life is to recognize the role you were born into and then embrace it. Do what you were destined to do. The world is this elaborate system, and each one of us gets to play a part. And it's not something we have to guess about; it's imprinted on us, it's in our genes. Just look within.");
			mage.add("Black wants power.");
			mage.add("Black believes it is the only realist, the only color to look and see the world as it is. An individual is free to have whatever they want, provided they have the power to obtain and keep it. This makes power the most important resource, because it's the one thing that can guarantee your ability to control your life and thus your happiness.");
			mage.add("Black's philosophy is very simple: There's no one better suited to look after your own interests than you. Therefore, if everyone looks out after their own interests, you've created a system where everyone has someone looking out for them. In addition, black's system allows everyone the opportunity to succeed. Will everyone succeed? Of course not—but once again, that's not black's doing. That's just how the world works.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/101418588295/color-pie-friday-the-philosophy-of-blackgreen");

		} else if (greenCounter == firstPlace && redCounter == secondPlace) {
			mage.add("You are a Green/Red Mage (Welcome to the Gruul Clans).");
			mage.add("A Green/Red Mage asks the question where am I now, and where should I go? Red and green both agree on the importance of authenticity. Green, from a place of wildness and immediacy, and red from a place of passion and self-actualization.A real-life activity that embodies red/green is Circling (à la the Authentic Relating community), which in part emphasizes setting aside narratives and frames and just being present, in the moment, with yourself and other people. Dionysian archetypes are red/green, as is Tinkerbell and the Hulk, and the parts of Wolverine that aren't green are usually red. On the gentler side of things, Aang from Avatar: The Last Airbender is firmly red/green and is often torn between his innate red playfulness and the gravity and responsibility required of his green role and destiny.");
			mage.add("Green wants harmony.");
			mage.add("The other colors are all focused on how they'd change the world to make it better. Green is the one color that doesn't want to change the world, because green is convinced that the world already got everything right. The natural order is a thing of beauty and has all the answers to life's problems. The key is learning to sit back and recognize what is right in front of you.");
			mage.add("Each individual is born with all the potential they need. The secret to a happy life is to recognize the role you were born into and then embrace it. Do what you were destined to do. The world is this elaborate system, and each one of us gets to play a part. And it's not something we have to guess about; it's imprinted on us, it's in our genes. Just look within.");
			mage.add("Red wants freedom.");
			mage.add("Everyone seems preoccupied with the meaning of life. Red's not, because red already knows the answer. You see, your heart tells you what it needs in order to be fulfilled. All you have to do is listen to it and act accordingly. It's not a mystery. You are literally bombarded with constant feelings that guide you down the correct path. The problem is all the other colors ignore the message.");
			mage.add("To outsiders, red might seem a bit chaotic; but that's only because others can't see what's in red's heart. They cannot feel red's emotions guiding them. Living life to its fullest takes a lot of dedication and perseverance, but red is always up to the task.");
			mage.add("http://sarpadianempiresvol-viii.tumblr.com/post/99053685935/color-pie-friday-the-philosophy-of-redgreen");
		}
		return mage;
	}

public String returnScores(int questionCounter) {
	String scores = "| White: " + whiteCounter + " | Blue: " + blueCounter + " | Black: "
			+ blackCounter + " | Red: " + redCounter + " | Green: " + greenCounter + " |";
	return scores;
}
	
}
