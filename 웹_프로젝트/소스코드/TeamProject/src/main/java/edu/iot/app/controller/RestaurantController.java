package edu.iot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.iot.common.model.Restaurant;
import edu.iot.common.model.Search;
import edu.iot.common.service.RestaurantService;
import edu.iot.common.util.Util;

@Controller
@RequestMapping(value="/restaurant")
public class RestaurantController {

	@Autowired
	RestaurantService service;
	
	@RequestMapping("/list")
	public void list(@RequestParam(value="page",defaultValue="1") int page, Model model) throws Exception{
		
		//model.addAttribute("today",Util.getToday());
		model.addAllAttributes(service.getPage(page));
		
	}
	
	@RequestMapping(value="/view/{restaurantId}", method=RequestMethod.GET)
	public String view(@PathVariable long restaurantId, Model model) throws Exception{
		Restaurant restaurant = service.findById(restaurantId);
		model.addAttribute("restaurant",restaurant);
		model.addAttribute("list", service.random(1));
		return "restaurant/view";
	}
	
	@RequestMapping("/search")
	public void serch(Search search, Model model) throws Exception{
		
		//model.addAttribute("today", Util.getToday());
		model.addAttribute("list", service.search(search));
		
	}
}
