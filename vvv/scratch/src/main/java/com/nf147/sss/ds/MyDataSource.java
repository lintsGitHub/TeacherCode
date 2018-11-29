package com.nf147.sss.ds;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

public class MyDataSource extends UnpooledDataSourceFactory {
    public MyDataSource() {
        this.dataSource = new ComboPooledDataSource();
        ((ComboPooledDataSource) this.dataSource).setCheckoutTimeout(30);
    }
}
