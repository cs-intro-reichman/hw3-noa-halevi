str1 = preProcess(str1);
    str2 = preProcess(str2);

    // If lengths are not equal, they cannot be anagrams
    if (str1.length() != str2.length()) {
        return false;
    }

    // Check frequency of each character in str1 and str2
    for (int i = 0; i < str1.length(); i++) {
        char currentChar = str1.charAt(i);
        int count1 = 0;
        int count2 = 0;

        // Count occurrences of currentChar in str1
        for (int j = 0; j < str1.length(); j++) {
            if (str1.charAt(j) == currentChar) {
                count1++;
            }
        }

        // Count occurrences of currentChar in str2
        for (int j = 0; j < str2.length(); j++) {
            if (str2.charAt(j) == currentChar) {
                count2++;
            }
        }

        // If counts do not match, they are not anagrams
        if (count1 != count2) {
            return false;
        }
    }

    return true; // The strings are anagrams
}
