package com.car2Go.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.car2Go.DAO.UserDAO;
import com.car2Go.pojo.User;

@Controller
public class LoginFormController {
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = "/loginForm.htm", method = RequestMethod.POST)
	protected String login(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest req)
			throws Exception {

		HttpSession s = req.getSession(true);
		validator.validateLogin(user, result);
		if (result.hasErrors()) {
			System.out.println("2");
			return "loginForm";
		}
		try {
			System.out.print("test");
			UserDAO userDao = new UserDAO();
			System.out.print("test1");

			User usr = userDao.get(user.getUsername());
			if (usr == null || !(usr.getPassword().equals(user.getPassword()))) {
				return "loginForm";
			} else if (usr.getRole().equalsIgnoreCase("admin") || usr.getUsername().equalsIgnoreCase("admin")
					|| usr.getPassword().equalsIgnoreCase("admin")) {
				s.setAttribute("admin", usr);
				return "adminWelcome";
			} else {
				s.setAttribute("user", usr);
				return "userLinks";
			}

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		
		}
		return "loginForm";
	}

	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {

		return "loginForm";
	}

	@RequestMapping(value = "/adminWelcome.htm", method = RequestMethod.GET)
	public String adminWelcome() {
		return "adminWelcome";
	}

	@RequestMapping(value = "/addCarType&Car.htm", method = RequestMethod.GET)
	public String loadAddCarTypeAndCar() {
		return "addCarType&Car";
	}

	@RequestMapping(value = "/deleteCarType&Car.htm", method = RequestMethod.GET)
	public String loadDeleteCarTypeAndCar() {
		return "deleteCarType&Car";
	}

	@RequestMapping(value = "/updateCarType&Car.htm", method = RequestMethod.GET)
	public String loadUpdateCarTypeAndCar() {
		return "updateCarType&Car";
	}

}