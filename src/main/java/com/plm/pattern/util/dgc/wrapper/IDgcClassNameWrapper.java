package com.plm.pattern.util.dgc.wrapper;

import java.util.List;
import java.util.Set;

/**
 * 类名相关的包装器
 * @author pankarl
 *
 */
public interface IDgcClassNameWrapper {

	String EXTENDS = "extends";
	String PUBLIC = "public";
	String IMPLEMENT = "implement";
	String CLASS = "class";

	/**
	 * 获取类名
	 * @return
	 */
	String getSimpleName();
	
	/**
	 * 获取包名加类名
	 * @return
	 */
	String getName();

	/**
	 * 获取继承的类名
	 * @return
	 */
	String getExtendsSimpleName();

	/**
	 * 获取继承的类全名
	 * @return
	 */
	String getExtendsName();

	/**
	 * 获取所有接口的类名
	 * @return
	 */
	Set<String> listInterfacesSimpleNames();

	/**
	 * 获取所有接口的类全名
	 * @return
	 */
	Set<String> listInterfacesNames();

	/**
	 * 获取列的关键字
	 * @return
	 */
	Set<String> listKeyWords();
}
