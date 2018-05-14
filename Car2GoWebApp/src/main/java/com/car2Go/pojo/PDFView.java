package com.car2Go.pojo;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

/*import com.low
import com.itextpdf.*;
import */

public class PDFView extends AbstractPdfView{

	
	@Override
    protected void buildPdfDocument(Map<String, Object> model, Document pdfdoc, PdfWriter pdfwriter, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        
        List<Booking> blist = (List<Booking>) model.get("Booking");
        Paragraph title = new Paragraph("Thanks for booking");
        
        Phrase producttitle = new Phrase("Details:");
        
        Phrase thank = new Phrase("Thanks");
        
        PdfPTable table = new PdfPTable(3);
       table.setWidthPercentage(100.0f);
       table.setWidths(new float[] {3.0f, 2.0f, 1.0f});
       table.setSpacingBefore(10);
        
        PdfPCell cell = new PdfPCell();
       cell.setBackgroundColor(Color.WHITE);
       cell.setPadding(5);
        
       cell.setPhrase(new Phrase("BookingFrom"));
       table.addCell(cell);
       
       cell.setPhrase(new Phrase("BookingTo"));
       table.addCell(cell);

       cell.setPhrase(new Phrase("BookingId"));
       table.addCell(cell);
       
       for (Booking ccc : blist) {
           table.addCell(ccc.getBookedFrom());
           table.addCell(ccc.getBookedTill());
           table.addCell(String.valueOf(ccc.getBookingId()));
       }
       
        pdfdoc.add(title);
        pdfdoc.add(producttitle);
        pdfdoc.add(table);
        pdfdoc.add(thank);
    }
}




