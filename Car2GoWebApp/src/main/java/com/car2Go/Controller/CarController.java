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

import com.car2Go.DAO.CarDAO;
import com.car2Go.DAO.CarTypeDAO;
import com.car2Go.pojo.Car;
import com.car2Go.pojo.CarType;

@Controller
public class CarController {
	@Autowired
	@Qualifier("carValidator")
	CarValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = "/addCar.htm", method = RequestMethod.POST)
	protected String addCar(@ModelAttribute("car") Car car, BindingResult result, HttpServletRequest req)
			throws Exception {

		HttpSession s = req.getSession();

		validator.validate(car, result);
		if (result.hasErrors()) {
			return "addCar";
		}
		int cartypeId = car.getCartypeId();
		if(cartypeId == 0) {
			cartypeId = 4;
		}

		try {
			CarTypeDAO carTypes = new CarTypeDAO();
			CarDAO carDAO = new CarDAO();

			// searching from database
			CarType carType = carTypes.get(cartypeId);

			// insert a new car

			carDAO.create(car.getAvailability(), car.getYearofmanufacture(), car.getCarNo(), car.getCarName(),
					car.getPerhourrate(), carType.getCartypeId(),car.getRating());

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "addSuccessCar";
	}

	@RequestMapping(value = "/addCar.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("car") Car car, BindingResult result) {
		return "addCar";
	}

	@RequestMapping(value = "/deleteCar.htm", method = RequestMethod.GET)
	public String loadDeleteCarForm(@ModelAttribute("car") Car car, BindingResult result) {
		return "deleteCar";
	}

	@RequestMapping(value = "/updateCar.htm", method = RequestMethod.GET)
	public String loadUpdateForm(@ModelAttribute("car") Car car, BindingResult result) {
		return "updateCar";
	}

	@RequestMapping(value = "/deleteCar.htm", method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("car") Car car, BindingResult result) throws Exception {

		validator.validate(car, result);
		if (result.hasErrors()) {
			return "deleteCar";
		}

		try {
			System.out.print("test");
			CarDAO carDao = new CarDAO();
			System.out.print("test1");
			int deletestatus = carDao.delete(car.getCarId());
			if (deletestatus > 0) {
				return "successDeleteCar";
			} else {
				return null;
			}

			// DAO.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return null;
	}

	@RequestMapping(value = "/updateCar.htm", method = RequestMethod.POST)
	protected String doSubmitAction1(@ModelAttribute("car") Car car, BindingResult result, HttpServletRequest req)
			throws Exception {

		HttpSession s = req.getSession(false);
		validator.validate(car, result);
		if (result.hasErrors()) {
			return "updateCar";
		}

		try {
			System.out.print("test");
			CarDAO carDao = new CarDAO();
			System.out.print("test1");

			Car car1 = carDao.get(car.getCarId());
			req.setAttribute("car", car1);
			return "carUpdateSearch";
		}

		// DAO.close();
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return null;
	}
}