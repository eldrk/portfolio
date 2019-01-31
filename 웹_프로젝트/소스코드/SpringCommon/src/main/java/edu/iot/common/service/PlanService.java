package edu.iot.common.service;

import java.util.List;
import java.util.Map;

import edu.iot.common.model.Plan;

public interface PlanService {
	Map<String, Object> getPage(int page) throws Exception;
	public void create(Plan plan) throws Exception;
	List<Plan> getList(String userId) throws Exception;
	public Plan findById(long planId) throws Exception;
	void delete(long planId) throws Exception;
	public void update(Plan plan) throws Exception;
}
