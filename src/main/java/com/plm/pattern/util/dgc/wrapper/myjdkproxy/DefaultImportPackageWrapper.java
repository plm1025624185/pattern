package com.plm.pattern.util.dgc.wrapper.myjdkproxy;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.plm.pattern.proxy.myjdkproxy.MyJdkProxy;
import com.plm.pattern.util.dgc.wrapper.IDgcImportPackageWrapper;

public class DefaultImportPackageWrapper implements IDgcImportPackageWrapper {
	
	private Class<?>[] interfaces;
	
	private String DEFAULT_IMPORT = "java.lang.reflect.*"; // 默认导包
	
	private List<DefaultFieldWrapper> fields;
	
	private List<DefaultMethodWrapper> methods;
	
	public DefaultImportPackageWrapper(Class<?>[] interfaces, List<DefaultFieldWrapper> fields, 
			List<DefaultMethodWrapper> methods) {
		this.interfaces = interfaces;
		this.fields = fields;
		this.methods = methods;
	}

	@Override
	public Set<String> listImportNames() {
		Set<String> set = new LinkedHashSet<>();
		set.add(DEFAULT_IMPORT);
		set.add(MyJdkProxy.class.getName()); //继承类
		for (Class<?> inter : interfaces) {  //接口
			if (!isNeedImport(inter.getName())) continue;
			set.add(inter.getName());
		}
		for (DefaultFieldWrapper field : fields) {
			if (!isNeedImport(field.getTypeName())) continue;
			set.add(field.getTypeName());
		}
		for (DefaultMethodWrapper method : methods) {
			if (isNeedImport(method.getReturnTypeName())) {
				set.add(method.getReturnTypeName());
			}
			for (String parameter : method.listParametersTypeName()) {
				if (!isNeedImport(parameter)) continue;
				set.add(parameter);
			}
		}
		return set;
	}

	@Override
	public Set<String> listKeyWords() {
		return Collections.emptySet();
	}
	
	private boolean isNeedImport(String name) {
		if (name == null || name.trim() == "" || name.contains("java.lang") 
				|| "void".equals(name)) return false;
		else return true;
	}
}
