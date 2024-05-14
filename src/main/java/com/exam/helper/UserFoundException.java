package com.exam.helper;

public class UserFoundException extends Exception {
    
    public UserFoundException(){
        super("User with this name is already there in the DB");
    }
    public UserFoundException(String msg){super(msg);}
}
