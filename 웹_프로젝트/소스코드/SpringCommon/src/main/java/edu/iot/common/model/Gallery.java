package edu.iot.common.model;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class Gallery {
	
	private long galleryId;
	@NotEmpty(message="필수항목입니다.")
	private String title;
	@NotEmpty(message="필수항목입니다.")
	private String owner;
	private String description;
	private Date regDate;
	private Date updateDate;
	private List<GalleryImage> list;
	private long readCnt;

}
