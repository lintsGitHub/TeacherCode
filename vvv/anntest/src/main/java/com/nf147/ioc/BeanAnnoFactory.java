package com.nf147.ioc;

import com.nf147.anno.Bean;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BeanAnnoFactory implements Shop {
    private static Map<String, Object> beans = new HashMap<>();

    static class Singletion {
        private final static BeanAnnoFactory INSTANCE = new BeanAnnoFactory();
    }
    public static BeanAnnoFactory getInstance() {
        return Singletion.INSTANCE;
    }
    private BeanAnnoFactory() {
        // 1. 找到 com.nf147 下面的所有的类
        // 2. 遍历每一个类，判断是否有 @Bean 注解
        // 3. 如果有注解，那么获取注解，并将类实例化放入 bf
        Reflections reflections = new Reflections("com.nf147");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Bean.class);

        for (Class<?> aClass : classes) {
            Bean annotation = aClass.getAnnotation(Bean.class);
            String name = annotation.value();
            try {
                beans.put(name, aClass.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

        @Override
        public Object getBean(String name) {
            // 根据名字，返回对象即可
            return beans.get(name);
        }


    public int count() {
        return beans.size();
    }
}
