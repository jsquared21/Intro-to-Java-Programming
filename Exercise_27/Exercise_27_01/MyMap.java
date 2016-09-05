public interface MyMap<K, V> {
	/** Remove all of the entries from this map */
	public void clear();

	/** Return true if the specified key is in the map */
	public boolean containsKey(K key);

	/** Return true if this map contains the specified value */
	public boolean containsValue(V value);

	/** Return a set of entries in the map */
	public java.util.Set<Entry<K, V>> entrySet();

	/** Return the value that matches the specified key */
	public V get(K key);

	/** Return true if this map doesn't contain any entries */
	public boolean isEmpty();

	/** Return a set consisting of the keys in this map */
	public java.util.Set<K> keySet();

	/** Add an entry (key, value) into the map */
	public V put (K key, V value);

	/** Remove entry for the specified key */
	public void remove(K key);

	/** Return the number of mappings in this map */
	public int size();

	/** Return a set consisting of the values in this map */
	public java.util.Set<V> values();

	/** Define an inner class for Entry */
	public static class Entry<K, V> {
		K key;
		V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		@Override
		public String toString() {
			return "[" + key + ", " + value + "]";
		}
	}
}