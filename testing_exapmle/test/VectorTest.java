import org.junit.Assert;
import org.junit.Test;

public class VectorTest {

    Vector vector;

    @Test
    public void testAdd() {
        vector = new Vector(1, 2, 3);
        Vector vector1 = new Vector(3, 2, 1);
        Assert.assertEquals(new Vector(4, 4, 4),
                vector.add(vector1));
    }

    @Test
    public void testSubstract() {
        vector = new Vector(1, 2, 3);
        Vector vector1 = new Vector(3, 2, 1);
        Assert.assertEquals(new Vector(-2, 0, 2),
                vector.substract(vector1));
    }

    @Test
    public void test() {
        vector = new Vector(1, 2, 3);
        Vector vector1 = new Vector(3, 2, 1);
        Assert.assertEquals(new Vector(4, 4, 4),
                vector.add(vector1));
    }
}
