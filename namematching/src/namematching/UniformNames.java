


package namematching;

public class UniformNames extends Normalization {

	public static void main(String[] args) {

		String externalName = "gynöxeysfwdsdvgrdrandom";
		String stringDataBase = "gynoxysvdrsfdrvxrandom";

		String outputName;

		Normalization inputName = new Normalization();
		Normalization databaseName = new Normalization();
		

		
		System.out.println("input name:  " + externalName);
		inputName.deleteSpaces(externalName);
		outputName = inputName.noSpaces();
		System.out.println("without multiple spaces: " + outputName);
		inputName.toLowerCase(outputName);
		outputName = inputName.lowerCase();
		System.out.println("to lower case: " + outputName);
		inputName.replaceSpecialCharacters(outputName);
		outputName = inputName.noSpecialCharacters();
		System.out.println("without special characters: " + outputName);

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

		
	
		inputName.trimCommonLeadingChar(inputName.replacedEnding(), stringDataBase);
		System.out.println("restant string from the inputname " + inputName.getRestantInputName ()+" restant string of the database name " + inputName.getRestantDatabaseName());
		
		
		inputName.trimLastChar(inputName.getRestantInputName (),inputName.getRestantDatabaseName());
		System.out.println( "after trimming the ending similar characters of the input name: " +
				inputName.getRestantInputName () + "\nafter trimming the ending similar characters of the database name " + inputName.getRestantDatabaseName());
		System.out.println(Normalization.modifiedDamerauLevenshteinDistance(inputName.getRestantInputName (), inputName.getRestantDatabaseName()));
	
	
	
	
	
	
	
	}
	
	
}