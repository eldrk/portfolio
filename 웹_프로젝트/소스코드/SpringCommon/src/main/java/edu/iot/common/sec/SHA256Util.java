package edu.iot.common.sec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class SHA256Util {
	public static String generateSalt() {
		
		byte[] salt = new byte[8];
		
		Random random = new Random();
		random.nextBytes(salt);
		return byteToHexString(salt);
	}
	
	public static String byteToHexString(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<bytes.length;i++) {
			sb.append(String.format("%02x", bytes[i]));
		}
		return sb.toString();
	}
	

	public static String getEncrypt(String source, String salt) {
		byte[] bytes = (source+salt).getBytes();
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(bytes);
			
			byte[] byteData = md.digest();
			result = byteToHexString(byteData);
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
		}
		

	
	public static String getEncrypt(String source, byte[] salt) {
		String result = "";
		
		byte[] a= source.getBytes();
		byte[] bytes = new byte[a.length + salt.length];
		
		System.arraycopy(a, 0, bytes, 0, a.length);
		System.arraycopy(salt, 0, bytes, a.length, salt.length);
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(bytes);
			
			byte[] byteData = md.digest();
			//바이트를 문자열로 변환
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<byteData.length; i++) {
				sb.append(String.format("%02x", byteData[i]));
			}
			result = sb.toString();
			
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
