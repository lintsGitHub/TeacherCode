package com.nf147.ioc;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactorySingle implements Shop {

    private static Map<String, Object> beans = new HashMap<>();

    private BeanFactorySingle(String configXML) {
        try {
            // 解析 xml
            SAXReader reader = new SAXReader();
            URL resource = BeanFactorySingle.class.getClassLoader().getResource(configXML);
            Document document = null;
            document = reader.read(resource);

            List<Element> bs = document.getRootElement().elements();

            for (Element b : bs) {
                String name = b.attributeValue("id");
                String clazz = b.attributeValue("class");


                beans.put(name, Class.forName(clazz).newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("initialize fail");
        }
    }

    private static String config = null;

    public static BeanFactorySingle fetch(String s) {
        config = s;
        return HOLDER.SINGLE;
    }

    private static class HOLDER {
        private static final BeanFactorySingle SINGLE = new BeanFactorySingle(config);
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
