package edu.iot.app.view;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

@Component("fileView")
public class FileView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String path = (String) model.get("path");
		String type = (String) model.get("type");
		
		File file = new File(path);
		
		response.setContentType(type);
		response.setContentLength((int)file.length());
		response.setHeader("Content-Transfer-Encoding","binary");
		
		//FileUtil.copy(path,response.getOutputStream());
		FileUtils.copyFile(file,response.getOutputStream());

	}

}
