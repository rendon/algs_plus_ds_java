import org.junit.*;
import com.inforscience.BinarySearchTree;

public class BinarySearchTreeTest {
    @Test
    public void testBreadthFirstSearch() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        for (int i = 0; i < 1000; i++) {
            bst.insert(i);
        }

        bst.bfs();
    }
}
