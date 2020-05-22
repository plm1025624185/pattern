package com.plm.pattern.singleton;

import com.plm.pattern.util.pattern.DestroyUtil;

/**
 * @author 潘磊明
 * @date 2020/5/19
 */
public class Test {

    public static void main(String[] args) throws Exception {
        // ----------------饿汉单例模式---------------
        HungrySingleton hs1 = HungrySingleton.getInstance();
        HungrySingleton hs2 = HungrySingleton.getInstance();
        if (hs1 == hs2) System.out.println("是单例模式");
        else System.out.println("不是单例模式");
        // -----------------打破单例模式----------------
        HungrySingleton dhs1 = DestroyUtil.reflect(HungrySingleton.class);
        HungrySingleton dhs2 = DestroyUtil.reflect(HungrySingleton.class);
        if (dhs1 == dhs2) System.out.println("反射打破单例模式失败");
        else System.out.println("反射成功打破单例模式");
        HungrySingleton ohs1 = HungrySingleton.getInstance();
        HungrySingleton ohs2 = DestroyUtil.objectStream(ohs1);
        if (ohs1 == ohs2) System.out.println("序列化打破单例模式失败");
        else System.out.println("序列化成功打破单例模式");

        // -----------------懒汉单例模式---------------
//        LazySingleton ls1 = LazySingleton.getInstance();
//        LazySingleton ls2 = LazySingleton.getInstance();
//        if (ls1 == ls2) System.out.println("是单例模式");
//        else System.out.println("不是单例模式");

        // -----------------枚举单例模式---------------
//        EnumSingleton es1 = EnumSingleton.INSTANCE;
//        EnumSingleton es2 = EnumSingleton.INSTANCE;
//        if (es1 == es2) System.out.println("是单例模式");
//        else System.out.println("不是单例模式");

        // -----------------静态内部类单例模式----------------
//        PrivateStaticSingleton pss1 = PrivateStaticSingleton.getInstance();
//        PrivateStaticSingleton pss2 = PrivateStaticSingleton.getInstance();
//        if (pss1 == pss2) System.out.println("是单例模式");
//        else System.out.println("不是单例模式");

        // -----------------容器单例模式---------------------
//        ContainerSingleton.registerInstance("test", new Object());
//        Object o1 = ContainerSingleton.getInstance("test");
//        Object o2 = ContainerSingleton.getInstance("test");
//        if (o1 == o2) System.out.println("是单例模式");
//        else System.out.println("不是单例模式");


    }
}
