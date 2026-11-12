package designs.twosum;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * First Non-Repeating Character
 *
 * Given a string, return the index of the first character that appears exactly once.
 */
public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        String input = "loveleetcode";

        System.out.println("First non-repeating char at: " + getFirstNonRepeatingChar(input));
    }

    public static int getFirstNonRepeatingChar(String input) {
        if(null == input || "".equals(input.trim())) {
            return -1;
        }

        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        //add to map
        for(int i=0; i< input.length(); i++) {
            Character c = input.charAt(i);

            Integer currentValue = charFrequencyMap.putIfAbsent(c, 1);
            if(null != currentValue ) {
                charFrequencyMap.put(c, ++currentValue);
            }
        }

        // traverse original string to find first non-repeating char index
        for(int i=0; i<input.length(); i++) {
            if(charFrequencyMap.get(input.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
