
package com.wondroussoft.shopping.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Item {@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Long wearId;
	

	public Item() {
	}

	public Item(Long id, String name, Long wearId) {
		this.id = id;
		this.name = name;
		this.wearId = wearId;
	}

	public void Wear(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getWearId() {
		return wearId;
	}

	public void setWearId(Long wearId) {
		this.wearId = wearId;
	}

	

}

