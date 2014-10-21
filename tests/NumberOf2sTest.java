import org.junit.*;

import com.inforscience.NumberOf2s;

public class NumberOf2sTest {
    @Test
    public void basicTests()
    {
        NumberOf2s n2 = new NumberOf2s();
        for (int i = 1; i < 1234; i++) {
            Assert.assertEquals(n2.g(i), n2.f(i));
        }
    }
}
