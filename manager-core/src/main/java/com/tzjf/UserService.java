package com.tzjf;

public class UserService {

    private static UserService userService;

    static {
        userService = new UserService();
    }

    public static UserService getcon(){
        return  userService;
    }

    public void addUser(String name){
        System.out.println("service:"+name);
    }

}
