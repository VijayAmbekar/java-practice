package designs.twosum;

import java.util.HashMap;

/**
 * Problem 4: Valid Anagram.
 * Pattern: Frequency counting / HashMap
 * 1. Problem statement
 * Given two strings s and t, determine whether t is an anagram of s.
 * <p>
 * An anagram means both strings contain exactly the same characters with exactly the same frequencies, but their order can be different.
 * <p>
 * Examples:
 * String s	String t	Output
 * "listen"	"silent"	true
 * "anagram"	"nagaram"	true
 * "rat"	"car"	false
 * "aabb"	"abab"	true
 * "aabb"	"abbb"	false
 */
public class ValidAnagram {
    public static void main(String[] args) {
        String a = "listen";
        String b = "silent";

        System.out.println("isValid anagram: " + isValidAnagram(a, b));
    }

    public static boolean isValidAnagram(String a, String b) {
        if (null == a || null == b || a.length() != b.length()) {
            return false;
        }

        HashMap<Character, Integer> charFrequency = new HashMap<>();
        for(int i=0; i<a.length(); i++) {
            charFrequency.merge(a.charAt(i), 1, Integer::sum);
            charFrequency.merge(b.charAt(i), -1, Integer::sum);
        }

        return charFrequency.values().stream().filter(v -> v !=0)
                .findAny().isEmpty();

    }
}
