package namematching;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class NormalizationTest {

	Normalization testUnit = new Normalization();
	private String inputName;

	@Test
	public void testDeleteSpaces() {
		inputName = "Quercus   acuta  ";
		testUnit.deleteSpaces(inputName);
		Assert.assertEquals("what is this", "Quercus acuta", testUnit.noSpaces());
	}

	@Test
	public void testLowerCase() {
		inputName = "QUERcus Acuta";
		testUnit.toLowerCase(inputName);
		Assert.assertEquals("xx", "quercus acuta", inputName.toLowerCase());
	}

	@Test
	public void testNoSpecialCharacters() {
		inputName = "Qüercus äcutá";
		testUnit.replaceSpecialCharacters(inputName);
		Assert.assertEquals("Special characters", "Quercus acuta", testUnit.noSpecialCharacters());
	}

	@Test
	public void testReplaceInitialCharacter() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetReplaceIntialChar() {
		fail("Not yet implemented");
	}

	@Test
	public void testSplitFirstChar() {
		fail("Not yet implemented");
	}

	@Test
	public void testFirstCharName() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemainiName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSoundalike() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSoundAlike() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSoundAlike() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveDuplicate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRemoveDuplic() {
		fail("Not yet implemented");
	}

	@Test
	public void testSplitFinalCharacters() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFirstPart() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLastTwoChar() {
		fail("Not yet implemented");
	}

	@Test
	public void testReplaceEnding() {
		fail("Not yet implemented");
	}

	@Test
	public void testReplacedEnding() {
		fail("Not yet implemented");
	}

	@Test
	public void testTrimCommonLeadingChar() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRestantInputName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRestantDatabaseName() {
		fail("Not yet implemented");
	}

	@Test
	public void testTrimLastChar() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifiedDamerauLevenshteinDistance() {
		String name = "headEZXGend";
		String name2 = "headrrrrend";

		int result = testUnit.modifiedDamerauLevenshteinDistance(name, name2);
		Assert.assertEquals("xx", 4, result);
	}

	@Test
	public void testFindMatchingNames() {
		Normalization name = new Normalization();
		List<String> DataBaseString = new ArrayList<>();
		String result = name.findMatchingNames("closest name");
		assertEquals("closet Name", result);
	}

}