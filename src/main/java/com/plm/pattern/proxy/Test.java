package com.plm.pattern.proxy;

import com.plm.pattern.proxy.impl.DefaultHouseSale;
import com.plm.pattern.proxy.impl.JdkDynamicHouseSale;
import com.plm.pattern.proxy.impl.StaticProxyHouseSale;
import sun.misc.ProxyGenerator;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author 潘磊明
 * @date 2020/5/20
 */
public class Test {
    public static void main(String[] args) throws IOException {
        IHouseSale houseSale = new DefaultHouseSale();
        JdkDynamicHouseSale proxyObj = new JdkDynamicHouseSale();

//        // ------------------静态代理-----------------
//        IHouseSale staticHouseSale = new StaticProxyHouseSale(houseSale);
//        staticHouseSale.saleHourse();

        // ------------------JDK动态代理-----------------
        IHouseSale jdkDynamicHouseSale =  (IHouseSale)proxyObj.getInstance(houseSale);
        jdkDynamicHouseSale.saleHourse();
        // -------------------查看jdk动态代理代码----------------------
        String proxyName = "$Proxy0";  // 可以debug查看代理类的名字
        Class<?> clazz = houseSale.getClass();
        // 获取字节流
        byte[] bytes = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());
        // 写入到文件中
        String filePath = clazz.getResource(".").getPath();
        System.out.println("文件路径:" + filePath);
        OutputStream outputStream = new FileOutputStream(new File(filePath + proxyName + ".class"));
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }
}
