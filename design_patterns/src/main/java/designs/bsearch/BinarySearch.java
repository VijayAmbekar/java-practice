package designs.bsearch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinarySearch {

    /**
     * return index of the target in the array if found else -1
     * @param array
     * @param target
     * @return
     */
    public int bsearch(int[] array, int target) {
        boolean found = false;
        var left = 0;
        var right = array.length -1;

        if (target == array[left]) return left;
        if (target == array[right]) return right;


        while (left <= right) {

            int mid = (left + right)/2;

            log.info("mid {}: item: {}", mid, array[mid]);

            if(target == array[mid]) return mid;

            if(target < array[mid]) {
                right = mid-1;
            } else {
                left = mid + 1;
            }

            log.info("left: {} right: {}", left, right);
        }

        return -1;
    }
}
