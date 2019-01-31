package edu.iot.app.controller;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import edu.iot.common.model.Plan;
import edu.iot.common.service.PlanService;

@Controller
@RequestMapping(value="/plan")
public class PlanController {
	
	@Autowired
	PlanService service;

	@Autowired
	ServletContext context;

	@RequestMapping("/list/{userId}")
	public String list(@PathVariable String userId, Model model) throws Exception {

		// model.addAttribute("today", Util.getToday());
		model.addAttribute("list", service.getList(userId));
		return "plan/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public void createForm(Plan plan) {
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createSubmit(@Valid Plan plan, BindingResult result, MultipartHttpServletRequest request)
			throws Exception {

		if (result.hasErrors())
			return "plan/create";
		service.create(plan);
		return "redirect:list/" + plan.getUserId();
	}

	@RequestMapping(value = "/view/{planId}", method = RequestMethod.GET)
	public String view(@PathVariable long planId, Model model) throws Exception {
		Plan plan = service.findById(planId);
		model.addAttribute("plan", plan);

		return "plan/view";
	}

	@RequestMapping(value = "/delete/{planId}", method = RequestMethod.GET)
	public String delete(@PathVariable long planId, Model model) throws Exception {
		Plan plan = service.findById(planId);
		String userId = plan.getUserId();
		service.delete(planId);
		return "redirect:/plan/list/" + userId;
	}

	@RequestMapping(value = "/edit/{planId}", method = RequestMethod.GET)
	public String editForm(@PathVariable long planId, Model model) throws Exception {
		Plan plan = service.findById(planId);
		model.addAttribute("plan", plan);
		return "plan/edit";
	}

	@RequestMapping(value = "/edit/{planId}", method = RequestMethod.POST)
	public String editSubmit(@Valid Plan plan, BindingResult result) throws Exception {

		if (result.hasErrors())
			return "plan/edit";
		
			service.update(plan);
		
		return "redirect:/plan/view/" + plan.getPlanId();
	}

}
