package edu.iot.common.model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Attachment {

	private long attachmentId;
	private long boardId;
	private String fileName;
	private String location;
	private Date regDate;
	
	public Attachment(String fileName, String location) {
		this.fileName = fileName;
		this.location = location;
	}
	
	
}
