package liquanqiang.spring.boot.mvc;

//import javax.xml.bind.annotation.XmlRootElement;
//xml rest风格数据,就是这么简单
//@XmlRootElement
public class ReturnData {

	private String code;
	
	private String msg;
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
