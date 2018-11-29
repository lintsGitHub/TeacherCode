package com.nf147.sss.handler;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class OurObjectFactory extends DefaultObjectFactory {
    @Override
    public <T> T create(Class<T> type) {
        System.out.println("拒绝配合");
        return null;
    }
}
