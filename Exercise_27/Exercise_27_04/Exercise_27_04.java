/*********************************************************************************
* (Modify MyHashMap with duplicate keys) Modify MyHashMap to allow duplicate     *
* keys for entries. You need to modify the implementation for the put(key,value) *
* method. Also add a new method named getAll(key) that returns a set of values   *
* that match the key in the map.                                                 *
*********************************************************************************/
public class Exercise_27_04 {
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

		System.out.println("The age of all Smith entries " +
			map.getAll("Smith"));

		System.out.println("Is Smith in the map? " +
			map.containsKey("Smith"));

		System.out.println("Is jay in the map? " +
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