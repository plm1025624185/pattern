package com.plm.pattern.util.dgc.wrapper.myjdkproxy;

import java.util.Arrays;
import java.util.List;

import com.plm.pattern.proxy.myjdkproxy.MyJdkInvocationHandler;
import com.plm.pattern.util.dgc.wrapper.IDgcClassNameWrapper;
import com.plm.pattern.util.dgc.wrapper.IDgcConstructMethodWrapper;

public class DefaultConstructWrapper implements IDgcConstructMethodWrapper {
	
	private IDgcClassNameWrapper classNameWrapper;
	
	public DefaultConstructWrapper(IDgcClassNameWrapper classNameWrapper) {
		this.classNameWrapper = classNameWrapper;
	}

	@Override
	public String getName() {
		return classNameWrapper.getSimpleName();
	}

	@Override
	public List<String> listParametersTypeName() {
		return Arrays.asList(MyJdkInvocationHandler.class.getName());
	}

	@Override
	public List<String> listParametersTypeSimpleName() {
		return Arrays.asList(MyJdkInvocationHandler.class.getSimpleName());
	}

	@Override
	public String getContent() {
		StringBuilder sb = new StringBuilder();
		sb.append("super(");
		List<String> parametersName = listParametersName();
		for (int i = 0; i < parametersName.size(); i++) {
			if (i != 0) sb.append(", ");
			sb.append(parametersName.get(i));
		}
		sb.append(");");
		return sb.toString();
	}

	@Override
	public List<String> listParametersName() {
		return Arrays.asList("invocationhandler");
	}

}
