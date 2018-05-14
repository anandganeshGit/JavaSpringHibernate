package com.car2Go.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.car2Go.pojo.Car;


public class CarDAO extends DAO {

	 public Car get(int carId) throws Exception {
	        try {
	            begin();
	            Query q=getSession().createQuery("from Car where carId= :carId");
	            q.setInteger("carId",carId);
	            Car car=(Car)q.uniqueResult();
	            commit();
	            return car;
	        } catch (HibernateException e) {
	            rollback();
	            throw new Exception("Could not obtain the named category " + carId + " " + e.getMessage());
	        }
	    }
	 
   public Car create(String availability, int yearofmanufacture,String carNo, String carName, float perhourrate,int cartypeId,String rating)
           throws Exception {
       try {
           begin();
           Car car = new Car(availability,yearofmanufacture,carNo,carName,perhourrate,cartypeId,rating);    
           getSession().save(car);
           System.out.println("saved"+ carNo +" "+ availability);
           commit();
           return car;
       } catch (HibernateException e) {
           rollback();
           throw new Exception("Exception while creating car: " + e.getMessage());
       }
   }

   public int delete(int carId)
           throws Exception {
       try {
           begin();
           Query query = getSession().createQuery("Delete from Car where carId= :carId");
           query.setInteger("carId", carId);
           int result = query.executeUpdate();
           commit();
           return result;
       } catch (HibernateException e) {
           rollback();
           throw new Exception("Could not delete car", e);
       }
   }
   
   public List getAllCars(int cartypeId) throws Exception {
       try {
           begin();
           Query q=getSession().createQuery("from Car where cartypeId = :cartypeId ");
           q.setInteger("cartypeId",cartypeId);
           List carList = q.list();
           commit();
           return carList;
       } catch (HibernateException e) {
           rollback();
           throw new Exception("Could not obtain the named category "  + e.getMessage());
       }
   }
   
   public Car searchCar(String carName) throws Exception{
   	Car car;
   	 Car carList = null;
   	 try{
   		 begin();
   		 String queryString = "from Car where carName = :carName";
   		  Query query = getSession().createQuery(queryString);
   		  query.setString("car", carName);
   		  Object queryResult = query.uniqueResult();
   		  carList=(Car)query.uniqueResult();
             commit();
             System.out.println("Car");
             return carList;
             
   		 
   	 }catch (HibernateException e) {
            rollback();
            throw new Exception("Could not obtain the named category " + carName + " " + e.getMessage());
        }
   	
   }
}
