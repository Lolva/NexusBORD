package com.atossyntel.springboot.model;



import org.springframework.beans.factory.annotation.Autowired;

public class ClassBean {
	
	
	
	
	int class_Id;
	int stream_Id;
	String start_date;
	String end_date;
	
	
	
	
	public ClassBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	



	public ClassBean(int class_Id, int stream_Id, String start_date, String end_date) {
		super();
		this.class_Id = class_Id;
		this.stream_Id = stream_Id;
		this.start_date = start_date;
		this.end_date = end_date;
	}


	public String getStart_date() {
		return start_date;
	}


	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}


	public int getClass_Id() {
		return class_Id;
	}
	public void setClass_Id(int class_Id) {
		this.class_Id = class_Id;
	}
	public int getStream_Id() {
		return stream_Id;
	}
	public void setStream_Id(int stream_Id) {
		this.stream_Id = stream_Id;
	}
	
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}




	@Override
	public String toString() {
		return "ClassBean [class_Id=" + class_Id + ", stream_Id=" + stream_Id + ", start_date=" + start_date
				+ ", end_date=" + end_date + "]";
	}




	
}
	
	