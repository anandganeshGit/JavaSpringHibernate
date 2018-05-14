/*package com.car2Go.DAO;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import com.car2Go.pojo.*;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;


public class PdfReportView  extends AbstractPdfView  {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document pdfdoc, PdfWriter pdfwriter,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//model was added to the scope by the Controller
		User user = (User) model.get("user");
		pdfdoc.add(new Paragraph("Student Name: " + user.getFname() + " " + user.getLname()));
	}

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			//model was added to the scope by the Controller
			User user = (User) model.get("user");
			pdfdoc.add(new Paragraph("Student Name: " + user.getFname() + " " + user.getLname()));
		
	}

}
*/