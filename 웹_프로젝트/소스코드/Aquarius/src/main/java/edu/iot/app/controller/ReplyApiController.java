package edu.iot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.iot.common.exception.PasswordMissmathchException;
import edu.iot.common.model.Reply;
import edu.iot.common.service.ReplyService;

@RestController
@RequestMapping("/board/reply/{boardId}")
public class ReplyApiController {
	
	@Autowired
	ReplyService service;
	
	public <T> ResponseEntity<T> getResult(T t){
		final HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<T>(t,headers,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Reply>> list(@PathVariable long boardId) throws Exception{
		
			List<Reply> list = service.getList(boardId);
			return getResult(list);
		
	}
	
	@RequestMapping(value="/{replyId}" ,method=RequestMethod.GET)
	public ResponseEntity<Reply> replyId(@PathVariable long replyId) throws Exception{
		
			Reply reply = service.findById(replyId);
			return getResult(reply);
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Reply> create(@RequestBody Reply reply) throws Exception{
		//데이터가 json으로 전송되므로 @requestbody사용

			Reply r = service.create(reply);
			return getResult(r);
	
	}
	
	@RequestMapping(value="/{replyId}" ,method=RequestMethod.PUT)
	public ResponseEntity<Reply> update(@RequestBody Reply reply) throws Exception{
		
			Reply r = service.update(reply);
			return getResult(r);
		
	}
	
	@RequestMapping(value="/{replyId}", method=RequestMethod.DELETE)
	public ResponseEntity<Reply> delete(Reply reply) throws Exception{
		//password가 쿼리 파라미터로 전송
		//@RequestBody 사용하지 않음
		
			service.delete(reply);
			return getResult(reply);
		
	}
	
	@ExceptionHandler(PasswordMissmathchException.class)
	public ResponseEntity hadlePasswordMissmatchException(PasswordMissmathchException e) {
		return ResponseEntity
				.status(HttpStatus.UNAUTHORIZED)
				.body(e.getMessage());
	}
	
	@ExceptionHandler(PasswordMissmathchException.class)
	public ResponseEntity hadleException(Exception e) {
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(e.getMessage());
	}
	
	
	
}
