package edu.iot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.iot.common.service.ResidenceService;
import edu.iot.common.service.RestaurantService;
import edu.iot.common.service.TourService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	/*@Autowired
	TourDao dao;*/
	
	@Autowired
	RestaurantService service;
	
	@Autowired
	ResidenceService service2;
	
	@Autowired
	TourService service3;
	
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws Exception{
		
		model.addAttribute("list", service.random(3));
		model.addAttribute("list2", service2.random(3));
		model.addAttribute("list3", service3.random(3));
		return "home";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
	
	/*@PostConstruct
	public void setup() {
		ArrayList<Tour> list = new ArrayList<>();

		try {
			BufferedReader reastaurant = new BufferedReader(new FileReader("C:/Temp/jeju.txt"));
			String data;
			while ((data = reastaurant.readLine()) != null) {
				String[] i =data.split("\t");
				if(i.length != 7) continue;
				System.out.println(data);
				Tour r = new Tour(
									0, //  Long.parseLong(i[0]), 
									i[0], i[1], i[2], i[3], i[4], i[5], i[6]);
				list.add(r);
				System.out.println(r);
				dao.insert(r);
			}
			reastaurant.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	
}
