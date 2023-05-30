package com.exam.examportal.helper;

public class UserNotFoundException extends  Exception{

    public UserNotFoundException()
    {
        super("user name not found in database...");
    }
    public UserNotFoundException(String msg)
    {
        super(msg);
    }
}
