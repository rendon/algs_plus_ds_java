import org.junit.*;
import com.inforscience.HashTable;

public class HashTableTest {
    @Test
    public void basicTests() {
        HashTable<Integer, Integer> ht = new HashTable<Integer, Integer>();
        for (int i = 0; i < 1000000; i++) {
            ht.put(i, i);
        }

        for (int i = 0; i < 1000000; i++) {
            Assert.assertEquals((Integer)i, ht.get(i));
        }
    }
}
