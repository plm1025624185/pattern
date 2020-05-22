package com.plm.pattern.util.dgc.wrapper;

public interface IDgcFieldWrapper {
	
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
}
