package edu.iot.common.dao;

import java.util.List;

import edu.iot.common.model.Restaurant;
import edu.iot.common.model.Search;

public interface RestaurantDao extends CrudDao<Restaurant,Long>,
									   RandomDao<Restaurant>{

	List<Restaurant> search(Search search) throws Exception;

}
