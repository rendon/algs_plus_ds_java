import org.junit.*;
import com.inforscience.HashTable;
import com.inforscience.HashTableLP;

public class HashTableTest {
    @Test
    public void testHashTableSeparateChaining() {
        HashTable<Integer, Integer> ht = new HashTable<Integer, Integer>();
        for (int i = 0; i < 1000000; i++) {
            ht.put(i, i);
        }

        for (int i = 0; i < 1000000; i++) {
            Assert.assertEquals((Integer)i, ht.get(i));
        }
    }

    @Test
    public void testHashTableLinearProbing() {
        HashTableLP<Integer, Integer> ht = new HashTableLP<Integer, Integer>();
        for (int i = 0; i < 1000000; i++) {
            ht.put(i, i);
        }

        for (int i = 0; i < 1000000; i++) {
            Assert.assertEquals((Integer)i, ht.get(i));
        }
    }
}
