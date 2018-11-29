package ttt;

import fruit.Apple;
import fruit.Banana;
import org.junit.Test;

public class FruitTest {
    @Test
    public void testFruit () {
        Apple apple = new Apple(); // 必须手动 new
        apple.desc();

        Banana banana = new Banana();
        banana.desc();
    }
}
