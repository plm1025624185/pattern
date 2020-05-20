package com.plm.pattern.prototype;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author 潘磊明
 * @date 2020/5/20
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        NeedPrototypePojo source = new NeedPrototypePojo("张三", new Integer(18),
                1, Arrays.asList("看书", "看美女", "赚钱"));
        NeedPrototypePojo clone = source.clone();
        NeedPrototypePojo deepClone = source.deepClone();
        // ----------------数据是一样的--------------
        System.out.println("源数据：" + source.toString());
        System.out.println("浅拷贝数据：" + clone.toString());
        System.out.println("深拷贝数据：" + deepClone.toString());

        // ------------------查看引用----------------
        // 对象引用
        if (deepClone == source) System.out.println("深拷贝与源对象引用一致");
        else System.out.println("深拷贝与源对象引用不一致");
        if (clone == source) System.out.println("浅拷贝与源对象引用一致");
        else System.out.println("浅拷贝与源对象引用不一致");

        if (deepClone.getAge() == source.getAge()) System.out.println("深拷贝的Integer与源对象的Integer引用一致");
        else System.out.println("深拷贝的Integer与源对象的Integer引用不一致");
        if (clone.getAge() == source.getAge()) System.out.println("浅拷贝的Integer与源对象的Integer引用一致");
        else System.out.println("浅拷贝的Integer与源对象的Integer引用不一致");

        if (deepClone.getHobies() == source.getHobies()) System.out.println("深拷贝的List与源对象的List引用一致");
        else System.out.println("深拷贝的List与源对象的List引用不一致");
        if (clone.getHobies() == source.getHobies()) System.out.println("浅拷贝的List与源对象的List引用一致");
        else System.out.println("浅拷贝的List与源对象的List引用不一致");

        if (deepClone.getMemeber() == source.getMemeber()) System.out.println("深拷贝的对象与源对象的对象引用一致");
        else System.out.println("深拷贝的对象与源对象的对象引用不一致");
        if (clone.getHobies() == source.getHobies()) System.out.println("浅拷贝的对象与源对象的对象引用一致");
        else System.out.println("浅拷贝的对象与源对象的对象引用不一致");
    }
}
