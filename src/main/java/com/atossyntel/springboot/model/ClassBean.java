package com.atossyntel.springboot.model;

import java.sql.Date;


public class ClassBean {
	String class_Id;
	String stream_Id;
	Date start_date;
	Date end_date;

	public ClassBean() {
		super();
	}

	public ClassBean(String class_Id, String stream_Id, Date start_date, Date end_date) {
		super();
		this.class_Id = class_Id;
		this.stream_Id = stream_Id;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public String getClass_Id() {
		return class_Id;
	}

	public void setClass_Id(String class_Id) {
		this.class_Id = class_Id;
	}

	public String getStream_Id() {
		return stream_Id;
	}


	public void setStream_Id(String stream_Id) {
		this.stream_Id = stream_Id;
	}

	public Date getStart_date() {
		return start_date;
	}
	
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}
	
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	@Override
	public String toString() {
		return "ClassBean [class_Id=" + class_Id + ", stream_Id=" + stream_Id + ", start_date=" + start_date
				+ ", end_date=" + end_date + "]";
	}

}
