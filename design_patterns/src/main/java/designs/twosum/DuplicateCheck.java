package designs.twosum;

import java.util.HashSet;
import java.util.Set;

public class DuplicateCheck {

    public static void main(String[] args) {
        int[] input = new int[] {1,2,3,10};
        System.out.println("Duplicate exist? : " + isDuplicateFound(input));
    }

    public static boolean isDuplicateFound(int[] array) {
        Set<Integer> numSet = new HashSet<>();

        for(int i=0; i<array.length; i++) {
            if(numSet.contains(array[i])) {
                return true;
            } else {
                numSet.add(array[i]);
            }
        }

       return false;
    }
}
