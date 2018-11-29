package com.nf147;

import com.nf147.fruit.Apple;
import com.nf147.ioc.BeanAnnoFactory;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, URISyntaxException, InstantiationException, IllegalAccessException {
        BeanAnnoFactory bf = BeanAnnoFactory.getInstance();
        System.out.println(bf.getBean("bbb"));
        Apple apple = (Apple) bf.getBean("apple");
        apple.desc();
    }
}
