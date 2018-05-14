package com.car2Go.exception;

public class LoginFormException extends Exception
{
	public LoginFormException(String message)
	{
		super("LoginFormException-"+ message);
	}
	
	public LoginFormException(String message, Throwable cause)
	{
		super("LoginFormException-"+ message,cause);
	}
}