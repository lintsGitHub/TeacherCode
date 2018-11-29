package com.nf147;

import com.nf147.anno.Fruit;
import com.nf147.fruit.Apple;
import com.nf147.fruit.Banana;
import com.nf147.fruit.Pear;
import com.nf147.ioc.BeanAnnoFactory;
import com.nf147.ioc.BeanFactory;
import com.nf147.ioc.BeanFactorySingle;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testFruit () {
        Apple apple = new Apple(); // 必须手动 new
        apple.desc();

        Banana banana = new Banana();
        banana.desc();
    }

    @Test
public void testGetFruitFromShop () throws Exception {
    BeanFactory beanFactory = new BeanFactory("fruits.xml");

    Apple a = (Apple) beanFactory.getBean("apple");
    Banana b = (Banana) beanFactory.getBean("banana");
    Pear p = (Pear) beanFactory.getBean("pear");

    a.desc();
    b.desc();
    p.sss();
    a.hello("ksjdfksd");
}

    @Test
    public void newShop () throws Exception {
        BeanFactory beanFactory = new BeanFactory("fruits.xml");
        System.out.println(beanFactory);
        System.out.println(beanFactory.count());
    }

            @Test
            public void testAnno () {
                // 反射
                Class<Apple> appleClass = Apple.class;
               // System.out.println(appleClass.isAnnotationPresent(Fruit.class));
                if(appleClass.isAnnotationPresent(Fruit.class)) {
                    Fruit annotation = appleClass.getAnnotation(Fruit.class);
                    String msg = annotation.value();
                    int count = annotation.xxx();

            for(int i = 0; i < count; i++) {
                System.out.println(msg);
            }

            System.out.println("----------------");

            for (Method method : appleClass.getMethods()) {

                Fruit annotation1 = method.getAnnotation(Fruit.class);
                if(annotation1 != null) {
                    System.out.println(method.getName());

                    System.out.println(annotation1);
                }
            }
        }


        Class<Banana> bananaClass = Banana.class;
        boolean annotationPresent = bananaClass.isAnnotationPresent(Fruit.class);
        System.out.println(annotationPresent);
    }

    @Test
    public void newAnooShop () throws Exception {
        BeanAnnoFactory beanFactory = BeanAnnoFactory.getInstance();
    }

    @Test
    public void validSingle () throws Exception {
        BeanAnnoFactory bf1 = BeanAnnoFactory.getInstance();
        BeanAnnoFactory bf2 = BeanAnnoFactory.getInstance();
        assert bf1.equals(bf2);

    }

    @Test
    public void testBFS () {
        // new BeanFactorySingle();

        // 我们要让这种 new 的方式失效
//        BeanFactorySingle beanFactorySingle = new BeanFactorySingle("fruits.xml");
//        System.out.println(beanFactorySingle);

        // 我们要让 BFS 提供 fetch
        BeanFactorySingle bfs1 = BeanFactorySingle.fetch("fruits.xml");
        BeanFactorySingle bfs2 = BeanFactorySingle.fetch("fruits.xml");

        // 保证这个是正确的，也就是能从容器里合理拿到东西
        System.out.println(bfs1.getBean("apple"));
        System.out.println("");
        // 保证两次获取容器，得到的容器是同一个
        assert bfs1.equals(bfs2);
    }
}