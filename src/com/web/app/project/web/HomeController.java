package com.web.app.project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.web.app.project.model.LoginFormViewModel;

import com.web.app.project.repository.UserRepository;
import com.web.app.project.service.UserService;

@Controller
@SessionAttributes({"email"})
public class HomeController {

//	private Logger logger = Logger.getLogger(HomeController.class);
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	//@Autowired
	public HomeController() {
		
	}
	

	
	@ModelAttribute("loginForm")
	public LoginFormViewModel defaultUser() {
		return new LoginFormViewModel();
	}

	@RequestMapping("sign-in")
	public String displayLoginForm() {
		return "sign-in";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(LoginFormViewModel form, ModelMap model) {
		if(userRepository.validateCredentials(form.email, form.password)) {
//			logger.info("User " + form.email + " successfully logged in");
			model.addAttribute("email", form.email);
			return redirectUserHome();
		}

		//		logger.error("User login failed for " + form.email);
		model.addAttribute("alert", "Email and/or password invalid");
		model.addAttribute("loginForm", form);
		return new ModelAndView("sign-in");
	}

	private ModelAndView redirectUserHome() {
		RedirectView redirect = new RedirectView("/user/home");
		redirect.setExposeModelAttributes(false);
		return new ModelAndView(redirect);
	}

	@RequestMapping("user/home")
	public String displayUserHomePage() {
		return "/user/home";
	}	
	
	@RequestMapping(value = "/logout") 
	public String logout(SessionStatus sessionStatus, ModelMap model) {
		sessionStatus.setComplete();
		model.clear();
		return "redirect:/sign-in";
	}
	
	
}
