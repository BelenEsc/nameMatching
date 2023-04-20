package namematching;

public class UniformNames extends Normalization {

	public static void main(String[] args) {

		String externalName = "PabelCarilo";
		String stringDataBase = "PabelCarrillo";
		//int ngram=3; 

		Normalization inputName = new Normalization();
		Normalization databaseName = new Normalization();
		
		System.out.println("input name:  " + externalName);
		inputName.deleteSpaces(externalName);
		System.out.println("without multiple spaces: " + inputName.noSpaces());
		inputName.toLowerCase(inputName.noSpaces());
		System.out.println("to lower case: " + inputName.lowerCase());
		inputName.replaceSpecialCharacters(inputName.lowerCase());
		System.out.println("without special characters: " + inputName.noSpecialCharacters());

		inputName.replaceInitialCharacter("ph", "f");
		inputName.replaceInitialCharacter("ae", "e");
		inputName.replaceInitialCharacter("cn", "n");
		inputName.replaceInitialCharacter("ct", "t");
		inputName.replaceInitialCharacter("cz", "c");
		inputName.replaceInitialCharacter("dj", "d");
		inputName.replaceInitialCharacter("ea", "e");
		inputName.replaceInitialCharacter("eu", "u");
		inputName.replaceInitialCharacter("gn", "n");
		inputName.replaceInitialCharacter("kn", "n");
		inputName.replaceInitialCharacter("mc", "mac");
		inputName.replaceInitialCharacter("mn", "n");
		inputName.replaceInitialCharacter("oe", "e");
		inputName.replaceInitialCharacter("qu", "q");
		inputName.replaceInitialCharacter("ps", "s");
		inputName.replaceInitialCharacter("pt", "t");
		inputName.replaceInitialCharacter("ts", "s");
		inputName.replaceInitialCharacter("wr", "r");
		inputName.replaceInitialCharacter("x", "z");

		System.out.println("replaced initial characters: " + inputName.getReplaceIntialChar());
		inputName.splitFirstChar(inputName.getReplaceIntialChar());
		System.out.println("the first letter in the name is : " + inputName.firstCharName());
		System.out.println("the remainin part is: " + inputName.remainiName());
		
		inputName.soundalike(inputName.remainiName(), "ae", "e");
		inputName.soundalike(inputName.setSoundAlike(), "ia", "a");
		inputName.soundalike(inputName.setSoundAlike(), "oe", "i");
		inputName.soundalike(inputName.setSoundAlike(), "oi", "a");
		inputName.soundalike(inputName.setSoundAlike(), "sc", "s");

		System.out.println("sound alike:  " + inputName.setSoundAlike());
		System.out.println("concatenated:  " + inputName.getSoundAlike());
		inputName.removeDuplicate((inputName.getSoundAlike()).toCharArray(), inputName.getSoundAlike().length());
		System.out.println("without duplicated characters: " + inputName.getRemoveDuplic());
		inputName.splitFinalCharacters(inputName.getRemoveDuplic());
		System.out.println("first part of the string: " + inputName.getFirstPart());
		System.out.println("last two char: " + inputName.getLastTwoChar());
		inputName.replaceEnding(inputName.getLastTwoChar());
		System.out.println("replaced two ending characters: " + inputName.replacedEnding());
		/////
//		databaseName.splitFirstChar(stringDataBase);
//		System.out.println("first char of the database: " + databaseName.firstCharName());
//		databaseName.splitFinalCharacters(databaseName.remainiName());
//		System.out.println("first and last two letter of the string from DATABASE deleted: " + databaseName.getFirstPart());
		
		///	databaseName.getFirstPartString(databaseName.remainiName());
		inputName.trimCommonLeadingChar(inputName.replacedEnding(), stringDataBase); //this string from the data base should also pass throw all the methods in the normalization class
		System.out.println("restant string from the inputname " + inputName.getRestantInputName ()+" restant string of the database name: " + inputName.getRestantDatabaseName());
		
		inputName.trimCommLastChar(inputName.getRestantInputName (),inputName.getRestantDatabaseName());
		System.out.println( "after trimming the ending similar characters of the input name: " +
				inputName.getRestantInputName () + "\nafter trimming the ending similar characters of the database name " + inputName.getRestantDatabaseName());
		//inputName.modifiedDamerauLevenshteinDistance(inputName.getRestantInputName (), inputName.getRestantDatabaseName());
		//System.out.println("the distance between the two strings: " +inputName.distanceMDL());
		//inputName.StringInNgrams(externalName, ngram);
		inputName.recordMatches(inputName.getRestantInputName ());
		
	}

}
