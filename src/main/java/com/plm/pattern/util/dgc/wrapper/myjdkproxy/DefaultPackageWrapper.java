package com.plm.pattern.util.dgc.wrapper.myjdkproxy;

import com.plm.pattern.util.dgc.wrapper.IDgcPackageWrapper;

public class DefaultPackageWrapper implements IDgcPackageWrapper {
	
	public Class<?> target;
	
	public DefaultPackageWrapper(Class<?> target) {
		this.target = target;
	}

	@Override
	public String getName() {
		/**
		 * 生成的代理类在目标类的包下
		 */
		return this.target.getPackage().getName();
	}

}
