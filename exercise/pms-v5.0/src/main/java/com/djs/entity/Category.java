package com.djs.entity;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Alias("Category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	private Integer id;
	private String name;

}
