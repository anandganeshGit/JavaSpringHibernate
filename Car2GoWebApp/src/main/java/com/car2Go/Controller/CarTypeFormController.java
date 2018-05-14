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

import com.car2Go.DAO.CarTypeDAO;
import com.car2Go.pojo.CarType;

@Controller
public class CarTypeFormController {
	@Autowired
	@Qualifier("carTypeValidator")
	CarTypeValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = "/add.htm", method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("cartype") CarType carType, BindingResult result,
			HttpServletRequest req) throws Exception {

		HttpSession s = req.getSession(true);

		validator.validate(carType, result);
		if (result.hasErrors()) {
			return "add";
		}

		try {
			System.out.print("test");
			CarTypeDAO carTypeDao = new CarTypeDAO();
			System.out.print("test1");

			carTypeDao.create(carType.getCarmodel(),carType.getAvgrate(),carType.getCarbrand(),carType.getTransmissiontype(),
					carType.getEnginetype(),carType.getBodytype());

			// DAO.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "successAdd";
	}

	@RequestMapping(value = "/add.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("cartype") CarType carType, BindingResult result) {
		return "add";
	}

	@RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
	public String loadDeleteCarTypeForm(@ModelAttribute("cartype") CarType carType, BindingResult result) {
		return "delete";
	}

	@RequestMapping(value = "/update.htm", method = RequestMethod.GET)
	public String loadUpdateForm(@ModelAttribute("cartype") CarType carType, BindingResult result) {
		return "update";
	}

	@RequestMapping(value = "/delete.htm", method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("cartype") CarType carType, BindingResult result) throws Exception {

		validator.validate(carType, result);
		if (result.hasErrors()) {
			return "delete";
		}

		try {
			System.out.print("test");
			CarTypeDAO carTypeDao = new CarTypeDAO();
			System.out.print("test1");
			int deletestatus = carTypeDao.delete(carType.getCartypeId());
			if (deletestatus > 0) {
				return "successDeleteCarType";
			} else {
				return null;
			}

			// DAO.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return null;
	}

	@RequestMapping(value = "/update.htm", method = RequestMethod.POST)
	protected String doSubmitAction1(@ModelAttribute("cartype") CarType carType, BindingResult result, HttpServletRequest req) throws Exception {

		HttpSession s = req.getSession(true);
		validator.validate(carType, result);
		if (result.hasErrors()) {
			return "update";
		}

		try {
			System.out.print("test");
			CarTypeDAO carTypeDao = new CarTypeDAO();
			System.out.print("test1");

			CarType carType1 = carTypeDao.get(carType.getCartypeId());
			System.out.print(carType1);
			
			s.setAttribute("cartype", carType1);
			return "carTypeUpdateSearch";
		}

		// DAO.close();
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return null;
	}

	@RequestMapping(value = "/carTypeUpdateSearch.htm", method = RequestMethod.POST)
	public String updateCarTypeDetails(HttpServletRequest request) throws Exception {
		CarTypeDAO carTypeDAO = new CarTypeDAO();
		String transmissiontype = request.getParameter("transmissiontype");
		String carbrand = request.getParameter("carbrand");
		int carTypeId = Integer.parseInt(request.getParameter("cartypeId"));
		CarType carType = (CarType) request.getAttribute("cartype");
		System.out.println(carbrand+" "+transmissiontype+" "+carTypeId);
		int result = carTypeDAO.updateCarTypeDetails(carbrand, transmissiontype, carTypeId);
		if (result > 0) {
			return null;
		}
		return null;
	}

}
