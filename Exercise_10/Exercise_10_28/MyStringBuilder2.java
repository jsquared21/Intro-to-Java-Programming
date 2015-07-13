public class MyStringBuilder2 {
	// Data field
	private String s;

	/** Create a default MyStringBuilder object */
	public MyStringBuilder2() {
		s = "";
	}

	/** Create a MyStringBuilder object of a specified character array */
	public MyStringBuilder2(char[] chars) {
		s = String.valueOf(chars);
	}

	/** Create a MyStringBuilder object of a specified string */
	public MyStringBuilder2(String s) {
		this.s = s;
	}

	/** Return a MyStringBuilder object with s inserted at the offset */
	public MyStringBuilder2 insert(int offset, MyStringBuilder2 s) {
		String newStr = "";
		int i;
		for (i = 0; i < offset; i++) {
			if (i < offset)
				newStr += this.s.charAt(i) + "";
		}
		newStr += s;
		return new MyStringBuilder2(newStr + substring(offset));
	}

	// Return a reversed MyStringBuilder2 object
	public MyStringBuilder2 reverse() {
		String newStr = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			newStr += s.charAt(i) + "";
		}
		return new MyStringBuilder2(newStr);
	}

	/** Return a MyStringBuilder object substring beginning at begin */
	public MyStringBuilder2 substring(int begin) {
		String newStr = "";
		for (int i = begin; i < s.length(); i++) {
			newStr += s.charAt(i) + "";
		}
		return new MyStringBuilder2(newStr);
	}

	/** Return a MyStringBuilder object in all upper case */
	public MyStringBuilder2 toUpperCase() {
		String newStr = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
				newStr += (char)(s.charAt(i) - 32) + "";
			else
				newStr += s.charAt(i) + "";
		}
		return new MyStringBuilder2(newStr);
	}

	/** Return string */
	public String toString() {
		return s;
	}

	/** Return length */
	public int length() {
		return s.length();
	}

	/** Return the character at specified index */
	public char charAt(int index) {
		return s.charAt(index);
	}
}