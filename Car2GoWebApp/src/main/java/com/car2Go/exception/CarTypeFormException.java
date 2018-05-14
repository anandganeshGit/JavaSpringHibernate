package com.car2Go.exception;

public class CarTypeFormException extends Exception
{
	public CarTypeFormException(String message)
	{
		super("CarTypeFormException-"+ message);
	}
	
	public CarTypeFormException(String message, Throwable cause)
	{
		super("CarTypeFormException-"+ message,cause);
	}
}