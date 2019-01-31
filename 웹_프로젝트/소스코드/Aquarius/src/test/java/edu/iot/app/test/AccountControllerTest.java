package edu.iot.app.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import edu.iot.app.controller.AccountController;

public class AccountControllerTest extends BaseMvcTest<AccountController> {
	
	@Test
	public void testLoginSuccess() throws Exception{
		mockMvc.perform(
				post("/account/login")
				.param("userId","woosung")
				.param("password","1234")
				)
				.andDo(print())
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/"));
	}
	
	@Test
	public void testLoginSuccess2() throws Exception{
		String target = "/board/write";
		mockMvc.perform(
				post("/account/login")
				.param("url", target)
				.param("userId","woosung")
				.param("password","1234")
				)
		.andDo(print())
		.andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl(target));
	}
	
	@Test
	public void testLoginFail() throws Exception{
		mockMvc.perform(
				post("/account/login")
				.param("userId","woosung")
				.param("password","abcd")
				)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("account/login"));
	}
	
}
