package com.plm.pattern.util.pattern;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 破坏单例的工具类
 * @author 潘磊明
 * @date 2020/5/19
 */
public class DestroyUtil {
    /**
     * 使用反射破坏单例
     * @param clazz
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <T>T reflect(Class<T> clazz) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 获取私有构造方法
        Constructor con = clazz.getDeclaredConstructor();
        // 暴力破解
        con.setAccessible(true);
        return clazz.cast(con.newInstance());
    }

    /**
     * 使用序列化破坏单例
     * @param obj
     * @return
     */
    public static <T>T objectStream(T obj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream os = new ByteArrayOutputStream(1024);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
        InputStream is = new ByteArrayInputStream(os.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(is);
        Object tmp = objectInputStream.readObject();
        objectInputStream.close();
        return (T)tmp;
    }
}
