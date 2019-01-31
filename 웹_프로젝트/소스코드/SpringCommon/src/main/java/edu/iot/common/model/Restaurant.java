package edu.iot.common.model;

import java.util.List;

import lombok.Data;

@Data

public class Restaurant {

	private long restaurantId;
	private String region;
	private String type;
	private String mainMenu;
	private String name;
	private String address;
	private String phoneNumber;
	List<String> imageList;
	
}
