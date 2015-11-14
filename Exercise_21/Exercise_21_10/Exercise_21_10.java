/*********************************************************************************
* (Count the occurrences of each keyword) Rewrite Listing 21.7 CountKeywords.    *
* java to read in a Java source code file and count the occurrence of each       *
* keyword in the file, but don’t count the keyword if it is in a comment or in a *
* string literal.                                                                *
*********************************************************************************/
import java.util.*;
import java.io.*;

public class Exercise_21_10 {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a Java source file: ");
		String filename = input.nextLine();

		File file = new File(filename);
		if (file.exists() && filename.substring(
			filename.lastIndexOf(".")).equals(".java")) {
			System.out.println("The number of keywords in " + filename 
				+ " is " + countKeywords(file));
		}
		else {
			System.out.println("File " + filename + " does not exist");
		}
	}

	/** read in a Java source code file and count the occurrence of each keyword in 
	  * the file. Keywords in a comment or in a string literal are ont counted */
	public static int countKeywords(File file) throws Exception {
		// Array of all Java Keywords + ture, false and null
		String[] keywordString = {"abstract", "assert", "boolean",
			"break", "byte", "case", "catch", "char", "class", "const",
			"continue", "default", "do", "double", "else", "enum",
			"extends", "for", "final", "finally", "float", "goto",
			"if", "implements", "import", "instanceof", "int",
			"interface", "long", "native", "new", "package", "private",
			"protected", "public", "return", "short", "static",
			"strictfp", "super", "switch", "synchronized", "this",
			"throw", "throws", "transient", "try", "void", "volatile",
			"while", "true", "false", "null"};

		Set<String> keywordSet = 
			new HashSet<>(Arrays.asList(keywordString));
		int count = 0;

		Scanner input = new Scanner(file);

		while (input.hasNext()) {
			String word = input.next();
			if (word.equals("//"))
				input.nextLine();
			else if (word.contains("\""))
				while (input.hasNext() && !input.next().contains("\"")) {}
			else if (word.contains("/*"))
				while (input.hasNext() && !input.next().contains("*/")) {}
			else if (keywordSet.contains(word))
				count++;
		}

		return count;
	}
}