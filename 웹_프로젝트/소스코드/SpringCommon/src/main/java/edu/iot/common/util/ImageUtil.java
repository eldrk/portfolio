package edu.iot.common.util;

import java.io.ByteArrayInputStream;
import java.io.File;

import org.apache.commons.io.output.ByteArrayOutputStream;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	public static void saveThumb(File src) throws Exception{ 
		File thumb = new File(src.getParent() + "/thumb", 
							  src.getName()); 
		
		// Thumbnail 파일 생성 
		Thumbnails 
			.of(src)  //원본지정
			.crop(Positions.CENTER) // 이미지 crop 위치
			.size(200, 200) 
			.toFile(thumb); 
	}
	
	public static byte[] makeThumb(byte [] data) throws Exception{
		return makeThumb(data, 100, 100);
	}
	
	public static byte[] makeThumb(byte[] data, int width, int height) throws Exception{
		try(
			ByteArrayInputStream in = new ByteArrayInputStream(data);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
		){
			Thumbnails.of(in)
					.size(width,height)  //원본지정
					.crop(Positions.CENTER) // 이미지 crop 위치
					.toOutputStream(out);
			return out.toByteArray();
		}
	}
}
