import org.junit.*;
import com.inforscience.BinarySearchTree;

public class BinarySearchTreeTest {
    @Test
    public void testBreadthFirstSearch() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert(7);
        bst.insert(3);
        bst.insert(9);
        bst.insert(1);
        bst.insert(10);
        bst.insert(5);
        bst.insert(5);
        bst.insert(5);
        bst.insert(5);
        bst.insert(17);
        bst.insert(20);
        bst.insert(90);
        bst.insert(0);
        bst.bfs();

        System.out.println();
        bst.dfs();
    }
}
