package com.atossyntel.springboot.model;

import java.sql.Date;

public class DescriptionBean {
	private String descriptionInput;

	public DescriptionBean() {
		super();
	}

	public DescriptionBean(String descriptionInput) {
		super();
		this.descriptionInput = descriptionInput;
	}

	public String getDescriptionInput() {
		return descriptionInput;
	}

	public void setDescriptionInput(String descriptionInput) {
		this.descriptionInput = descriptionInput;
	}

	@Override
	public String toString() {
		return "DescriptionBean [descriptionInput=" + descriptionInput + "]";
	}
}
