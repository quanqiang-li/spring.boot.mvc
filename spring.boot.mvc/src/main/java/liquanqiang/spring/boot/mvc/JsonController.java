package liquanqiang.spring.boot.mvc;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json")
public class JsonController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("getJson")
	public ReturnData getJson(HttpServletRequest request) {
		log.info("接收请求类型{}",request.getHeader("Accept"));
		ReturnData returnData = new ReturnData();
		returnData.setCode("0000");
		returnData.setMsg("成功");
		return returnData;
	}

}
