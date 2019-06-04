package com.djs.parse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;

public class ParseXMl {
	
	public static void main(String[] args) throws Exception {
		
		ClassPathResource resourse = new ClassPathResource("xml\\city.xml");
		InputStream in = resourse.getInputStream();
		
		SAXReader read = new SAXReader(); 
		Document document = read.read(in);
		Element root = document.getRootElement();
		System.out.println(root.attributeValue("name"));
		
		List<Element> elements = root.elements();
		
		for (Element e : elements) {
			e.elements()
		}
		
		
		Iterator iterater = root.elementIterator();
		
		while (iterater.hasNext()) {
			
			Element element = (Element) iterater.next();
            //已知属性名称情况下
            System.out.println(element.attributeValue("name"));
		}
		
		
	}

}
