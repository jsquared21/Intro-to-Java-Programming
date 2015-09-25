/*********************************************************************************
* (Combine files) Write a utility program that combines the files together into  *
* a new file using the following command:                                        *
*                                                                                *
* java Exercise17_12 SourceFile1 . . . SourceFilen TargetFile                    *
*                                                                                *
* The command combines SourceFile1, . . . , and SourceFilen into TargetFile.     *
*********************************************************************************/
import java.io.*;

public class Exercise_17_12 {
	public static void main(String[] args) throws IOException {
		// Check java usage
		if (args.length < 2) {
			System.out.println(
				"Usage: java Exercise_17_12 SourceFile1 . . . SourceFilen TargetFile");
			System.exit(0);
		}

		// Create an array for radom access files 
		RandomAccessFile[] source = new RandomAccessFile[args.length - 1];

		try ( // Create a random access file
			RandomAccessFile target = 
				new RandomAccessFile(args[args.length - 1], "rw");
		) {
			// Place the source files into the array
			for (int i = 0; i < source.length; i++) {
				source[i] = new RandomAccessFile(args[i], "r");
			}

			// Read each source file in ascending order
			// and write them to the target file
			for (int i = 0; i < source.length; i++) {
				byte[] b = new byte[(int)source[i].length()];
				source[i].seek(0);
				source[i].read(b);
				target.seek(target.length());
				target.write(b);
			}
		}
	}
}