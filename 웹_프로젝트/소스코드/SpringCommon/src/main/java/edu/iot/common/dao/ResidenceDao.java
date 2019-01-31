package edu.iot.common.dao;

import java.util.List;

import edu.iot.common.model.Residence;
import edu.iot.common.model.Search;

public interface ResidenceDao extends CrudDao<Residence, Long> ,
									  RandomDao<Residence>{

	List<Residence> search(Search search) throws Exception;

}
