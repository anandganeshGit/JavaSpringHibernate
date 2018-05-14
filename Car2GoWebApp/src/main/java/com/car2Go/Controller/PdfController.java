package com.car2Go.Controller;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.AbstractController;


import com.car2Go.DAO.*;
import com.car2Go.pojo.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/pdf/*")
public class PdfController {

    
    @Autowired
    ServletContext servletContext;
    
    @Autowired
    @Qualifier("bookingDAO")
    BookingDAO bookingDAO;
    
    
    @RequestMapping(value = "/pdfview", method = RequestMethod.POST)
    public ModelAndView showPdfReport(@ModelAttribute("book") Booking car,
                                      ModelMap model,
                                      BindingResult result, 
                                      HttpServletRequest request) throws Exception
    {
        List<Booking> b = bookingDAO.getAllBookings(3);
    
        model.addAttribute("cartitems", b);
        View v = new PDFView();
        return new ModelAndView(v);
    }
}

