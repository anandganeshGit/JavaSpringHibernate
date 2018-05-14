package com.car2Go.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.car2Go.pojo.CarType;

public class CarTypeDAO extends DAO {

	 public CarType get(int cartypeId) throws Exception {
	        try {
	            begin();
	            Query q=getSession().createQuery("from CarType where cartypeId= :cartypeId");
	            q.setInteger("cartypeId",cartypeId);
	            CarType carType=(CarType)q.uniqueResult();
	            commit();
	            return carType;
	        } catch (HibernateException e) {
	            rollback();
	            throw new Exception("Could not obtain the named category " + cartypeId + " " + e.getMessage());
	        }
	    }
	 
	 public List getAllModels() throws Exception {
	        try {
	            begin();
	            Query q=getSession().createQuery("Select carmodel from CarType ");
	            List modelList = q.list();
	            commit();
	            return modelList;
	        } catch (HibernateException e) {
	            rollback();
	            throw new Exception("Could not obtain the named category "  + e.getMessage());
	        }
	    }
	 
	 public List getAllCarTypes() throws Exception {
	        try {
	            begin();
	            Query q=getSession().createQuery("from CarType ");
	            List carTypesList = q.list();
	            commit();
	            return carTypesList;
	        } catch (HibernateException e) {
	            rollback();
	            throw new Exception("Could not obtain the named category "  + e.getMessage());
	        }
	    }
	 
		 
    public CarType create(String carmodel,double avgrate, String carbrand,String transmissiontype,String enginetype,String bodytype)
            throws Exception {
        try {
            begin();
            CarType cartMod = new CarType();
            
            cartMod.setCarmodel(carmodel);
            cartMod.setTransmissiontype(transmissiontype);
            cartMod.setCarbrand(carbrand);
            cartMod.setEnginetype(enginetype);
            cartMod.setAvgrate(avgrate);
            cartMod.setBodytype(bodytype);
            
            getSession().save(cartMod);
            commit();
            return cartMod;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Exception while creating car type: " + e.getMessage());
        }
    }

    public int delete(int cartypeId)
            throws Exception {
        try {
            begin();
            Query query = getSession().createQuery("Delete from CarType where cartypeId= :cartypeId");
            query.setInteger("cartypeId", cartypeId);
            int result = query.executeUpdate();
            commit();
            return result;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not delete CarType", e);
        }
    }
    
    public CarType searchCarType(String carbrand) throws Exception{
    	CarType carType;
    	 CarType productList = null;
    	 try{
    		 begin();
    		 String queryString = "from Cartype where carbrand = :carbrand";
    		  Query query = getSession().createQuery(queryString);
    		  query.setString("carType", carbrand);
    		  Object queryResult = query.uniqueResult();
    		  productList=(CarType)query.uniqueResult();
              commit();
              System.out.println("CarType");
              return productList;
              
    		 
    	 }catch (HibernateException e) {
             rollback();
             throw new Exception("Could not obtain the named category " + carbrand + " " + e.getMessage());
         }
    	
    }
    public int updateCarTypeDetails(String carbrand,String transmissiontype,int cartypeId) throws Exception{
    	try{
    		begin();
    		Query query = getSession().createQuery("update CarType set carbrand= :carbrand,transmissiontype= :transmissiontype where cartypeId= :cartypeId");
    		query.setString("carbrand", carbrand);
    		query.setString("transmissiontype", transmissiontype);
    		query.setInteger("cartypeId", cartypeId);
    		int result = query.executeUpdate();
    		commit();
    		return result;
    	}catch(HibernateException e){
    		rollback();
    		throw new Exception("Details Cannot be Updated",e);
    	}
    	
    }
}