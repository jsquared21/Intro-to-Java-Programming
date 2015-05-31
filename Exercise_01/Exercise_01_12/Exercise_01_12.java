/*
(Average speed in kilometers) Assume a runner runs 24 miles in 1 hour, 40 minutes,
and 35 seconds. Write a program that displays the average speed in kilometers per
hour. (Note that 1 mile is 1.6 kilometers.)
*/
public class Exercise_01_12 {
	public static void main(String[] agrs) {
		System.out.println("Miles / (hour + (minutes / 60) + (seconds / 3600)) * 1.6");
		System.out.println("24    / (1    + (40      / 60) + (35      / 3600))  * 1.6");
		System.out.println((24 / (1 + (40 / 60.0) + (35 / 3600.0))) * 1.6);
	}
}