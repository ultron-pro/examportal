package com.exam.examportal.helper;

public class UserFoundException extends  Exception{

     public UserFoundException()
     {
         super("user is already in database........!! try with another user name ");
     }
     public UserFoundException(String msg)
     {
         super(msg);
     }
}
