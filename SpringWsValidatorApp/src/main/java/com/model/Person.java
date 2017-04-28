package com.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.Tag;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7329668448614777841L;

	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.RELAXED,
			  additionalTags = {"html","div"})
	String name;
	
	@Min(5) // value must be more than 5
	@NotNull
	Integer id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
