import com.company.BananaTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BananaTimeTest {
    private static BananaTime createObject() {
        return new BananaTime();
    }

    @Test
    public void testTime1() {
        BananaTime bananaTime = createObject();
        int[] piles = {30, 11, 23, 4, 20};

        Assert.assertEquals(30, bananaTime.minEatingTime(piles, 5));
    }

    @Test
    public void testTime2() {
        BananaTime bananaTime = createObject();
        int[] piles2 = {3,6,7,11};

        Assert.assertEquals(4, bananaTime.minEatingTime(piles2, 8));
    }

    @Test
    public void testTime3() {
        BananaTime bananaTime = createObject();
        int[] piles3 = {30,11,23,4,20};

        Assert.assertEquals(23, bananaTime.minEatingTime(piles3, 6));
    }
}
