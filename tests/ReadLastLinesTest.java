import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

import com.inforscience.ReadLastLines;

public class ReadLastLinesTest {
    @Test(expected = NullPointerException.class)
    public void nullReaderShouldThrowNullPointerException()
    {
        ReadLastLines lineReader = new ReadLastLines();
        lineReader.lastK(null, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void negativeKShouldReturnIndexOutOfBoundsException()
    {
        ReadLastLines lineReader = new ReadLastLines();
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        lineReader.lastK(reader, 0);
    }

    @Test
    public void normalBehavior()
    {
        String lines = "";
        for (int i = 0; i < 10; i++) {
            lines += "Line #" + i + "\n";
        }

        BufferedReader reader = new BufferedReader(new StringReader(lines));
        ReadLastLines lineReader = new ReadLastLines();

        ArrayList<String> answer1 = new ArrayList<String>();
        answer1.add("Line #9");
        ArrayList<String> result1 = lineReader.lastK(reader, 1);
        Assert.assertEquals(answer1.size(), result1.size());
        for (int i = 0; i < result1.size(); i++) {
            Assert.assertEquals(answer1.get(i), result1.get(i));
        }


        ArrayList<String> answer2 = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            answer2.add("Line #" + i);
        }

        reader = new BufferedReader(new StringReader(lines));
        ArrayList<String> result2 = lineReader.lastK(reader, 10);
        Assert.assertEquals(answer2.size(), result2.size());
        for (int i = 0; i < result2.size(); i++) {
            Assert.assertEquals(answer2.get(i), result2.get(i));
        }
    }
}
