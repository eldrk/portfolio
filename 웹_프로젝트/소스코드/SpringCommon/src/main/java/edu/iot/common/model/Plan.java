package edu.iot.common.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class Plan {
	
	private String userId;
	private long		planId;
	@NotEmpty(message="필수항목입니다.")
	private String		title;
	@NotEmpty(message="필수항목입니다.")
	private String		writer;
	private String		content;
	private Date		regDate;
	private Date		updateDate;
}