package edu.iot.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	public static List<String> readLines(File file) {// 읽을파일객
		return readLines(file, "utf-8");
	}

	public static List<String> readLines(File file, String charset) {// 읽을파일객체
		List<String> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader
				(new FileInputStream(file), charset));) {
			// 라인별 읽기, 출력하기
			String linestring;
			while ((linestring = br.readLine()) != null) {
				list.add(linestring);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static String readAll(String path) throws Exception{
		StringBuilder sb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new FileReader(path));
				){
				int ch;
				while((ch=br.read()) != -1) {
					sb.append((char)ch);
				}
		}
		return sb.toString();
	}
	
	//FileUtil을 중심으로 파일경로를 읽어들인다
	public static String readResource(String path) throws Exception{
		path = FileUtil.class.getResource(path).getPath();
		return FileUtil.readAll(path);
	}
	
	public static void serialize(String path, Object...obj) throws Exception{
		try(
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		){
		oos.writeObject(obj);
		}
	}
	
	public static Object deserialize(String path) throws Exception{
		try(
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		){
			return ois.readObject();
		}
	}
	
	public static byte[] bytes(File file) throws Exception{
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try(BufferedInputStream bis = new BufferedInputStream(
									  new FileInputStream(file))){
			int data;
			while((data=bis.read()) != -1){
				out.write(data);
			}
			return out.toByteArray();
		}
	}
	
	public static void save(File file, byte[] data) throws Exception{
		try(
				FileOutputStream fos = new FileOutputStream(file)
		){
			fos.write(data);
		}
	}

	public static void copy(String path, OutputStream out)throws Exception{
		
		try(
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
		BufferedOutputStream bos = new BufferedOutputStream(out);
	){
		int data;
		while((data=bis.read())!=-1) {
			bos.write(data);
		}
		bos.flush();
	}	
		
	}
	
}
