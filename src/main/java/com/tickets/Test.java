package com.tickets;

import com.tickets.model.UserBean;
import com.tickets.service.impl.UserService;

/**
 * Created by yang on 2016/12/4.
 */
public class Test {
    public static void main(){
        UserBean user = new UserBean();
        user.setEmail("123@321.com");
        user.setUserName("123");
        user.setRealName("name");
        user.setIdCard("429003199605123321");
        user.setPhone("13445678910");
        user.setPassword("ooo");
        UserService service = new UserService();
        System.out.print(service.register(user));
    }
}
