package com.bridgelabz.controller;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.model.RegistrationDetails;
import com.bridgelabz.service.AppDaoImpl;
import com.bridgelabz.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	UserService daobean;

//handler mapping for UserRegistration page
	@RequestMapping(value = "/UserRegistration", method = RequestMethod.GET)
	public ModelAndView showRegister(@ModelAttribute RegistrationDetails userDetails) {
		ModelAndView mav = new ModelAndView("UserRegistration");
		mav.addObject("userDetails", userDetails);
		return mav;
	}

//post mapping registerProcess
	@PostMapping(value = "/registerProcess")
	public ModelAndView addUser(@ModelAttribute RegistrationDetails userDetails)
			throws NoSuchAlgorithmException, NoSuchProviderException {
		String password = userDetails.getPassword();

		String encryptpass = ((AppDaoImpl) daobean).getSecurePassword(password);
		userDetails.setPassword(encryptpass);
		if (daobean.register(userDetails) > 0)
			return new ModelAndView("register");
		else
			return new ModelAndView("not registered");
	}
}