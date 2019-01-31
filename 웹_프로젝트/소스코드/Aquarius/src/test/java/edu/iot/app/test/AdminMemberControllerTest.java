package edu.iot.app.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

import edu.iot.app.controller.AdminMemberController;

public class AdminMemberControllerTest extends BaseMvcTest<AdminMemberController> {

	@Test
	public void testList() throws Exception{
		
		mockMvc.perform(get("/admin/member/list"))
				   .andDo(print())
	               .andExpect(status().isOk())
			       .andExpect(view().name("/admin/member/list"))
			       .andExpect(model().attributeExists("pagination"))
				   .andExpect(model().attributeExists("list"));
	}
}
