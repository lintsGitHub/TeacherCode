package com.nf147.sss.plugin;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

// 拦截器
@Intercepts({@Signature(
        type= Executor.class,
        method = "update",
        args = {MappedStatement.class,Object.class})})
public class MyPlugin implements Interceptor {

    private String dbType;

    // 定义拦截策略
    public Object intercept(Invocation invocation) throws Throwable {
        invocation.getTarget();
        invocation.getMethod();
        invocation.getArgs();

        System.out.println("拦截方面的工作，交给我");
        if (dbType.equals("mysql")) {

        } else {

        }
        return invocation.proceed();
    }
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
//    获取定义处传进来的参数
    public void setProperties(Properties properties) {
        System.out.println(properties.getProperty("msg")); // hello world
        dbType = properties.getProperty("dbType");
    }
}