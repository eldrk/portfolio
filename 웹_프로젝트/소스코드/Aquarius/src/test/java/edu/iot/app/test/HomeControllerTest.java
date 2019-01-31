package edu.iot.app.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import edu.iot.app.HomeController;

public class HomeControllerTest extends BaseMvcTest<HomeController> {
	
	@Test
	public void listTest() throws Exception{

		mockMvc.perform(get("/"))
		       .andDo(print())
		       .andExpect(status().isOk())
		       .andExpect(view().name("home"))
		       .andExpect(model().attributeExists("serverTime"));
	}
}
