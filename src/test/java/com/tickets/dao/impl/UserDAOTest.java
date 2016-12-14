package com.tickets.dao.impl;

import com.tickets.model.UserBean;
import junit.framework.TestCase;

/**
 * Created by yang on 2016/12/10.
 */
public class UserDAOTest extends TestCase {
    private UserDAO userDAO = new UserDAO();
    public void testUpdateUser() throws Exception {
        UserBean user = new UserBean();
        user.setUserName("小杰");
        user.setRealName("李军");
        user.setPassword("abc123");
        user.setIdCard("429001199506122223");
        user.setPhone("15334567890");
        user.setEmail("123@gmail.com");
        userDAO.updateUser(user);

    }

    public void testFindUserByName() throws Exception {


    }

    public void testFindUserByPhone() throws Exception {

    }

    public void testAddUser() throws Exception {
        UserBean user = new UserBean();
        user.setUserName("小军军");
        user.setRealName("李军");
        user.setPassword("abc123");
        user.setIdCard("429001199508123345");
        user.setPhone("15334567890");
        user.setEmail("123@gmail.com");
        assertFalse("添加失败", !userDAO.addUser(user));


    }

}