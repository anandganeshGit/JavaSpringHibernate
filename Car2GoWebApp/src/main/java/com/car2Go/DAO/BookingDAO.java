package com.car2Go.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.car2Go.pojo.Booking;


@Component
public class BookingDAO extends DAO {

	 public List<Booking> getAllBookings(long personId)
	            throws Exception {
	        try {
	            begin();
	            Query q = getSession().createQuery("from Booking where personId = :personId");
	            q.setLong("personId", personId);
	            List bookingList = q.list();
	            commit();
	            return bookingList;
	        } catch (HibernateException e) {
	            rollback();
	            throw new Exception("Could not get bookings " +  e);
	        }
	    }
	 
	 
    public Booking create(Booking booking)
            throws Exception {
        try {
            begin();      
            getSession().save(booking);
            commit();
            return booking;
        } catch (HibernateException e) {
            rollback();
            System.out.println(e);
            throw new Exception("Exception while creating booking: " + e.getMessage());
        }
    }
    
        
    public List<Booking> getBooking() throws Exception {
        try {
            begin();
            Query q=getSession().createQuery("from Booking ");
            
            List<Booking> bookingList = q.list(); 
            commit();
            return bookingList;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not obtain the named category " + " " + e.getMessage());
        }
    }

    public int delete(int bookingId)
            throws Exception {
        try {
            begin();
            Query query = getSession().createQuery("Delete from Booking where bookingId= :bookingId");
            query.setInteger("bookingId", bookingId);
            int result = query.executeUpdate();
            commit();
            return result;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not delete booking", e);
        }
    }
    
    public void save(Booking booking) throws Exception {
        try {
            begin();
            getSession().update(booking);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not save the booking", e);
        }
    }
    public Booking searchBooking(int bookingId) throws Exception{
    	Booking booking;
    	 Booking bookingList = null;
    	 try{
    		 begin();
    		 String queryString = "from Booking where bookingId = :bookingId";
    		  Query query = getSession().createQuery(queryString);
    		  query.setString(bookingId, "bookingId");
    		  Object queryResult = query.uniqueResult();
    		  bookingList=(Booking)query.uniqueResult();
              commit();
              System.out.println("product");
              return bookingList;
              
    		 
    	 }catch (HibernateException e) {
             rollback();
             throw new Exception("Could not obtain the named category " + bookingId + " " + e.getMessage());
         }
    	
    }
}