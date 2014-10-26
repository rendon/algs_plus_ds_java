import org.junit.*;

import com.inforscience.BinarySearchTreeMap;

public class BinarySearchTreeMapTest {
    @Test
    public void testMap() {
        BinarySearchTreeMap<Integer, String> map =
            new BinarySearchTreeMap<Integer, String>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");


        Assert.assertEquals("One", map.get(1));
        Assert.assertEquals("Two", map.get(2));
        Assert.assertEquals("Three", map.get(3));
        Assert.assertEquals("Four", map.get(4));
        Assert.assertEquals("Five", map.get(5));
        Assert.assertEquals("Six", map.get(6));

        map.delete(1);
        map.delete(2);
        map.delete(3);
        map.delete(4);
        Assert.assertEquals(null, map.get(1));
        Assert.assertEquals(null, map.get(2));
        Assert.assertEquals(null, map.get(3));
        Assert.assertEquals(null, map.get(4));
    }
}
