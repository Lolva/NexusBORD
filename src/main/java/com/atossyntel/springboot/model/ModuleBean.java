package com.atossyntel.springboot.model;

import java.sql.Date;

public class ModuleBean {
	
	private String module_name;
	private int module_id;
	private int stream_id;
	private int module_file_id;
	
	public ModuleBean() {
		super();
		this.module_name = null;
		this.module_id = 0;
		this.stream_id = 0;
		this.module_file_id = 0;
	}
	
	
	public ModuleBean(String module_name, int module_id, int stream_id, int module_file_id) {
		super();
		this.module_name = module_name;
		this.module_id = module_id;
		this.stream_id = stream_id;
		this.module_file_id = module_file_id;
	}


	public String getModule_name() {
		return module_name;
	}


	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}


	public int getModule_id() {
		return module_id;
	}


	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}



	public int getStream_id() {
		return stream_id;
	}


	public void setStream_id(int stream_id) {
		this.stream_id = stream_id;
	}




	public int getModule_file_id() {
		return module_file_id;
	}


	public void setModule_file_id(int module_file_id) {
		this.module_file_id = module_file_id;
	}


	@Override
	public String toString() {
		return "ModuleBean [module_name=" + module_name + ", module_id=" + module_id + ", stream_id=" + stream_id
				+ ", module_file_id=" + module_file_id + "]";
	}
	
	
	
	

}

