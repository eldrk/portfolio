package edu.iot.common.model;

import java.util.List;

import lombok.Data;

@Data
public class Tour {

	private long tourId;
	private String name;
	private String lgType;
	private String mdType;
	private String smType;
	private String region;
	private String location;
	private String address;
	List<String> imageList;
	
	
}
