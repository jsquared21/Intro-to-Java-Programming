import java.util.ArrayList;

public class MyHashMap<K, V> implements MyMap<K, V> {
	// Define the default hash-table size. Must be power of 2
	private static int DEFAULT_INITIAL_CAPACITY = 4;

	// Define the maximum hash-table size. 1 << 30 is same as 2 ^ 30
	private static int MAXIMUM_CAPACITY = 1 << 30;

	// Current hash-table capacity. Capacity is a power of 2
	private int capacity;

	// Define default load factor
	private static float DEFAULT_MAX_LOAD_FACTOR = 0.5f;

	// Specify a load factor used in the hash table
	private float loadFactorThreshold;

	// The number of entries in the map
	private int size = 0;

	// Hash table is an ArrayList
	private ArrayList<MyMap.Entry<K, V>> table;

	/** Construct a map with the default capacity and load factor */
	public MyHashMap() {
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
	}

	/** Construct a map with the specified initial capacity and 
	 * default load factor */
	public MyHashMap(int initialCapacity) {
		this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
	}

	/** Construct a map with the specified initial capacity
	 * and load factor */
	public MyHashMap(int initialCapacity, float loadFactorThreshold) {
		if (initialCapacity > MAXIMUM_CAPACITY)
			this.capacity = MAXIMUM_CAPACITY;
		else
			this.capacity = trimToPowerOf2(initialCapacity);

		this.loadFactorThreshold = loadFactorThreshold;
		table = new ArrayList<>();
		for (int i = 0; i < capacity; i++) {
			table.add(null);
		}
	}

	@Override /** Remove all the entries from this map */
	public void clear() {
		size = 0;
		removeEntries();
	}	

	@Override /** Return true if the specified key is in the map */
	public boolean containsKey(K key) {
		if (get(key) != null)
			return true;
		else
			return false;
	}

	@Override /** Return true if this map contains the value */
	public boolean containsValue(V value) {
		for (Entry<K, V> entry : table) {
			if (entry != null && entry.getValue() == value) {
				return true;
			}
		}

		return false;
	}

	@Override /** Return a set of entries in the map */
	public java.util.Set<Entry<K, V>> entrySet() {
		java.util.Set<Entry<K, V>> set = new java.util.HashSet<>();

		for (Entry<K, V> entry: table) {
			if (entry != null)
				set.add(entry);
		}

		return set;
	}

	@Override /** Return the value that matched the specified key */
	public V get(K key) {
		int index = hash(key.hashCode());

		while (table.get(index) != null) {
			if (table.get(index).getKey().equals(key)) {
				return table.get(index).getValue();
			}

			index++;
			index %= capacity;
		}

		return null;
	}

	@Override /** Return a set of values that match the key in the map */
	public java.util.Set<V> getAll(K key) {
		java.util.Set<V> set = new java.util.HashSet<>();
		int index = hash(key.hashCode());

		while (table.get(index) != null ) {
			if (table.get(index).getKey().equals(key)) {
				set.add(table.get(index).getValue());
			}

			index++;
			index %= capacity;
		}

		return set;
	}

	@Override /** Return true if this map contains no entries */
	public boolean isEmpty() {
		return size == 0;
	}

	@Override /** Return a set consisting of the keys in this map */
	public java.util.Set<K> keySet() {
		java.util.Set<K> set = new java.util.HashSet<>();

		for (Entry<K, V> entry: table) {
			if (entry != null)
				set.add(entry.getKey());
		}

		return set;
	}

	@Override /** Add an entry (key, value) into the map */
	public V put(K key, V value) {
		int index = hash(key.hashCode());

		while (table.get(index) != null) {
			index++;
			index %= capacity;
		}

		if (size >= capacity * loadFactorThreshold) {
			if (capacity == MAXIMUM_CAPACITY) {
				throw new RuntimeException("Exceeding maximum capacity");
			}
			rehash();
		}

		// Add a new entry (key, value) to hash table
		table.set(index, new MyMap.Entry<K, V>(key, value));

		size++; // Increase size

		return value;
	}

	@Override /** Remove the entry for the specified key */
	public void remove(K key) {
		int index = hash(key.hashCode());

		// Remove the first entry that matches the key
		while (table.get(index) != null) {
			if (table.get(index).getKey().equals(key)) {
				table.remove(index);
				size--; // Decrease size
				break; // Remove just one entry that matches the key
			}
			
			index++;
			index %= capacity;
		}
	}

	@Override /** Return the number of entries in this map */
	public int size() {
		return size;
	}

	@Override /** Return a set consisting of all the values in this map */
	public java.util.Set<V> values() {
		java.util.Set<V> set = new java.util.HashSet<>();

		for (Entry<K, V> entry : table) {
			if (entry != null) {
				set.add(entry.getValue());
			}
		}

		return set;
	}

	/** Hash function */
	private int hash(int hashCode) {
		return supplementalHash(hashCode) & (capacity - 1);
	}

	/** Ensure the hashing is evenly distributed */
	private int supplementalHash(int h) {
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	/** Return a power of 2 for initialCapacity */
	private int trimToPowerOf2(int initialcapacity) {
		int capacity = 1;
		while (capacity < initialcapacity) {
			capacity <<= 1;
		}

		return capacity;

	}

	/** Remove all entries from map */
	private void removeEntries() {
		table.clear();
	}

	/** Rehash the map */
	private void rehash() {
		java.util.Set<Entry<K, V>> set = entrySet();
		capacity <<= 1; // Same as *= 2. <= is more efficient
		size = 0; // Reset size
		table.clear();
		for (int i = 0; i < capacity; i++) 
			table.add(null);
		
		for (Entry<K, V> entry : set) {
			put(entry.getKey(), entry.getValue());
		}
	}

	@Override 
	public String toString() {
		StringBuilder builder = new StringBuilder("[");

		for (Entry<K, V> entry : table) {
			if (entry != null && size > 0) {
				builder.append(entry);
			}
		}

		builder.append("]");
		return builder.toString();
	}
}