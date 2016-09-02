/*********************************************************************************
* (Implement MyMap using open addressing with linear probing) Create a new       * 
* concrete class that implements MyMap using open addressing with linear         *
* probing. For simplicity, use f(key) = key % size as the hash function, where   *
* size is the hash-table size. Initially, the hash-table size is 4. The table    *
* size is doubled whenever the load factor exceeds the threshold (0.5).          *
*********************************************************************************/
public class Exercise_27_01 {
	public static void main(String[] args) {
		// Create a map
		MyMap<String, Integer> map = new MyHashMap<>();
		map.put("Smith", 30);
	   map.put("Anderson", 31);
		map.put("Lewis", 29);
		map.put("Cook", 29);
		map.put("Tom", 21);
		map.put("Mark", 21);
		map.put("Smith", 65);
		map.put("William", 21);

		System.out.println("Entries in map: " + map);

		System.out.println("The age of Lewis is " +
			map.get("Lewis"));

		System.out.println("The age of William is " +
			map.get("William"));

		System.out.println("Is Smith in the map? " +
			map.containsKey("Smith"));

		System.out.println("Is Jay in the map? " +
			map.containsKey("Jay"));

		System.out.println("Is age 33 in the map? " +
			map.containsValue(33));

		System.out.println("Is age 31 in the map? " +
			map.containsValue(31));

		System.out.print("Keys in map: ");
		for (String key : map.keySet()) {
			System.out.print(key + " ");
		}
		System.out.println();

		System.out.print("Values in map: ");
		for (int value : map.values()) {
			System.out.print(value + " ");
		}
		System.out.println();

		map.remove("Smith");
		System.out.println("Entries in map " + map);

		map.clear();
		System.out.println("Entries in map " + map);

	}
}