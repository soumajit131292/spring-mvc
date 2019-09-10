package com.bridgelabz.controller;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.model.RegistrationDetails;
import com.bridgelabz.service.UserService;
import com.bridgelabz.service.UserServiceImpl;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userserviceimpl;

//handler mapping for UserRegistration page
	@RequestMapping(value = "/userregistration", method = RequestMethod.GET)
	public ModelAndView showRegister(@ModelAttribute("userDetails") RegistrationDetails userDetails) {
		ModelAndView mav = new ModelAndView("userregistration");
		mav.addObject("userDetails", userDetails);
		return mav;
	}

//post mapping registerProcess
	@PostMapping(value = "/registerProcess")
	public ModelAndView addUser(@ModelAttribute("userDetails") @Valid RegistrationDetails userDetails,
			BindingResult thebindingresult) throws NoSuchAlgorithmException, NoSuchProviderException {

		if (thebindingresult.hasErrors()) {
			return new ModelAndView("userregistration");
		} else {
			String password = userDetails.getPassword();

			String encryptpass = ((UserServiceImpl) userserviceimpl).getSecurePassword(password);
			userDetails.setPassword(encryptpass);
			// System.out.println(" came");

			if (userserviceimpl.register(userDetails) > 0)
				return new ModelAndView("register");
			else
				return new ModelAndView("not registered");
		}
	}
}