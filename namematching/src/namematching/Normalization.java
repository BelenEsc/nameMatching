package namematching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Normalization {

	private String inputName;
	private String outputName;
	private String temp;
	private String temp2;
	private String firstChar;
	private String remainName;
	private String lastTwoChar;
	private String firstPartString;
	private String databaseName;
	private int distance;

	public Normalization() {

	}

	// delete all extra spaces in the input name

	public void deleteSpaces(String inputName) {
		this.inputName = inputName.replaceAll("\\s+", " ").trim();
	}

	public String noSpaces() {
		return inputName;
	}

	// convert the string to lower case

	public void toLowerCase(String inputName) {
		this.inputName = inputName.toLowerCase();
	}

	public String lowerCase() {
		return inputName;
	}

	// if found, replace all special characters by latin? characters

	public void replaceSpecialCharacters(String inputName) {

		outputName = inputName.replaceAll("[áåâãàä]", "a");
		outputName = outputName.replaceAll("[éêèë]", "e");
		outputName = outputName.replaceAll("[ôõøòóö]", "o");
		outputName = outputName.replaceAll("[ìíîï]", "i");
		outputName = outputName.replaceAll("[üûúù]", "u");
		outputName = outputName.replaceAll("ñ", "n");
		outputName = outputName.replaceAll("ç", "c");
	}

	public String noSpecialCharacters() {
		return outputName;

	}
//	public String checkSpecialCharacters(String inputName) {
//
//		for (int i = 0; i < inputName.length(); i++) {
//			int xp = (int) inputName.charAt(i);
//
//			if (!(xp > 96 && xp < 123 || xp == 32)) {
//				return "no special characters allowed";
//			}
//		}
//		return inputName;
//	}

	// replace initial characters of the string to handle phonetic
	// issues i.e. ph by f, ts by s, ae by e and so on

	public void replaceInitialCharacter(String inicio, String newVal) {

		if (outputName.startsWith(inicio)) {
			outputName = outputName.replace(inicio, newVal);
		}

	}

	public String getReplaceIntialChar() {
		return outputName;

	}

	// split the first character of the input name

	public void splitFirstChar(String inputName) {

		firstChar = (String) inputName.subSequence(0, 1);
		remainName = (String) inputName.subSequence(1, inputName.length());

	}

	public String firstCharName() {
		return firstChar;
	}

	public String remainiName() {
		return remainName;

	}

	// replace characters in string that have phonetic similarities

	public void soundalike(String inputName, String x, String y) {

		if (inputName.contains(x)) {
			remainName = inputName.replace(x, y);
		}
	}

	public String setSoundAlike() {
		return remainName;
	}

	public String getSoundAlike() {
		return firstChar + remainName;
	}

	// deduplicate charactes in input name

	public void removeDuplicate(char str[], int n) {

		int index = 0;
		int p;

		for (int i = 0; i < n - 1; i++) {
			p = i + 1;

			if (!(str[i] == str[p])) {

				str[index++] = str[i];
			}
		}
		temp2 = String.valueOf(Arrays.copyOf(str, index));
		temp2 = temp2 + str[n - 1];
	}

	public String getRemoveDuplic() {
		return temp2;
	}

	// split string in two parts: first par and the last two final characters

	public void splitFinalCharacters(String div) {
		firstPartString = div.substring(0, div.length() - 2);
		lastTwoChar = div.substring((div.length() - 2), div.length());

	}

	public String getFirstPart() {
		return firstPartString;
	}

	public String getLastTwoChar() {
		return lastTwoChar;
	}

	// replace the two final characters if present. This reduced phonetic issues

	public void replaceEnding(String inputName) {

		String[] endingChar = new String[] { "is", "us", "ys", "es", "im", "as", "um", "os" };

		for (String i : endingChar) {

			if (lastTwoChar.contains(i)) {

				lastTwoChar = lastTwoChar.replace(i, "a");

			}
		}

		outputName = firstPartString + lastTwoChar;
	}

	public String replacedEnding() {
		return outputName;

	}

	public void trimCommonLeadingChar(String inputName, String databaseName) {
		int inputNameLength = inputName.length();
		int databaseNameLength = databaseName.length();
		int largestString = Math.max(inputNameLength, databaseNameLength);
		int i;

		for (i = 0; i < largestString; i++) {
			if (i >= inputNameLength || i >= databaseNameLength || inputName.charAt(i) != databaseName.charAt(i)) {
				// Stop iterating when the characters at the current position are not equal.
				break;
			}
		}

		// Create new strings with the common leading characters removed.
		this.inputName = inputName.substring(i);
		this.databaseName = databaseName.substring(i);

	}

	public String getRestantInputName() {
		return inputName;
	}

	public String getRestantDatabaseName() {
		return databaseName;
	}

	public void trimCommLastChar(String inputName, String databaseName) {
		int inputNameLenght = inputName.length();
		int databaseNameLenght = databaseName.length();
		int shortestString = Math.min(inputNameLenght, databaseNameLenght);

		for (int i = 0; i < shortestString; i++) {
			if (inputName.charAt(inputNameLenght - i - 1) != databaseName.charAt(databaseNameLenght - i - 1)) {
				break;

			}
			this.inputName = inputName.substring(0, inputNameLenght - i - 1);
			this.databaseName = databaseName.substring(0, databaseNameLenght - i - 1);
		}

	}

  public int modifiedDamerauLevenshteinDistance(String str1, String str2) {
	
	//str1 is the query
	//str2 is the document 

	if (str1 == str2) {
		return 0;
	} else if (str1.isEmpty()) {
		return str2.length();
	} else if (str2.isEmpty()) {
		return str1.length();
	} else if (str2.length() == 1 && str1.length() == 1 && str1 != str2) {
		return 1;
	} else {

		int[][] distanceMatrix = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i <= str1.length(); i++) {
			distanceMatrix[i][0] = i;
		}

		for (int j = 0; j <= str2.length(); j++) {
			distanceMatrix[0][j] = j;
		}

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				int cost = (str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1;
				distanceMatrix[i][j] = Math.min(
						Math.min(distanceMatrix[i - 1][j] + 1, distanceMatrix[i][j - 1] + 1),
						distanceMatrix[i - 1][j - 1] + cost);

				if (i > 1 && j > 1 && str1.charAt(i - 1) == str2.charAt(j - 2)
						&& str1.charAt(i - 2) == str2.charAt(j - 1)) {
					distanceMatrix[i][j] = Math.min(distanceMatrix[i][j], distanceMatrix[i - 2][j - 2] + cost);
				}
			}
		}
		return distanceMatrix[str1.length()][str2.length()];
	}
}

public String findMatchingNames(String query) {
	
	String result = "";
	int lowestDistance = Integer.MAX_VALUE;

	List<String> DataBaseString = new ArrayList<>();
	DataBaseString.add("closet Name");
	DataBaseString.add("asasas");
	DataBaseString.add("pglkfk");

	Map<Integer, String> distanceMap = new HashMap<>();

	for (String document : DataBaseString) {

		int distance = modifiedDamerauLevenshteinDistance(query, document);
		distanceMap.put(distance, document);
	}

	List<Integer> distanceList = new ArrayList<>(distanceMap.keySet());
	Collections.sort(distanceList);

	for (int i = 0; i < distanceList.size(); i++) {
		int distance = distanceList.get(i);

		if (distance < lowestDistance) {
			lowestDistance = distance;
			result = distanceMap.get(distance);
		}
	}
	return result;
}

//	public void StringInNgrams(String inputName, int ngram) {
//
//		temp = "  " + inputName + "  ";
//		String[] ngrams = new String[temp.length() + 5];
//
//		for (int i = 0; i < temp.length(); i++) {
//
//			ngrams[i] = temp.substring(i, i + ngram);
//			System.out.println(ngrams[i]);
//		}
//	}


	
}
