package designs.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * for given int array and an integer target, return indices of 2 numbers
 * whose sum equals the target
 * - Exactly one valid answer exists
 * cannot use same element twice
 * - you can return indices in any order
 */

public class TwoSumsBruteForce {

    public static void main(String[] args) {
//       int[] result = findSumBrutForce(new int[]{2,7,11,15}, 9 );
//        int[] result = findSumBrutForce(new int[]{2,7,11,15}, 26 );

//        int[] result = findSumOptimized(new int[]{2,7,11,15}, 9 );
        int[] result = findSumOptimized(new int[]{2,7,11,15}, 26 );
        displayIndexes(result);
    }

    public static void displayIndexes(int[] indexes) {
        if(null != indexes)
            System.out.println("Indexes are ["+ indexes[0]+"]["+indexes[1]+"]");
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param array
     * @param target
     */
    public static int[] findSumBrutForce(int[] array, int target) {

        for(int i=0; i<=array.length - 2; i++) {
            for(int j=i+1; j<=array.length-1; j++) {
                if(array[i] + array[j] == target) {
                    System.out.println("Indexes are ["+ i+"]["+j+"]");
                    return new int[]{i,j};
                }
            }
        }

        return null;
    }

    public static int[] findSumOptimized(int[] array, int target) {
        Map<Integer, Integer> numbersMap = new HashMap<>();
        int index = 0;

        while(index < array.length) {
            int diff = target - array[index];

            // check if map contains it
            if (numbersMap.containsKey(diff)) {
                return new int[]{index, numbersMap.get(diff)};
            } else {
                numbersMap.put(array[index], index);
            }

            index++;
        }

            return null;
    }
}
