package com.bridgelabz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.model.ForgetPassword;
import com.bridgelabz.service.UserService;

@Controller
public class EmailSenderController {

	@Autowired
	private UserService userserviceimpl;
	private String emailid = null;
	private String otpSystemGenerate = null;

// handler mapping for Forget page
	@RequestMapping(value = "/forget", method = RequestMethod.GET)
	public ModelAndView showLogin(@ModelAttribute ForgetPassword forgetPasswordDetails) {
		ModelAndView mv = new ModelAndView("forget");
		mv.addObject("forgetPasswordDetails", forgetPasswordDetails);
		return mv;
	}

// post mapping for emailSendingProcess
	@PostMapping(value = "/emailSendingProcess")
	public ModelAndView sendMail(@ModelAttribute ForgetPassword forgetPasswordDetails) {
		emailid = forgetPasswordDetails.getEmailid();
		int result = userserviceimpl.checkEmailIsPresent(emailid);
		if (result > 0) {
			otpSystemGenerate = "abcd";
			userserviceimpl.sendMail(emailid, otpSystemGenerate);
			ModelAndView mv = new ModelAndView("enterpassword");
			mv.addObject("forgetPasswordDetails", forgetPasswordDetails);
			return mv;
		} else {
			ModelAndView mv2 = new ModelAndView("invalidCredentials");
			return mv2;
		}

	}

	@PostMapping(value = "/passwordreset")
	public String setPassword(@ModelAttribute ForgetPassword forgetPasswordDetails) {

		if (forgetPasswordDetails.getOtp().equals(otpSystemGenerate)) {
			userserviceimpl.setPassword(forgetPasswordDetails.getPassword(), emailid);
			return "passwordRest";
		} else
			return "invalidOtp";

	}

}