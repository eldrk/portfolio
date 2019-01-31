package edu.iot.common.model;

import lombok.Data;

@Data

public class Search {
	private String category;
	private String keyword;
	
	private String lgType;
	private String mdType;
	private String smType;
	
	public void setKeyword(String keyword){
		this.keyword = "%" +keyword +"%";
	}
	public void setSmType(String smType){
		this.smType = smType +"%";
	}

	
	
}
