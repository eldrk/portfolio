package edu.iot.common.service;

import java.util.List;
import java.util.Map;

import edu.iot.common.model.Residence;
import edu.iot.common.model.Search;

public interface ResidenceService {

	Map<String, Object> getPage(int page) throws Exception;

	Residence findById(long residenceId) throws Exception;
	
	List<Residence> random(int num) throws Exception;
	
	List<Residence> search(Search search) throws Exception;
}
