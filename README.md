# 设计模式

## 目录

<a href="#Singleton">1.单例模式</a>
<a href="#Factory">2.工厂模式</a>

<a id="Singleton" name="Singleton"/>
## 1.单例模式（创建型设计模式）

### 适用场景

确保任何情况下都绝对只有一个实例

### 类图

![Singleton](http://processon.com/chart_image/5ecf3a1ae0b34d5f263709b9.png)

### 优点

1. 在内存中只有一个实例，减少了内存开销；
2. 可以避免对资源的多重占用；
3. 设置全局访问点，严格控制访问；

### 缺点

1. 没有接口，扩展困难；
2. 如果要扩展单例对象，只有修改代码；

### 单例的几种方式

|方式|优点|缺点|能否被单例破坏|能否被反序列化破坏|
|:-:|:-|:-|:-|:-|
|饿汉模式|执行效率高，性能高，没有加锁|某些情况下造成内存浪费|能|能|
|懒汉模式|节省内存|线程不安全|能|能|
|加同步锁模式|解决懒汉模式的线程不安全问题|性能低|能|能|
|双重检查模式|性能高，线程安全|可读性难度加大，不够优雅|能|能|
|静态内部私有类模式|写法优雅，利用了java本身语法特点|能够被反射破坏|能|能|
|枚举单例模式|更优雅的写法|不能大量的创建对象引起内存浪费|不能|不能|

[参考singleton包](https://github.com/plm1025624185/pattern/tree/master/src/main/java/com/plm/pattern/singleton)

### 如何破坏单例

1. 使用反射可以进行破坏
2. 使用反序列化可以破坏

[参考util下的DestroyUtil类](https://github.com/plm1025624185/pattern/blob/master/src/main/java/com/plm/pattern/util/pattern/DestroyUtil.java)

### 为什么枚举式不会被反射和序列化破坏

#### 枚举式不会被反射破坏

看Constructor类中的newInstance方法：

```
public T newInstance(Object ... initargs)
		throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException
{
	if (!override) {
		if (!Reflection.quickCheckMemberAccess(clazz, modifiers)) {
			Class<?> caller = Reflection.getCallerClass();
			checkAccess(caller, clazz, null, modifiers);
		}
	}
	// 如果被enum关键字修饰，调用实例化方法会直接抛出异常，所以可以防范反射
	if ((clazz.getModifiers() & Modifier.ENUM) != 0)
		throw new IllegalArgumentException("Cannot reflectively create enum objects");
	ConstructorAccessor ca = constructorAccessor;   // read volatile
	if (ca == null) {
		ca = acquireConstructorAccessor();
	}
	@SuppressWarnings("unchecked")
	T inst = (T) ca.newInstance(initargs);
	return inst;
}
```

#### 枚举式不会被序列化破坏

枚举类序列化读取流程图：

![枚举类序列化读取流程图](http://processon.com/chart_image/5ecf78425653bb79c1094fe9.png)

根据以上流程，可以发现核心方法是`Enum.valueOf((Class)cl, name)`，代码如下：

```
// Enum.valueOf((Class)cl, name)
public static <T extends Enum<T>> T valueOf(Class<T> enumType,
                                                String name) {
	// 会去查找枚举类中对应键值的实例
	T result = enumType.enumConstantDirectory().get(name);
	if (result != null)
		return result;
	if (name == null)
		throw new NullPointerException("Name is null");
	throw new IllegalArgumentException(
		"No enum constant " + enumType.getCanonicalName() + "." + name);
}

// enumType.enumConstantDirectory()方法
// 这里使用了懒加载，缺点也是在这里，加载的时候一次性将该枚举类下的实例全部加载进来了
// 这里可以看做使用了容器式单例模式，所以返回的永远是一个单例
Map<String, T> enumConstantDirectory() {
	if (enumConstantDirectory == null) {
		T[] universe = getEnumConstantsShared();
		if (universe == null)
			throw new IllegalArgumentException(
				getName() + " is not an enum type");
		Map<String, T> m = new HashMap<>(2 * universe.length);
		for (T constant : universe)
			m.put(((Enum<?>)constant).name(), constant);
		enumConstantDirectory = m;
	}
	return enumConstantDirectory;
}
```

### 其他模式如何防御反射

只需在构造方法中进行判断，如果实例已存在，则抛出异常，或直接返回实例

[可参考singleton下的PrivateStaticSingleton类](https://github.com/plm1025624185/pattern/blob/master/src/main/java/com/plm/pattern/singleton/PrivateStaticSingleton.java)

### 其他模式如何防御ObjectInputStream的序列化

首先可以看下反序列化流程：

![](http://processon.com/chart_image/5ec481bbf346fb690705ac25.png)

防止ObjectInputStream反序列：

[可参考singleton下的HungrySingleton类](https://github.com/plm1025624185/pattern/blob/master/src/main/java/com/plm/pattern/singleton/HungrySingleton.java)

### 源码中有哪些单例模式

ServletContext，ServletConfig，ApplicationContext

<a id="Factory" name="Factory" />
## 2.工厂相关模式（创建型设计模式）

### 类图

**简单工厂模式**

![SimpleFactory](http://processon.com/chart_image/5d674840e4b01acbdb8b9fd2.png)

**工厂方法模式**

![Factory](http://processon.com/chart_image/5ecfa9b61e08530a9b294d8f.png)

### 总结

|模式|适用场景|优点|缺点|例子|
|:-:|:-|:-|:-|
|简单工厂模式|适合创建较少对象|只需传入一个正确参数，就可以获取所需要的对象，无须知道创建细节|职责相对过重，增加新的产品需要修改工厂类的判断逻辑，违背开闭原则；<br/>不易于扩展复杂的产品结构；|Calender，LoggerFactory|
|工厂方法模式|创建对象需要大量重复代码;<br/>客户端（应用层）不依赖于产品实例如何被创建，实现等细节；<br/>一个类通过其子类来指定创建哪个对象；|用户只需关心所需产品对应的工厂，无需关心创建细节；<br/>加入新产品符合开闭原则，提高了系统的可扩展性；|类的个数容易过多，增加代码结构的复杂度；<br/>增加了系统的抽象性和理解难度；||

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