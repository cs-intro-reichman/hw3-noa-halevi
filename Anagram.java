public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
    	str2 = preProcess(str2);
		if(str1.length() != str2.length()){
			return false;
		}
		for (int i=0; i < str1.length(); i++){
			char currentChar = str1.charAt(i);
			int count1 = 0;
			int count2 = 0;
			// Count occurrences in str1
			for(int j=0; j <str1.length(); j++){
				if (str1.charAt(j) == currentChar) {
					count1++;
				}
			} // Count occurrences in str2
			for (int j = 0; j < str2.length(); j++) {
				if (str2.charAt(j) == currentChar) {
					count2++;
				}
			}
			if (count1 != count2) {
				return false;
			}
		}	
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String result = "";
		for(int i=0; i < str.length(); i++){
			char currentChar = str.charAt(i);
			if ((currentChar >= 'A' && currentChar <= 'Z')) {
                currentChar = (char) (currentChar + 32); // Convert to lowercase
            }
            if ((currentChar >= 'a' && currentChar <= 'z') || currentChar == ' ') {
                result += currentChar;
            }
        }
        return result;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String result = "";
		String remaining = str;
		int randomPosition;
		while (remaining.length() > 0){
			randomPosition = (int) ((Math.random() * remaining.length()));
			char randomChar = remaining.charAt(randomPosition);
			result += randomChar;
			String newRemaining = "";
			for (int i = 0; i < remaining.length(); i++) {
				if (i != randomPosition) {
					newRemaining += remaining.charAt(i);
				}
			}
			remaining = newRemaining;
		}
		return result;	
	}
}	


}	

