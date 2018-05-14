package com.car2Go.exception;

public class BookingException extends Exception
{
	public BookingException(String message)
	{
		super("BookingException-"+ message);
	}
	
	public BookingException(String message, Throwable cause)
	{
		super("BookingException-"+ message,cause);
	}
}