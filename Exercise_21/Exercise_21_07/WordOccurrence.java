import java.util.*;

public class WordOccurrence implements Comparable<WordOccurrence> {
	String word;
	Integer count;

	/** Construct an instance WordOccurrence 
	  * with specified word and count */
	public WordOccurrence(String word, int count){
		this.word = word;
		this.count = count;
	}

	@Override /** Override the compareTo method in the Comparable class */
	public int compareTo(WordOccurrence o) {
		return o.count.compareTo(count);
	}

	@Override /** Override the toString method in the */
	public String toString() {
		return word + "=" + count;
	}
}