import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;

import com.inforscience.OrderStatistics;

public class TestOrderStatistics {
    @Test
    public void findK()
    {
        int[] in1 = new int[] {9, 5, 1, 12, 15, 4, 7, 14, 3, 8, 0, 11, 17};
        Assert.assertEquals(0, new OrderStatistics(in1).findK(1));
        Assert.assertEquals(17, new OrderStatistics(in1).findK(13));
        Assert.assertEquals(11, new OrderStatistics(in1).findK(9));
        Assert.assertEquals(3, new OrderStatistics(in1).findK(3));
    }
}
