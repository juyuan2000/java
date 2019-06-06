package com.djs.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "china")
@Data
public class China {
	@XmlAttribute
	private String name;
	@XmlElementRef
	private List<Province> provinces;
	
	
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement(name = "province")
	@Data
	public static class Province{
		@XmlAttribute
		String  name;
		@XmlAttribute
		int postcode;
		@XmlElementRef
		List<City> cities;
	}
	
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement(name = "city")
	@Data
	public static class City{
		@XmlAttribute
		String  name;
		@XmlAttribute
		int postcode;
		@XmlElementRef
		List<Area> areas;
	}
	
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement(name = "area")
	@Data
	public static class Area{
		@XmlAttribute
		String  name;
		@XmlAttribute
		int postcode;
	}

}
