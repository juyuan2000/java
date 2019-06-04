package com.djs.parse;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;

import com.djs.entity.Country;
import com.djs.entity.Country.Area;
import com.djs.entity.Country.City;
import com.djs.entity.Country.Province;

public class ParseXMl {
	
	public static void main(String[] args) throws Exception {
		
		ClassPathResource resourse = new ClassPathResource("xml\\city.xml");
		InputStream in = resourse.getInputStream();
		
		SAXReader read = new SAXReader(); 
		Document document = read.read(in);
		Element root = document.getRootElement();
//		System.out.println(root.attributeValue("name"));
		
//		List<Element> elements = root.elements();
//		
//		for (Element e : elements) {
//			e.elements();
//		}
		
		
//		Iterator iterater = root.elementIterator();
		 List<Element> provinceElements = root.elements();
		 List <Province> provinceList = new ArrayList<> (); 
		 
		 for (Element provinceElement : provinceElements) {
			 	
			 List<Element> cityelements = provinceElement.elements();
			 List <City> cityList = new ArrayList<> (); 
			 
			 for (Element cityelement : cityelements) {
				 
				 List<Element> areaelements = cityelement.elements();
				 List <Area> areaList = new ArrayList<> (); 
				 for (Element  areaelement: areaelements) {
					   String areaName = areaelement.attributeValue("name");
//					   System.out.println(areaName);
					   Area a = new Area(areaName);
					   areaList.add(a);
				}
				 String name = cityelement.attributeValue("name");
				City c = new City(name, areaList); 
				cityList.add(c);
			}
			 String name = provinceElement.attributeValue("name");
//			 System.out.println(name);
				 Province p = new Province(name, cityList); 
				provinceList.add(p);
			
		}
		 
		 System.out.println(Country.getProvince());
		
	}
}

