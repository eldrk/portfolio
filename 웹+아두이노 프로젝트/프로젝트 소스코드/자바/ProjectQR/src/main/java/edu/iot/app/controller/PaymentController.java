package edu.iot.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.iot.common.model.Member;
import edu.iot.common.model.Money;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
	
	static int totalSum = 0;
	
	@RequestMapping(value = "/pay", method = RequestMethod.GET)
	public void pay() throws Exception {
	}

	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public String paySubmit(@Valid @ModelAttribute("money") Money money, BindingResult result, HttpSession session)
			throws Exception {

		log.info(money.toString());

		int sum = 0;

		sum = sum + Integer.parseInt(money.getSum());
		
		log.info("총 액: " + sum);
		
		session.setAttribute("SUM", sum);
		if(sum==0) {
			return "redirect:/payment/pay";
		}
		totalSum = totalSum+sum;
		
		session.setAttribute("TotalSum", totalSum);
		
		return "redirect:/payment/result";
	}

	@RequestMapping(value = "/result")
	public void result(Model model) throws Exception {

	}
}