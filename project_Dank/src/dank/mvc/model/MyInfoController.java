package dank.mvc.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyInfoController {

	@RequestMapping(value = "/pri_info_chk")
	public String momo3() {
		return "myinfo/pri_info_chk";
	}

	@RequestMapping(value = "/pri_info_modi")
	public String momo4() {
		return "pri_info_modi";
	}

	@RequestMapping(value = "/mem_pw_reset_input")
	public String momo5() {
		return "myinfo/mem_pw_reset_input";
	}

	@RequestMapping(value = "/mem_pw_chk")
	public String momo6() {
		return "myinfo/mem_pw_chk";
	}

	@RequestMapping(value = "/mem_pw_reset")
	public String momo7() {
		return "myinfo/mem_pw_reset";
	}

	@RequestMapping(value = "/tap")
	public String tap() {
		return "myinfo/tap";
	}

	@RequestMapping(value = "/security")
	public String viewSecurity() {
		return "myinfo/security";
	}

	@RequestMapping(value = "/securitycard")
	public String viewSecurity_card() {
		return "myinfo/securityCard";
	}

	@RequestMapping(value = "/securitycardsuccess")
	public String viewSecurity_card_success() {
		return "myinfo/securityCardSuccess";
	}

	@RequestMapping(value = "/securityotp")
	public String viewSecurity_otp() {
		return "myinfo/securityOtp";
	}

	@RequestMapping(value = "/securityotpsuccess")
	public String viewCheckBalance() {
		return "myinfo/securityOtpSuccess";
	}
}
