package com.plm.pattern.util.dgc.wrapper.myjdkproxy;


import java.util.List;

import com.plm.pattern.util.dgc.wrapper.IDgcStaticWrapper;

public class DefaultStaticWrapper implements IDgcStaticWrapper {

	private String SPACE = "\n\r";
	
	private List<DefaultFieldWrapper> list;
	
	public DefaultStaticWrapper(List<DefaultFieldWrapper> list) {
		this.list = list;
	}
	
	@Override
	public String getStaticBlock() {
		StringBuilder sb = new StringBuilder();
		list.stream().forEach(e -> {
			sb.append(e.getName());
			sb.append(" = Class.forName(\"");
			sb.append(e.getMethod().getDeclaringClass().getName());
			sb.append("\").getMethod(\"");
			sb.append(e.getMethod().getName());
			sb.append("\", new Class[]{");
			Class<?>[] clazzArray = e.getMethod().getParameterTypes();
			for (int i = 0; i < clazzArray.length; i++) {
				if (i != 0) sb.append(", ");
				sb.append(clazzArray[i].getSimpleName());
				sb.append(".class");
			}
			sb.append("});");
		});
		return generateTryCatch(sb.toString());
	}
	
	private String generateTryCatch(String content) {
		StringBuilder sb = new StringBuilder();
		sb.append("try {" + SPACE);
		sb.append(content);
		sb.append(SPACE + "} catch (Exception e) {}");
		return sb.toString();
	}

}
