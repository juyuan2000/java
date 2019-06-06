package com.djs.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;

import lombok.AllArgsConstructor;
import lombok.Data;

public class XmlHelper {

	private static Map<String, Mapper> map = new HashMap<>();
	
	static {
		init();
	}

	private static void init() {
		try {
			SAXReader in = new SAXReader();
			ClassPathResource resource = new ClassPathResource("mvc\\context.xml");
			Document read = in.read(resource.getInputStream());
			Element root = read.getRootElement();
			List<Element> elements = root.elements();

			for (Element bean : elements) {
				String id = bean.attributeValue("id");
				String clazz = bean.attributeValue("class");
				String method = bean.attributeValue("method");
				Mapper mapper = new Mapper(id, clazz, method);
				map.put(id, mapper);

			}
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Map<String,Mapper> getMap(){
		return map;
	}

	@Data
	@AllArgsConstructor
	public static class Mapper {
		String id;
		String clazz;
		String method;

	}

}
