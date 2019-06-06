package com.djs.entity;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("Pet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
	private Integer id;
	private String name;
	private Double price;
	private String img;
	private String address;
	private Category category;
	

}
