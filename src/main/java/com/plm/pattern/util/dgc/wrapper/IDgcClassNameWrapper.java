package com.plm.pattern.util.dgc.wrapper;

/**
 * 类名相关的包装器
 * @author pankarl
 *
 */
public interface IDgcClassNameWrapper {

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
}
