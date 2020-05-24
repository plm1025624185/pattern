package com.plm.pattern.util.dgc.wrapper.myjdkproxy;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.plm.pattern.util.dgc.wrapper.IDgcMethodWrapper;

public class DefaultMethodWrapper implements IDgcMethodWrapper {
	
	private String SPACE = "\r\n";
	
	private DefaultFieldWrapper defaultFieldWrapper; //需要用到的属性
	
	private Class<?>[] parameterTypes;
	
	private Class<?> returnType;
	
	public DefaultMethodWrapper(DefaultFieldWrapper defaultFieldWrapper) {
		this.defaultFieldWrapper = defaultFieldWrapper;
		this.parameterTypes = defaultFieldWrapper.getMethod().getParameterTypes();
		this.returnType = defaultFieldWrapper.getMethod().getReturnType();
	}

	@Override
	public String getName() {
		return defaultFieldWrapper.getMethod().getName();
	}

	@Override
	public List<String> listParameters() {
		List<String> array = new LinkedList<>();
		for (int i = 0; i < parameterTypes.length; i++) {array.add("arg" + i);}
		return array;
	}

	@Override
	public List<String> listParametersTypeName() {
		List<String> array = new LinkedList<>();
		for (int i = 0; i < parameterTypes.length; i++) array.add(parameterTypes[i].getName());
		return array;
	}

	@Override
	public List<String> listParametersTypeSimpleName() {
		List<String> array = new LinkedList<>();
		for (int i = 0; i < parameterTypes.length; i++) array.add(parameterTypes[i].getSimpleName());
		return array;
	}

	@Override
	public String getReturnTypeName() {
		return returnType.getName();
	}

	@Override
	public String getReturnTypeSimpleName() {
		return returnType.getSimpleName();
	}

	@Override
	public Set<String> listKeyWords() {
		Set<String> set = new LinkedHashSet<>();
		set.add("final");
		return set;
	}

	@Override
	public String getContent() {
		StringBuilder sb = new StringBuilder();
		if (!"void".equals(getReturnTypeName())) 
			sb.append("return (" + getReturnTypeSimpleName() + ") ");
		sb.append("super.h.invoke(this, ");
		sb.append(defaultFieldWrapper.getName());
		sb.append(", new Object[]{");
		List<String> parameters = listParameters();
		for (int i = 0; i < parameters.size(); i++) {
			if (i != 0) sb.append(", ");
			sb.append(parameters.get(i));
		}
		sb.append("});");
		return generateTryCatch(sb.toString());
	}

	@Override
	public List<String> listThrowablesName() {
		return Collections.emptyList();
	}

	@Override
	public List<String> listThrowableSimpleName() {
		return Collections.emptyList();
	}
	
	/**
	 * 生成try catch
	 * @param content
	 * @return
	 */
	public String generateTryCatch(String content) {
		StringBuilder sb = new StringBuilder();
		sb.append("try {" + SPACE);
		sb.append(content + SPACE);
		sb.append("} catch (Error _ex) {throw new Error(_ex.getMessage());}" + SPACE);
		sb.append("catch (Throwable throwable){ throw new UndeclaredThrowableException(throwable);}" + SPACE);
		return sb.toString();
	}


	@Override
	public List<String> listContentImportClasses() {
		return Collections.emptyList();
	}}
