import org.junit.*;

import com.inforscience.LinkedList;

public class LinkedListTest {
    @Test
    public void testAddAndRemoveFromLinkedList() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i * i);
        }

        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(new Integer(i * i).equals(list.getFirst()));
            System.out.print(list.remove() + " ");
        }

        System.out.println();
    }
}
