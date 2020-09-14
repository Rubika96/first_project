package com.sgic.defect.server.dto;

import com.mysql.cj.jdbc.Blob;

public class SeverityDto {
	private Long id;
	private String name;
	private String description;
	private Blob icon;
	private String color;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Blob getIcon() {
		return icon;
	}
	public String getColor() {
		return color;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setIcon(Blob icon) {
		this.icon = icon;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
