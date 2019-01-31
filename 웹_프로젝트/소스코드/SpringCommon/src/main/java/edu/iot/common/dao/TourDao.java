package edu.iot.common.dao;

import java.util.List;

import edu.iot.common.model.Search;
import edu.iot.common.model.Tour;

public interface TourDao extends CrudDao<Tour, Long> ,
								 RandomDao<Tour>{

	List<Tour> search(Search search) throws Exception;
}
