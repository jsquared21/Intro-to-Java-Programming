public class MyString2 {
	// Data fields
	private String s;

	/** Create a new Mystring2 object */
	public MyString2(String s) {
		this.s = "";
		for (int i = 0; i < s.length(); i++) {
			this.s += s.charAt(i) + "";
		}
	}

	/** Returns an integer greater than 0, equal to 0, 
	*   or less than 0 to indicate whether this string  
	*   is greater than, equal to, or less than this s */
	public int compare(String s) {
		int index = 0;
		if (this.s.length() < s.length())
			index = -1;
		if (s.length() < this.s.length())
			index = 1; 


		for (int i = 0; i < this.s.length(); i++) {
			if (this.s.charAt(i) < s.charAt(i))
				index = -(i + 1);
			if (this.s.charAt(i) > s.charAt(i))
				index = i + 1;
		}
		return index;
	}

	/** Return a new MyString2 object that is 
	*   a substring with a specified begin */
	public MyString2 substring(int begin) {
		String b = "";
		for (int i = begin, j = 0; i < s.length(); i++, j++) {
			b += s.charAt(i) + "";
		}
		return new MyString2(b);
	}

	/** Return a new MyString2 object in all Upper case */
	public MyString2 toUpperCase() {
		String n = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
				n += String.valueOf((char)(s.charAt(i) - 32));
			else
				n += String.valueOf(s.charAt(i));
		}
		return new MyString2(n);
	}

	/** Return string as a character array */
	public char[] toChars() {
		char[] ch = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			ch[i] = s.charAt(i);
		}
		return ch;
	}

	/** Return the boolean value as a MyString2 object */
	public static MyString2 valueOf(boolean b) {
		return (b ? new MyString2("true") : new MyString2("false"));
	}

}