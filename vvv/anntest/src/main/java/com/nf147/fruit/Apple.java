package com.nf147.fruit;


import com.nf147.anno.Bean;
import com.nf147.anno.Fruit;

@Bean("apple")
public class Apple {

    @Fruit(value = "heiheihie", xxx=3)
    public void desc () {
        System.out.println("我是苹果，我好吃。");
    }

    /**
     * 我的 hello 方法
     * @param name 表示传入的名字
     * @return 我也不知道
     * @throws Exception 如果这个名字不存在，那么抛异常
     */
    public String hello(String name) throws Exception {
        return null;
    }
}
