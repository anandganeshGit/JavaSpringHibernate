package com.car2Go.exception;

public class AddUserFormException extends Exception
{
	public AddUserFormException(String message)
	{
		super("AddUserFormException-"+ message);
	}
	
	public AddUserFormException(String message, Throwable cause)
	{
		super("AddUserFormException-"+ message,cause);
	}
}