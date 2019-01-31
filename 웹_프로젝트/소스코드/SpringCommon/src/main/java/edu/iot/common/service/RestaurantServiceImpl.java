package edu.iot.common.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.iot.common.dao.RestaurantDao;
import edu.iot.common.model.Pagination;
import edu.iot.common.model.Restaurant;
import edu.iot.common.model.Search;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantDao dao;

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
	public Restaurant findById(long restaurantId) throws Exception {
		
		return dao.findById(restaurantId);
	}

	@Override
	public List<Restaurant> random(int num) throws Exception {
		List<Restaurant> list = dao.random(num);
		for(Restaurant item : list) {
			List<String> imageList = new ArrayList<>();
			imageList.add("food1.jpg");
			imageList.add("food2.jpg");
			imageList.add("food3.jpg");
			imageList.add("food4.jpg");
			imageList.add("food5.jpg");
			imageList.add("food6.jpg");
			imageList.add("food7.jpg");
			imageList.add("food8.jpg");
			imageList.add("food9.jpg");
			imageList.add("food10.jpg");
			Collections.shuffle(imageList);
			item.setImageList(imageList);
		}
		return list;
	}

	@Override
	public List<Restaurant> search(Search search) throws Exception {
		return dao.search(search);
	}
}
