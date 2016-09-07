/*********************************************************************************
* (Implement MyHashSet using MyHashMap) Implement MyHashSet using MyHashMap.     *
* Note that you can create entries with (key, key), rather than (key, value).    *
*********************************************************************************/
public class Exercise_27_05 {
	public static void main(String[] args) {
		// Create a MyHashSet
		MySet<String> set = new MyHashSet<>();
		set.add("Smith");
		set.add("Anderson");
		set.add("Lewis");
		set.add("Cook");
		set.add("Smith");

		System.out.println("Elements in set: " + set);
		System.out.println("Number of elements in set: " + set.size());
		System.out.println("Is Smith in set? " + set.contains("Smith"));

		set.remove("Smith");
		System.out.println("Names in set in uppercase are ");
		for (String s: set)
			System.out.print(s.toUpperCase() + " ");
			
		set.clear();
		System.out.println("\nElements in set: " + set);
	}
}