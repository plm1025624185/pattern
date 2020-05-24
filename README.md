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