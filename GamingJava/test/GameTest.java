import model.Game;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    private Game game;

    @Test
    public void testLess() {
        game = new Game();
        String result = game.checkNumber(game.getRandomNumber() - 2);
        Assert.assertEquals("more", result);
    }

    @Test
    public void testEqual() {
        game = new Game();
        String result = game.checkNumber(game.getRandomNumber());
        Assert.assertTrue(result.equals("equal"));
    }

    @Test
    public void testMore() {
        game = new Game();
        String result = game.checkNumber(game.getRandomNumber() + 5);
        Assert.assertNotEquals("more", result);
        Assert.assertNotEquals("equal", result);
    }

}
