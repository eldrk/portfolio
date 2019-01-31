package edu.iot.app.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;

import edu.iot.app.controller.BoardController;

public class BoardControllerTest extends BaseMvcTest<BoardController> {

	@Test
	public void TestList() throws Exception{
		mockMvc.perform(get("/board/list"))
               .andDo(print())
               .andExpect(status().isOk())
		       .andExpect(view().name("board/list"))
		       .andExpect(model().attributeExists("pagination"))
			   .andExpect(model().attributeExists("list"));
	}
	
	@Test
	public void testListPage() throws Exception{
		mockMvc.perform(get("/board/list").param("page", "2"))
			   .andDo(print())
			   .andExpect(status().isOk())
			   .andExpect(view().name("board/list"))
			   .andExpect(model().attributeExists("pagination"))
			   .andExpect(model().attributeExists("list"));
	}
	
	@Test
	public void testCreateSubmit() throws Exception{
		MockMultipartHttpServletRequestBuilder request = fileUpload("/board/create");
		
		request.param("writer", "woosung")
		       .param("password", "1234")
		       .param("title", "단위 테스트 제목")
		       .param("content","단위 테스트내용");
		
		request.file(
				new MockMultipartFile("files", "test1.txt",
						"multipart/mixed", "업로드 테스트1".getBytes())
				);
		
		request.file(
				new MockMultipartFile("files", "test2.txt",
						"multipart/mixed", "업로드 테스트2".getBytes())
				);
		
		mockMvc.perform(request)
			   .andDo(print())
			   .andExpect(status().is3xxRedirection())
			   .andExpect(redirectedUrl("list"));
	}
}
