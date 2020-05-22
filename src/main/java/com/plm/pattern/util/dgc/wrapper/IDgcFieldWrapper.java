package com.plm.pattern.util.dgc.wrapper;

import java.util.Set;

/**
 * 约定只处理字段修饰符为private类型的
 */
public interface IDgcFieldWrapper {

	String PREFIX_NAME = "f";
	
	/**
	 * 获取字段名称
	 * @return
	 */
	String getName();
	
	/**
	 * 获取字段类型名称   包名 + 类名
	 * @return
	 */
	String getTypeName();

	/**
	 * 获取字段类型名称   类名
	 * @return
	 */
	String getSimpleTypeName();

	/**
	 * 获取字段的关键字
	 * @return
	 */
	Set<String> listKeyWords();
}
