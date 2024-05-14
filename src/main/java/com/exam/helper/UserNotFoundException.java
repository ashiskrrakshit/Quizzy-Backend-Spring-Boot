package com.exam.helper;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(){
        super("User with this name is not there in the DB");
    }
    public UserNotFoundException(String msg){super(msg);}
}
