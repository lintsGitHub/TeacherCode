package ttt;

import fruit.Apple;
import fruit.Banana;
import ioc.FruitShop;
import org.junit.Test;


public class ShopFactory {
    @Test
    public void testGetFruitFromShop () {
        FruitShop fruitShop = new FruitShop("fruits.xml");

        Apple a = (Apple) fruitShop.getFruit("apple");
        Banana b = (Banana) fruitShop.getFruit("banana");
        a.desc();
        b.desc();
    }
}

