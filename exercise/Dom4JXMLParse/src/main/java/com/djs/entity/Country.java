package com.djs.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Country {
	private static String name;
	private static List<Province> province ;
	
	public Country (String name ,List<Province> province) {
		this.name = name;
		this.province = province;
		
	} 
	

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Country.name = name;
	}

	public static List<Province> getProvince() {
		return province;
	}

	public static void setProvince(List<Province> province) {

		Country.province = province;
	}
	
	@AllArgsConstructor
	@Data
	public static class Province {
		private static String name;
		private static List<City> city = new ArrayList<>();
		
		public Province (String name ,List<City> city) {
			this.name = name;
			this.city = city;
			
		} 
		
		
		
		
		public static String getName() {
			return name;
		}
		public static void setName(String name) {
			Province.name = name;
		}
		public static List<City> getCity() {
			return city;
		}
		public static void setCity(List<City> city) {
			Province.city = city;
		}
		
		

	}
	@AllArgsConstructor
	@Data
	public static class City {
		private static String name;
		private static List<Area> area = new ArrayList<>();
		
		public City (String name ,List<Area> area) {
			this.name = name;
			this.area = area;
			
		} 
		
		
		public static String getName() {
			return name;
		}
		public static void setName(String name) {
			City.name = name;
		}
		public static List<Area> getArea() {
			return area;
		}
		public static void setArea(List<Area> area) {
			City.area = area;
		}
		
	}
	@AllArgsConstructor
	@Data
	public static class Area {
		private static String name;
		
		public Area (String name ) {
			this.name = name;
		}
		

	}

}
