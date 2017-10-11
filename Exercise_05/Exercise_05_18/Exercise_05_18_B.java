/*
(Display four patterns using loops) Use nested loops that display the following
patterns in four separate programs:
*/
public class Exercise_05_18_B {
	public static void main(String[] args) {
		// Display pattern B
		System.out.println("Pattern B");
		for (int c = 6; c >= 1; c--) {
			for (int r = 1; r <= c; r++) {
				System.out.print(r);
			}
			System.out.println();
		}
	}
}
