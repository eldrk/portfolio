package edu.iot.common.model;

import java.util.List;

import lombok.Data;

@Data

public class Residence {
	
	private long residenceId;
	private String region;
	private String type;
	private String name;
	private String address;
	private String rooms;
	private String phoneNumber;
	List<String> imageList;
	
	
}
