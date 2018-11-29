package ttt;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import xxx.Calculator;
import xxx.ICal;
import static org.junit.Assert.*;


@RunWith(BlockJUnit4ClassRunner.class)
public class CalculatorTest {
    ICal calculator = new Calculator();

    @Test
    public void testAdd() {
        assert calculator.add(2, 4) == 6;
        assert calculator.add(-2, -4) == -6;
        assert calculator.add(2, -4) == -2;
        assert calculator.add(0, 4) == 4;
        assert calculator.add(0, 0) == 0;
    }

    @Test
    @Ignore("项目经理说，先把这个功能留着，他们给钱再加上")
    public void testSub() {
        assert calculator.sub(2, 4) == -2; // 断言

    }

    @Test
    public void testDiv() {
        assert calculator.div(2, 4) == 0.5; // 断言
        assert calculator.div(100, 0) == 666;
        assert calculator.div(-100, 0) == 666;
        assert calculator.div(0, 0) == 0;
    }

    @Test
    public void testProd () {

    }
}
