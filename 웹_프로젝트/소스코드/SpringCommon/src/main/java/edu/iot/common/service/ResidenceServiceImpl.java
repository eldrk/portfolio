package edu.iot.common.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.iot.common.dao.ResidenceDao;
import edu.iot.common.model.Pagination;
import edu.iot.common.model.Residence;
import edu.iot.common.model.Search;

@Service
public class ResidenceServiceImpl implements ResidenceService{

	@Autowired
	ResidenceDao dao;
	
	@Override
	public Map<String, Object> getPage(int page) throws Exception {
		Map<String, Object> map = new HashMap<>();

		int total = dao.count();
		Pagination pagination = new Pagination(page, total);
		map.put("pagination", pagination);
		map.put("list", dao.getPage(pagination.getPageMap()));
		return map;
	}

	@Override
	public Residence findById(long residenceId) throws Exception {
		
		return dao.findById(residenceId);
	}

	@Override
	public List<Residence> random(int num) throws Exception {
		List<Residence> list = dao.random(num);
		
		for(Residence item : list) {
			List<String> imageList = new ArrayList<>();
			imageList.add("room1.jpg");
			imageList.add("room2.jpg");
			imageList.add("room3.jpg");
			imageList.add("room4.jpg");
			imageList.add("room5.jpg");
			imageList.add("room6.jpg");
			imageList.add("room7.jpg");
			imageList.add("room8.jpg");
			imageList.add("room9.jpg");
			imageList.add("room10.jpg");
			Collections.shuffle(imageList);
			item.setImageList(imageList);
		}
		
		return list;
	}

	@Override
	public List<Residence> search(Search search) throws Exception {
		return dao.search(search);
	}


}
