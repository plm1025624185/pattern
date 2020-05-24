package com.plm.pattern.util.dgc.wrapper;

import java.util.List;

/**
 * 构造方法
 * @author pankarl
 *
 */
public interface IDgcConstructMethodWrapper {
	String getName(); //类名
	
	List<String> listParametersName();
	
	List<String> listParametersTypeName();
	
	List<String> listParametersTypeSimpleName();
	
	String getContent(); //方法内容
}
