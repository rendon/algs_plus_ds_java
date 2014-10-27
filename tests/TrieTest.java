import org.junit.*;
import java.util.ArrayList;

import com.inforscience.Node;
import com.inforscience.Trie;
public class TrieTest {
    private ArrayList<String> solutions = new ArrayList<String>();
    private void find(Trie trie, String sentence, char[] spaces, int pos) {
        if (pos == sentence.length()) {
            StringBuffer sol = new StringBuffer();
            for (int i = 0; i < sentence.length(); i++) {
                sol.append(sentence.charAt(i));
                if (spaces[i] == ' ') {
                    sol.append(' ');
                }
            }
            solutions.add(sol.toString());
        } else {
            Node current = trie.getCurrent();
            char k = sentence.charAt(pos);
            if (trie.isEndOfWord()) {
                trie.reset();
                if (trie.move(k)) {
                    spaces[pos-1] = ' ';
                    find(trie, sentence, spaces, pos + 1);
                    spaces[pos-1] = '-';
                }
                trie.setCurrent(current);
            }

            if (trie.move(k)) {
                find(trie, sentence, spaces, pos + 1);
                trie.setCurrent(current);
            }
        }
    }

    public void find(ArrayList<String> dict, String sentence) {
        Trie trie = new Trie(dict);
        solutions.clear();
        char[] spaces = sentence.toCharArray();
        find(trie, sentence, spaces, 0);
    }

    @Test
    public void testFastMan() {
        ArrayList<String> dict = new ArrayList<String>();
        dict.add("fast");
        dict.add("man");
        String sentence = "fastman";
        find(dict, sentence);
        Assert.assertEquals(1, solutions.size());
        Assert.assertEquals("fast man", solutions.get(0));
    }

    @Test
    public void testTheNoteBookIsAllRight() {
        ArrayList<String> dict = new ArrayList<String>();
        dict.add("the");
        dict.add("note");
        dict.add("book");
        dict.add("notebook");
        dict.add("is");
        dict.add("all");
        dict.add("right");
        dict.add("allright");
        String sentence = "thenotebookisallright";
        find(dict, sentence);

        Assert.assertEquals(4, solutions.size());
        Assert.assertEquals("the note book is all right", solutions.get(0));
        Assert.assertEquals("the note book is allright", solutions.get(1));
        Assert.assertEquals("the notebook is all right", solutions.get(2));
        Assert.assertEquals("the notebook is allright", solutions.get(3));
    }
}
