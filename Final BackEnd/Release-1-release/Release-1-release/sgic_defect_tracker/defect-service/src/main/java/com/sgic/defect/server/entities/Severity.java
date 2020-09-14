package com.sgic.defect.server.entities;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(schema = "defect-service", name = "severity")
public class Severity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Blob icon;
	private String color;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "severity")
	@JsonIgnore
	private List<Defect> defect;	
	
	public Severity() {

	}
	
	public Severity(Long id, String name, String description, Blob icon, String color) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.icon = icon;
		this.color = color;
	}

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

	public List<Defect> getDefect() {
		return defect;
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

	public void setDefect(List<Defect> defect) {
		this.defect = defect;
	}
	
}
