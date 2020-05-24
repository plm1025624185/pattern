package com.plm.pattern.util.dgc.wrapper;

import java.util.Set;

/**
 * 导包的包装类
 */
public interface IDgcImportPackageWrapper {
    /**
     * 获取导入包的全名
     * @return
     */
    Set<String> listImportNames();

    /**
     * 获取关键字
     * @return
     */
    Set<String> listKeyWords();
}
