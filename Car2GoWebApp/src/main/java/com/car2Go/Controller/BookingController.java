package com.car2Go.Controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.car2Go.DAO.BookingDAO;
import com.car2Go.DAO.CarDAO;
import com.car2Go.DAO.CarTypeDAO;
import com.car2Go.pojo.Booking;
import com.car2Go.pojo.Car;
import com.car2Go.pojo.CarType;
import com.car2Go.pojo.User;

@Controller
public class BookingController {
	@Autowired
	@Qualifier("bookingValidator")
	BookingValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = "/searchSuccess.htm", method = RequestMethod.GET)
	protected String select(HttpServletRequest req) throws Exception {

		List<CarType> carTypeList = new ArrayList<CarType>();
		CarTypeDAO ctd = new CarTypeDAO();
		carTypeList = ctd.getAllCarTypes();
		req.setAttribute("carTypeList", carTypeList);
		if (carTypeList != null) {
			return "searchSuccess";
		}

		try {

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "searchSuccess";

	}

	@RequestMapping(value = "/searchSuccess.htm", method = RequestMethod.POST)
	public String getCarTypes(@RequestParam("cartypeId") String cartypeId, HttpServletRequest req) throws Exception {
		int cartype_Id = Integer.parseInt(cartypeId);

		List<Car> carList = new ArrayList<Car>();
		CarDAO cd = new CarDAO();
		carList = cd.getAllCars(cartype_Id);
		req.setAttribute("carList", carList);
		req.getSession().setAttribute("cartypeId", cartype_Id);
		if (carList != null) {
			return "searchCar";
		} else {
			return "searchCar";
		}
	}

	@RequestMapping(value = "/searchCar.htm", method = RequestMethod.POST)
	public String create(HttpServletRequest req) throws Exception {

		HttpSession s = req.getSession();
		int carId = Integer.valueOf(req.getParameter("carId"));
		CarDAO cd = new CarDAO();
		Car car = cd.get(carId);
		req.setAttribute("car", car);
		req.getSession().setAttribute("carId", carId);
		
		return "bookingCar";
	}

	@RequestMapping(value = "/bookingCar.htm", method = RequestMethod.POST)
	public String createBooking(HttpServletRequest req) throws Exception {

		BookingDAO bookingDAO = new BookingDAO();
		Booking book = new Booking();
		HttpSession s = req.getSession();
		String bookedFrom, bookedTill;
	
		if (null != req.getAttribute("car")) {
			Car c = (Car)req.getAttribute("car");
			int carId = c.getCarId();
			book.setCarId(carId);
			
		}
		if (null != req.getParameter("cartypeId") && !req.getParameter("cartypeId").isEmpty()) {
			int cartype_Id = Integer.parseInt(req.getParameter("cartypeId"));
			
		}
		if (!req.getParameter("bookedFrom").isEmpty() && !req.getParameter("bookedTill").isEmpty()) {
			
           
			bookedFrom = req.getParameter("bookedFrom");
			book.setBookedFrom(bookedFrom);
		
			bookedTill = req.getParameter("bookedTill");
			book.setBookedTill(bookedTill);

		}
		
		User user = (User) req.getSession().getAttribute("user");
         book.setUser(user);
		s.setAttribute("userId",user.getPersonId());
		book.setStatus("Booked");
		bookingDAO.create(book);
   
		req.getSession().setAttribute("bookingDetails", book);
		return "bookingSuccess";
	}

	@RequestMapping(value = "/bookingStatus.htm", method = RequestMethod.GET)
	public String booking(@ModelAttribute("customer") Booking booking, BindingResult result) {
		return "bookingStatus";
	}

	@RequestMapping(value = "/bookingStatus.htm", method = RequestMethod.POST)
	public String get( HttpServletRequest req) throws Exception {
	
		User u = (User)req.getSession().getAttribute("user");
		List<Booking> bookingList = new ArrayList<Booking>();
		BookingDAO bd = new BookingDAO();
		bookingList = bd.getAllBookings(u.getPersonId());
		req.setAttribute("bookingList", bookingList);
		if (bookingList != null) {
			return "allBookings";
		}
		return "allBookings";
			
	}	
}
