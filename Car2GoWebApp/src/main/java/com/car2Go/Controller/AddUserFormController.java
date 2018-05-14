package com.car2Go.Controller;

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
@RequestMapping("/addUserForm.htm")
public class AddUserFormController {
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result) throws Exception {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "addUserForm";
		}
		/*else if (user.getRole().equalsIgnoreCase("admin")){
			return "adminWelcome";
		}*/
		try {
			System.out.print("test");
			UserDAO userDao = new UserDAO();
			System.out.print("test1");
			
			userDao.create(user.getUsername(), user.getPassword(),user.getRole() ,user.getEmailId() , user.getFirstname(), user.getLastname(), user.getPhonenumber(),user.getAddress());
			
			
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "addedUser";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {

		return "addUserForm";
	}
}
