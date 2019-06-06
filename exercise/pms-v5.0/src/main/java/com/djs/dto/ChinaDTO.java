package com.djs.dto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.core.io.ClassPathResource;

import com.djs.vo.China;
import com.djs.vo.China.Area;
import com.djs.vo.China.City;

public class ChinaDTO {

	private static China china;

	private static Map<String, List<City>> map = new HashMap<>();
	private static Map<String,List<Area>> cityMap = new HashMap<>();

	static {
		parse();
	}

	private static void parse() {
		try {
			JAXBContext context = JAXBContext.newInstance(China.class);
			ClassPathResource resource = new ClassPathResource("xml\\city.xml");
			Unmarshaller unmarshaller = context.createUnmarshaller();
			china = (China) unmarshaller.unmarshal(resource.getInputStream());
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
	}

	public static List<String> getProvince() {
		for (China.Province p : china.getProvinces()) {
			map.put(p.getName(), p.getCities());
		}

		List<String> list = new ArrayList<>();
		list.addAll(map.keySet());
		return list;
	}

	public static List<City> getCities(String provinceName) {
		List<City> list = map.get(provinceName);
		for(China.City c: list) {
			cityMap.put(c.getName(), c.getAreas());
		}
		return list;
	}
	
	public static List<Area> getAreas(String cityName){
		return cityMap.get(cityName);
	}

}
