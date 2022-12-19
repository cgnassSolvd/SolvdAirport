package words;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileReader {
	public void driver(File input) {
		File file = new File("/Users/colin/solvdHW/fileReaderTest.txt");
		if(file != null) {
			file = input;
		}
		
		try {
			resetCount(file);
			putCount(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static public void resetCount(File file) throws IOException {
		String constant = "-- Word Count --";
		String currentLine;
		File temp = new File("temp.txt");
		FileWriter tempFileWriter = new FileWriter(temp);
		PrintWriter tempPrintWriter = new PrintWriter(tempFileWriter);
		FileWriter fileWriter;
		PrintWriter printWriter;
		Scanner scanner = new Scanner(file);
		try {
			currentLine = scanner.nextLine();
		} catch (NoSuchElementException e) {
			currentLine = null;
		}
		while (currentLine != null) {
			if(currentLine.equals(constant)) {
				break;
			} else {
				tempPrintWriter.println(currentLine);
			}
			try {
				currentLine = scanner.nextLine();
			} catch (NoSuchElementException e) {
				currentLine = null;
			}
		}
		tempPrintWriter.close();
		fileWriter = new FileWriter(file);
		printWriter = new PrintWriter(fileWriter);
		scanner = new Scanner(temp);
		try {
			currentLine = scanner.nextLine();
		} catch (NoSuchElementException e) {
			currentLine = null;
		}
		while (currentLine != null) {
			if(currentLine.equals(constant)) {
				break;
			} else {
				printWriter.println(currentLine);
			}
			try {
				currentLine = scanner.nextLine();
			} catch (NoSuchElementException e) {
				currentLine = null;
			}
		}
		printWriter.close();
	}
	
	static public void putCount(File file) throws IOException {
		String currentWord;
		boolean seen = false;
		HashMap<String, Integer> words = new HashMap<>();
		FileWriter fileWriter = new FileWriter(file, true);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		Scanner scanner = new Scanner(file);
		try {
			currentWord = scanner.next();
		} catch (NoSuchElementException e) {
			currentWord = null;
		}
		while (currentWord != null) {
			currentWord.toLowerCase();
			if (words.containsKey(currentWord)) {
				words.put(currentWord, words.get(currentWord) + 1);
			} else {
				words.put(currentWord, 1);
			}

			try {
				currentWord = scanner.next();
			} catch (NoSuchElementException e) {
				currentWord = null;
			}
		}
		Iterator iterator = words.keySet().iterator();
		printWriter.println();
		printWriter.println("-- Word Count --");
		while(iterator.hasNext()) {
			String curr = (String) iterator.next();
			printWriter.println(curr + " : " + words.get(curr));
		}
		
		printWriter.close();
	}
}
