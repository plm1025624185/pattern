package com.plm.pattern.util.dgc.wrapper;

import java.util.List;
import java.util.Set;

/**
 * 方法包装类，默认处理的方法都是public修饰的
 */
public interface IDgcMethodWrapper {
    /**
     * 获取方法名
     * @return
     */
    String getName();

    /**
     * 获取方法参数 例如： test(String arg0, Integer arg1)
     * @return
     */
    List<String> listParameters();

    /**
     * 获取方法参数类型全名
     * @return
     */
    List<String> listParametersTypeName();

    /**
     * 因为方法可以重载，这里使用list
     * 获取方法参数类型简称
     * @return
     */
    List<String> listParametersTypeSimpleName();

    /**
     * 获取返回类型全名
     * @return
     */
    String getReturnTypeName();

    /**
     * 获取返回类型简称
     * @return
     */
    String getReturnTypeSimpleName();

    /**
     * 获取关键字
     * @return
     */
    Set<String> listKeyWords();
    
    /**
     * 获取方法体内容
     * @return
     */
    String getContent();
    
    /**
     * 获取异常信息
     * @return
     */
    List<String> listThrowablesName();
    
    /**
     * 获取异常信息
     * @return
     */
    List<String> listThrowableSimpleName();
    
    /**
     * 获取方法体中所有引用的包
     * @return
     */
    List<String> listContentImportClasses();
}
