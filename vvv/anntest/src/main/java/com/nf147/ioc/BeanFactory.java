package com.nf147.ioc;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactory implements Shop {

    private static Map<String, Object> beans = new HashMap<>();

    public BeanFactory(String configXML) {
        try {
            // 解析 xml
            SAXReader reader = new SAXReader();
            URL resource = BeanFactory.class.getClassLoader().getResource(configXML);
            Document document = null;
            document = reader.read(resource);

            List<Element> bs = document.getRootElement().elements();

            for (Element b : bs) {
                String name = b.attributeValue("id");
                String clazz = b.attributeValue("class");


                beans.put(name, Class.forName(clazz).newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
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
