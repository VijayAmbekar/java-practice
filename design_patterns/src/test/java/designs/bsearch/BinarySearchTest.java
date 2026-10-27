package designs.bsearch;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BinarySearchTest {

    @InjectMocks
    BinarySearch binarySearch;

    public void setUp (){
        binarySearch = new BinarySearch();
    }

    @Test
    public void testBSearch() {
        int[] array = new int[]{1,2,3,4,7,10};
        int target = 4;

        assertEquals(3,binarySearch.bsearch(array,target));
        assertEquals(4,binarySearch.bsearch(new int[]{-1,0,3,5,9,12},9));
    }
}