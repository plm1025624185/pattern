# 设计模式

## 1.单例模式（创建型设计模式）

### 单例的几种方式

[参考singleton包](https://github.com/plm1025624185/pattern/tree/master/src/main/java/com/plm/pattern/singleton)

### 如何破坏单例

1. 使用反射可以进行破坏
2. 使用反序列化可以破坏

[参考util下的DestroyUtil类](https://github.com/plm1025624185/pattern/blob/master/src/main/java/com/plm/pattern/util/pattern/DestroyUtil.java)

### 如何防御ObjectInputStream的序列化

首先可以看下反序列化流程：

![](http://processon.com/chart_image/5ec481bbf346fb690705ac25.png)

防止ObjectInputStream反序列：

[可参考singleton下的HungrySingleton类](https://github.com/plm1025624185/pattern/blob/master/src/main/java/com/plm/pattern/singleton/HungrySingleton.java)

## 2.工厂相关模式（创建型设计模式）

[参考factory包](https://github.com/plm1025624185/pattern/tree/master/src/main/java/com/plm/pattern/factory)

## 3.原型模式

**浅拷贝**：拷贝的对象中如果属性存在引用，那么拷贝对象与源对象之间的对象属性指向同一个引用。

**深拷贝**：拷贝的对象与源对象是完全不相关的两个类

[参考prototype包](https://github.com/plm1025624185/pattern/tree/master/src/main/java/com/plm/pattern/prototype)

## 4.建造者模式

主要使用到了**链式调用**，即每次都返回当前实例

[参考builder包](https://github.com/plm1025624185/pattern/tree/master/src/main/java/com/plm/pattern/builder)

## 5.代理模式

[参考proxy包](https://github.com/plm1025624185/pattern/tree/master/src/main/java/com/plm/pattern/proxy)

### 5.1.静态代理实现

[参考StaticProxyHouseSale](https://github.com/plm1025624185/pattern/blob/master/src/main/java/com/plm/pattern/proxy/impl/StaticProxyHouseSale.java)

### 5.1.2.JDK动态代理实现

[参考JdkDynamicHouseSale](https://github.com/plm1025624185/pattern/blob/master/src/main/java/com/plm/pattern/proxy/impl/JdkDynamicHouseSale.java)

### 5.1.3.手写JDK动态代理实现思路

1. 用Java动态生成代理类的Java源码;
2. 将Java源码输出到磁盘上保存;
3. 将生成的.java文件进行编译，生成.class文件;
4. 将生成的.class文件加载进JVM中;
5. 返回动态生成的代理类

[手写JDK动态代理参考myjdkproxy包](https://github.com/plm1025624185/pattern/tree/master/src/main/java/com/plm/pattern/proxy/myjdkproxy)

[动态生成Java代理类流程参考MyJdkProxy的newProxyInstance方法](https://github.com/plm1025624185/pattern/blob/master/src/main/java/com/plm/pattern/proxy/myjdkproxy/MyJdkProxy.java)

[编译java文件参考JavaCompilerUtil](https://github.com/plm1025624185/pattern/blob/master/src/main/java/com/plm/pattern/util/compile/JavaCompilerUtil.java)

[动态生成Java源码参考dgc包](https://github.com/plm1025624185/pattern/tree/master/src/main/java/com/plm/pattern/util/dgc)