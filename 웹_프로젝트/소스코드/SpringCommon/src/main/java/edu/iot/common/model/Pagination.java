package edu.iot.common.model;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Pagination {
	public static final int PER_PAGE = 10;
	public static final int PER_BLOCK = 10;
	
	private int total;
	private int page;
	private int start;
	private int end;
	
	private int totalPage;
	private int startPage;
	private int endPage;
	
	private int currentBlock;
	private int totalBlock;
	private int preBlockPage;
	private int nextBlockPage;
	
	
	public Pagination() {}
	
	public Pagination(int currentPage, int total) {
		page = currentPage;
		this.total = total;
		
		start = (page-1)*PER_PAGE+1;
		end = start + PER_PAGE-1;
		totalPage = (int) Math.ceil((float)total /PER_PAGE);
		
		
		currentBlock = (int) Math.ceil((float)currentPage /PER_BLOCK);
		totalBlock = (int) Math.ceil((float)totalPage /PER_PAGE);
		
		startPage = (currentBlock-1)*PER_BLOCK +1;
		endPage = startPage + PER_BLOCK -1;
		
		if(endPage>totalPage) endPage = totalPage;
		
		preBlockPage = startPage -1;
		nextBlockPage = endPage +1;
		
	}
	
	public Map<String,Integer> getPageMap(){
		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("start", start);
		pageMap.put("end", end);
		return pageMap;
	}
	
	
	
	
}
