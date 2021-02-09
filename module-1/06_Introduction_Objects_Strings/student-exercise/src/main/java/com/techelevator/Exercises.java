package com.techelevator;

public class Exercises {

	/*
	 Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
	 helloName("Bob") → "Hello Bob!"
	 helloName("Alice") → "Hello Alice!"
	 helloName("X") → "Hello X!"
	 */
	public String helloName(String name) {
		String greeting = "Hello " + name + "!";
		return greeting;
	}

	/*
	 Given two strings, a and b, return the result of putting them together in the order abba,
	 e.g. "Hi" and "Bye" returns "HiByeByeHi".
	 makeAbba("Hi", "Bye") → "HiByeByeHi"
	 makeAbba("Yo", "Alice") → "YoAliceAliceYo"
	 makeAbba("What", "Up") → "WhatUpUpWhat"
	 */
	public String makeAbba(String a, String b) {
		String abba = a + b + b + a;
		return abba;
	}

	/*
	 The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text. In this example,
	 the "i" tag makes <i> and </i> which surround the word "Yay". Given tag and word strings, create the
	 HTML string with tags around the word, e.g. "<i>Yay</i>".
	 makeTags("i", "Yay") → "<i>Yay</i>"
	 makeTags("i", "Hello") → "<i>Hello</i>"
	 makeTags("cite", "Yay") → "<cite>Yay</cite>"
	 */
	public String makeTags(String tag, String word) {
		String wordTag = "<" + tag + ">" + word + "</" + tag + ">";
		return wordTag;
	}

	/*
	 Given an "out" string length 4, such as "<<>>", and a word, return a new string where the word is in the
	 middle of the out string, e.g. "<<word>>". Note: use str.substring(i, j) to extract the String starting
	 at index i and going up to but not including index j.
	 makeOutWord("<<>>", "Yay") → "<<Yay>>"
	 makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
	 makeOutWord("[[]]", "word") → "[[word]]"
	 */
	public String makeOutWord(String out, String word) {
		out = out.substring( 0, 2 ) + word + out.substring( 2, 4);
		return out;
	}

	/*
	 Given a string, return a new string made of 3 copies of the last 2 chars of the original string. The string
	 length will be at least 2.
	 extraEnd("Hello") → "lololo"
	 extraEnd("ab") → "ababab"
	 extraEnd("Hi") → "HiHiHi"
	 */
	public String extraEnd(String str) {
		String strOutput = str.substring(str.length() - 2);
		return strOutput + strOutput + strOutput;
	}

	/*
	 Given a string, return the string made of its first two chars, so the String "Hello" yields "He". If the
	 string is shorter than length 2, return whatever there is, so "X" yields "X", and the empty string ""
	 yields the empty string "". Note that str.length() returns the length of a string.
	 firstTwo("Hello") → "He"
	 firstTwo("abcdefg") → "ab"
	 firstTwo("ab") → "ab"
	 */
	public String firstTwo(String str) {
		if(str.length() >= 2) {
			return str.substring(0, 2); //return only first two letters
		} return str; //else return entire string if less than two letters
	}

	/*
	 Given a string of even length, return the first half. So the string "WooHoo" yields "Woo".
	 firstHalf("WooHoo") → "Woo"
	 firstHalf("HelloThere") → "Hello"
	 firstHalf("abcdef") → "abc"
	 */
	public String firstHalf(String str) {
		String onlyHalf = str.substring(0, ( str.length()/2 ) );
		return onlyHalf;
	}

	/*
	 Given a string, return a version without the first and last char, so "Hello" yields "ell".
	 The string length will be at least 2.
	 withoutEnd("Hello") → "ell"
	 withoutEnd("java") → "av"
	 withoutEnd("coding") → "odin"
	 */
	public String withoutEnd(String str) {
		String chopped = str.substring( 1, str.length() - 1 );
		return chopped;
	}

	/*
	 Given 2 strings, a and b, return a string of the form short+long+short, with the shorter string
	 on the outside and the longer string on the inside. The strings will not be the same length, but
	 they may be empty (length 0).
	 comboString("Hello", "hi") → "hiHellohi"
	 comboString("hi", "Hello") → "hiHellohi"
	 comboString("aaa", "b") → "baaab"
	 */
	public String comboString(String a, String b) {
		int lengthA = a.length();
		int lengthB = b.length();
		if( lengthA > lengthB ) {
			return b + a + b; //return "bab" if a is longer word
		} return a + b + a; // else return "aba" if b is longer word
	}

	/*
	 Given 2 strings, return their concatenation, except omit the first char of each. The strings will
	 be at least length 1.
	 nonStart("Hello", "There") → "ellohere"
	 nonStart("java", "code") → "avaode"
	 nonStart("shotl", "java") → "hotlava"
	 */
	public String nonStart(String a, String b) {
		a = a.substring(1);
		b = b.substring(1);
		return a + b;
	}

	/*
	 Given a string, return a "rotated left 2" version where the first 2 chars are moved to the end.
	 The string length will be at least 2.
	 left2("Hello") → "lloHe"
	 left2("java") → "vaja"
	 left2("Hi") → "Hi"
	 */
	public String left2(String str) {
		String a = str.substring(0, 2);
		String b = str.substring(2);
		return b + a;
	}

	/*
	 Given a string, return a "rotated right 2" version where the last 2 chars are moved to the start.
	 The string length will be at least 2.
	 right2("Hello") → "loHel"
	 right2("java") → "vaja"
	 right2("Hi") → "Hi"
	 */
	public String right2(String str) {
		String a = str.substring( 0 , str.length() - 2 );
		String b = str.substring( str.length() - 2 );
		return b + a;
	}

	/*
	 Given a string, return a string length 1 from its front, unless front is false, in which case
	 return a string length 1 from its back. The string will be non-empty.
	 theEnd("Hello", true) → "H"
	 theEnd("Hello", false) → "o"
	 theEnd("oh", true) → "o"
	 */
	public String theEnd(String str, boolean front) {
		if(front) {
			return str.substring(0, 1); //return first letter if front is true
		} return str.substring( str.length() - 1 ); //else return last letter
	}

	/*
	 Given a string, return a version without both the first and last char of the string. The string
	 may be any length, including 0.
	 withoutEnd2("Hello") → "ell"
	 withoutEnd2("abc") → "b"
	 withoutEnd2("ab") → ""
	 */
	public String withoutEnd2(String str) {
		if( str.length() <= 2) {
			return "";
		} return str.substring( 1, str.length() - 1);
	}

	/*
	 Given a string of even length, return a string made of the middle two chars, so the string "string"
	 yields "ri". The string length will be at least 2.
	 middleTwo("string") → "ri"
	 middleTwo("code") → "od"
	 middleTwo("Practice") → "ct"
	 */
	public String middleTwo(String str) {
		return str.substring( ( str.length() / 2 ) - 1, (str.length() / 2 ) + 1 ); //str.length() / 2 is the halfway point
	}																			   //so +- 1 finds surrounding two letters

	/*
	 Given a string, return true if it ends in "ly".
	 endsLy("oddly") → true
	 endsLy("y") → false
	 endsLy("oddy") → false
	 */
	public boolean endsLy(String str) {
		if( str.length() < 2) {
			return false; //if string less than two it can't possibly contain "ly"
		} else if( str.substring( str.length() - 2 ).equals("ly") ) { //pull last two letters and compare to "ly"
			return true;
		} return false; //else return false
	}

	/*
	 Given a string and an int n, return a string made of the first and last n chars from the string. The
	 string length will be at least n.
	 nTwice("Hello", 2) → "Helo"
	 nTwice("Chocolate", 3) → "Choate"
	 nTwice("Chocolate", 1) → "Ce"
	 */
	public String nTwice(String str, int n) {
		return ( str.substring( 0, n ) + str.substring( str.length() - n ) );
	}

	/*
	 Given a string and an index, return a string length 2 starting at the given index. If the index is
	 too big or too small to define a string length 2, use the first 2 chars. The string length will be
	 at least 2.
	 twoChar("java", 0) → "ja"
	 twoChar("java", 2) → "va"
	 twoChar("java", 3) → "ja"
	 */
	public String twoChar(String str, int index) {
		if( index >= str.length() -1 ) {
			return str.substring( 0, 2 ); //if index is greater than string length, return first two letters
		} else if ( index < 0 ) {
			return str.substring( 0, 2 ); //if index cannot exist, return first two letters
		} return str.substring( index, index + 2 ); //else, return string of length 2 starting at index
	}

	/*
	 Given a string of odd length, return the string length 3 from its middle, so "Candy" yields "and".
	 The string length will be at least 3.
	 middleThree("Candy") → "and"
	 middleThree("and") → "and"
	 middleThree("solving") → "lvi"
	 */
	public String middleThree(String str) {
		int index = str.length() / 2; //since .length returns an integer, it'll truncate down to be the middle index 
		return str.substring( index - 1 , index + 2 );
	}

	/*
	 Given a string, return true if "bad" appears starting at index 0 or 1 in the string, such as with
	 "badxxx" or "xbadxx" but not "xxbadxx". The string may be any length, including 0. Note: use .equals()
	 to compare 2 strings.
	 hasBad("badxx") → true
	 hasBad("xbadxx") → true
	 hasBad("xxbadxx") → false
	 */
	public boolean hasBad(String str) {
		if( str.length() >= 3 && str.substring( 0, 3 ).equals("bad") ) {
			return true; //confirm string length to avoid out of bounds
		}
		if( str.length() >=4 && str.substring( 1, 4 ).equals("bad") ) {
			return true; //confirm string length to avoid out of bounds
		} return false; //else it's false
	}

	/*
	 Given a string and a non-negative int n, return a larger string that is n copies of the original string.
	 stringTimes("Hi", 2) → "HiHi"
	 stringTimes("Hi", 3) → "HiHiHi"
	 stringTimes("Hi", 1) → "Hi"
	 */
	public String stringTimes(String str, int n) {
		String strOutput = "";
		for( int i = 0; i <= n - 1; i++) {
			strOutput += str;
		} return strOutput;
	}

	/*
	 Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or
	 whatever is there if the string is less than length 3. Return n copies of the front;
	 frontTimes("Chocolate", 2) → "ChoCho"
	 frontTimes("Chocolate", 3) → "ChoChoCho"
	 frontTimes("Abc", 3) → "AbcAbcAbc"
	 */
	public String frontTimes(String str, int n) {
		if( n <= 0 ) {
			return ""; //catch to auto return empty string
		}
		if( str.length() > 3 ) {
			str = str.substring( 0, 3 ); //if string is >= 3, trim it down to a 3 letter string
		} 
		String stringOutput = str;
		for( int i = 0; i < n - 1; i++ ) { //otherwise, leave string alone, and take either value into for loop
			stringOutput = stringOutput + str; //repeatedly concatenate str onto str
		} return stringOutput;
	}

	/*
	 Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".
	 countXX("abcxx") → 1
	 countXX("xxx") → 2
	 countXX("xxxx") →
	 */
	public int countXX(String str) {
		int counter = 0;
		String[] strArray = str.split("");
		for( int i = 0; i < str.length() - 1; i++) {
			if( strArray[i].equals("x") && strArray[i + 1].contentEquals("x") ) {
				counter++;
			}
		} return counter;
	}

	/*
	 Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".
	 doubleX("axxbb") → true
	 doubleX("axaxax") → false
	 doubleX("xxxxx") → true
	 */
	public boolean doubleX(String str) {
		if( str.contains("xx") ) { //*if str does not contain "xx" it will automatically be false*
			String[] stringSplit = str.split(""); //split string into individual letters
			for( int i = 0; i < stringSplit.length - 1; i++ ) {
				if( stringSplit[i].matches("x") && stringSplit[i + 1].matches("[^x]") ) { 
					return false;//finds the first time an x and and any other letter pair up
				} return true; //if the previous test fails, then we know the first index of x is followed by a second x
			} 
		} return false; //*auto false*
	}

	/*
	 Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
	 stringBits("Hello") → "Hlo"
	 stringBits("Hi") → "H"
	 stringBits("Heeololeo") → "Hello"
	 */
	public String stringBits(String str) {
		String[] charArray = str.split("");
		String strOutput = "";
		for( int i = 0; i < charArray.length; i += 2 ) {
			strOutput = strOutput + charArray[i];
		} return strOutput;
	}

	/*
	 Given a non-empty string like "Code" return a string like "CCoCodCode".
	 stringSplosion("Code") → "CCoCodCode"
	 stringSplosion("abc") → "aababc"
	 stringSplosion("ab") → "aab"
	 */
	public String stringSplosion(String str) {
		String[] strArray = str.split("");
		String strOutput = strArray[0];
		for( int i = 0; i < strArray.length - 1; i++) {
			strArray[i + 1] = strArray[i] + strArray[i + 1];
			strOutput += strArray[i + 1];
		}
		return strOutput;
	}

	/*
	 Given a string, return the count of the number of times that a substring length 2 appears in the string and
	 also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).
	 last2("hixxhi") → 1
	 last2("xaxxaxaxx") → 1
	 last2("axxxaaxx") → 2
	 */
	public int last2(String str) {
		if( str.length() <= 2 ) {
			return 0; //this test is an auto failure, can't compare strings withou at least a length of 3
		}
		String[] charArray = str.split("");
		String lastString = str.substring( str.length() - 2, str.length() );
		
		int counter = 0;
		for( int i = 0; i < charArray.length - 2; i++) {
			if( ( charArray[i] + charArray[i + 1] ).matches(lastString) ){
				counter++;
			}
		} return counter;
	}

	/*
	 Given a string, return a version where all the "x" have been removed. Except an "x" at the very start or end
	 should not be removed.
	 stringX("xxHxix") → "xHix"
	 stringX("abxxxcd") → "abcd"
	 stringX("xabxxxcdx") → "xabcdx"
	 */
	public String stringX(String str) {
		
		String stringOutput = "";
		String[] strArray = str.split("");
		
		for( int i = 1; i < str.length() - 2; i++) {
			if( strArray[i].matches("x") ) {
				strArray[i] = "";
			} 
		} for( int i = 0; i < str.length(); i++) {
			stringOutput += strArray[i];
		}
		return stringOutput;
	}

	/*
	 Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".
	 altPairs("kitten") → "kien"
	 altPairs("Chocolate") → "Chole"
	 altPairs("CodingHorror") → "Congrr"
	 */
	public String altPairs(String str) {
		
		int letterCount = str.length();
		String strOutput = "";
		String[] strArray = str.split("");
		
		if( letterCount <= 2) {
			return str;
		}
		
		else if( letterCount < 4) {
			return strArray[0] + strArray[1];
		}
		
		else if( letterCount % 2 == 0) {
			for( int i = 2; i < letterCount; i += 4) {
				strArray[i] = "";
				strArray[i + 1] = "";
			}
			for( int i = 0; i < letterCount; i++) {
				strOutput += strArray[i];
			} return strOutput;
		}
		
		else {
			String lastLetter = strArray[letterCount - 1];
			for( int i = 2; i < letterCount - 1; i += 4) {
				strArray[i] = "";
				strArray[i + 1] = "";
			}
			for( int i = 0; i < letterCount - 1; i++) {
				strOutput += strArray[i];
			} return strOutput + lastLetter;
		} 
		
	}
	

	/*
	 Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed.
	 The "yak" strings will not overlap.
	 stringYak("yakpak") → "pak"
	 stringYak("pakyak") → "pak"
	 stringYak("yak123ya") → "123ya"
	 */
	public String stringYak(String str) {
		String[] stringSplit = str.split("yak");
		String strOutput = "";
		for( int i = 0; i < stringSplit.length; i++) {
			strOutput += stringSplit[i];
		}
		return strOutput;
	}

}
