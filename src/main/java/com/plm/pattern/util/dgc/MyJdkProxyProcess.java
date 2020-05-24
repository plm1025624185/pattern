package com.plm.pattern.util.dgc;

import java.util.Collection;
import java.util.List;

import com.plm.pattern.util.dgc.wrapper.IDgcClassNameWrapper;
import com.plm.pattern.util.dgc.wrapper.IDgcConstructMethodWrapper;
import com.plm.pattern.util.dgc.wrapper.IDgcFieldWrapper;
import com.plm.pattern.util.dgc.wrapper.IDgcMethodWrapper;
import com.plm.pattern.util.dgc.wrapper.IDgcStaticWrapper;

public class MyJdkProxyProcess implements IDgcProcess {
	
	private String SPACE = "\r\n";
	
	private IGenerateClassAbstractFactory factory;
	
	private String packageString;
	private String importString;
	private String classStartString;
	private String classEndString;
	private String fieldString;
	private String constructString;
	private String methodString;
	private String staticString;
	
	
	
	
	public MyJdkProxyProcess(IGenerateClassAbstractFactory factory) {
		this.factory = factory;
	}

	@Override
	public String process() {
		generatePackageString();
		generateImportString();
		generateClassStartString();
		generateConstructString();
		generateFieldString();
		generateMethodString();
		generateStaticString();
		generateClassEndString();
		StringBuilder str = new StringBuilder();
		str.append(packageString);
		str.append(SPACE);
		str.append(importString);
		str.append(SPACE);
		str.append(classStartString);
		str.append(SPACE);
		str.append(fieldString);
		str.append(SPACE);
		str.append(constructString);
		str.append(SPACE);
		str.append(methodString);
		str.append(SPACE);
		str.append(staticString);
		str.append(classEndString);
		return str.toString();
	}
	
	private void generatePackageString() {
		this.packageString = String.format("package %s;", this.factory.generatePackage().getName());
	}
	
	private void generateImportString() {
		StringBuilder importStr = new StringBuilder();
		String template = "import %s;" + SPACE; 
		for(String str : this.factory.generateImportPackage().listImportNames()) {
			importStr.append(String.format(template, str));
		}
		this.importString = importStr.toString();
	}
	
	private void generateClassStartString() {
		IDgcClassNameWrapper classNameWrapper = factory.generateClassName();
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("public class %s", classNameWrapper.getSimpleName()));
		if (hasText(classNameWrapper.getExtendsSimpleName())) {
			sb.append(String.format(" extends %s", classNameWrapper.getExtendsSimpleName()));
		}
		if (!isCollectionEmpty(classNameWrapper.listInterfacesSimpleNames())) {
			sb.append(" implements ");
			boolean flag = false;
			for (String inter : classNameWrapper.listInterfacesSimpleNames()) {
				if (flag) sb.append(", ");
				sb.append(inter);
			}
		}
		sb.append(" {" + SPACE);
		this.classStartString = sb.toString();
	}
	
	private void generateFieldString() {
		List<? extends IDgcFieldWrapper> fields = factory.generateFields();
		StringBuilder sb = new StringBuilder();
		for (IDgcFieldWrapper field : fields) {
			sb.append(String.format("private static %s %s;" + SPACE, field.getSimpleTypeName(), field.getName()));
		}
		this.fieldString = sb.toString();
	}
	
	private void generateMethodString() {
		List<? extends IDgcMethodWrapper> methods = factory.generateMethods();
		StringBuilder sb = new StringBuilder();
		for (IDgcMethodWrapper method : methods) {
			sb.append(String.format("public final %s %s (", method.getReturnTypeSimpleName(), method.getName()));
			List<String> parameters = method.listParameters();
			List<String> parametersType = method.listParametersTypeSimpleName();
			for (int i = 0; i < parameters.size(); i++) {
				if (i != 0) sb.append(", ");
				sb.append(String.format("%s %s", parametersType.get(i), parameters.get(i)));
			}
			sb.append(") {" + SPACE);
			sb.append(method.getContent() + SPACE + "}" + SPACE);
		}
		this.methodString = sb.toString();
	}
	
	private void generateConstructString() {
		List<? extends IDgcConstructMethodWrapper> constructMethodWrapper = factory.generateConstructMethods();
		StringBuilder sb = new StringBuilder();
		for (IDgcConstructMethodWrapper construct : constructMethodWrapper) {
			sb.append(String.format("public %s (", construct.getName()));
			List<String> parameters = construct.listParametersName();
			List<String> parametersType = construct.listParametersTypeSimpleName();
			for (int i = 0; i < parameters.size(); i++) {
				if (i != 0) sb.append(", ");
				sb.append(String.format("%s %s", parametersType.get(i), parameters.get(i)));
			}
			sb.append(") {" + SPACE);
			sb.append(construct.getContent() + SPACE);
			sb.append("}" + SPACE);
		}
		this.constructString = sb.toString();
	}
	
	private void generateStaticString() {
		IDgcStaticWrapper staticWrapper = factory.generateStaticMethods();
		StringBuilder sb = new StringBuilder();
		sb.append("static {" + SPACE);
		sb.append(staticWrapper.getStaticBlock() + SPACE);
		sb.append("}" + SPACE);
		this.staticString = sb.toString();
	}
	
	private void generateClassEndString() {
		this.classEndString = "}";
	}
	
	private boolean hasText(String str) {
		if (str == null || str.trim() == "") return false;
		else return true;
	}
	
	private boolean isCollectionEmpty(Collection<?> collection) {
		if (collection == null || collection.size() == 0) return true;
		else return false;
	}
}
