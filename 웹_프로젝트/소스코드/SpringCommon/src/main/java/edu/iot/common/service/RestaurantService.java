package edu.iot.common.service;

import java.util.List;
import java.util.Map;

import edu.iot.common.model.Restaurant;
import edu.iot.common.model.Search;

public interface RestaurantService {

	Map<String, Object> getPage(int page) throws Exception;

	Restaurant findById(long restaurantId) throws Exception;

	List<Restaurant> random(int num) throws Exception;

	List<Restaurant> search(Search search) throws Exception;

}
