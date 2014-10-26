import org.junit.*;
import com.inforscience.BalancedBinarySearchTree;

public class BalancedBinarySearchTreeTest {
    @Test
    public void insertionAndBfsTest() {
        BalancedBinarySearchTree<Integer, Integer> bbst =
            new BalancedBinarySearchTree<Integer, Integer>();

        for (int i = 0; i < 1000; i++) {
            bbst.insert(i, i);
        }

        bbst.bfs();
        System.out.println();
    }
}
