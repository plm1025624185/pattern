package com.plm.pattern.util.dgc;

import java.util.List;

import com.plm.pattern.util.dgc.wrapper.IDgcClassNameWrapper;
import com.plm.pattern.util.dgc.wrapper.IDgcFieldWrapper;
import com.plm.pattern.util.dgc.wrapper.IDgcImportPackageWrapper;
import com.plm.pattern.util.dgc.wrapper.IDgcMethodWrapper;
import com.plm.pattern.util.dgc.wrapper.IDgcPackageWrapper;

/**
 * 动态生成Java类的工厂，这里使用抽象工厂模式，
 * 返回值使用包装类，方便以后进行统一处理
 * @author pankarl
 *
 */
public interface IGenerateClassAbstractFactory {
	String LINE_BREAK = "\r\n";  // 换行符
	
	/**
	 * 生成包名
	 * @return
	 */
	IDgcPackageWrapper generatePackage();
	
	/**
	 * 生成引用包
	 * @return
	 */
	List<IDgcImportPackageWrapper> generateImportPackages();
	
	/**
	 * 生成类名
	 * @return
	 */
	IDgcClassNameWrapper generateClassName();
	
	/**
	 * 生成私有属性
	 * @return
	 */
	List<IDgcFieldWrapper> generateFields();
	
	/**
	 * 生成方法
	 * @return
	 */
	List<IDgcMethodWrapper> generateMethods();

	

}
