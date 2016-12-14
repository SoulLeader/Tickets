package com.tickets.service.impl; /***********************************************************************
 * Module:  UserService.java
 * Author:  yang
 * Purpose: Defines the Class UserService
 ***********************************************************************/

import com.tickets.dao.impl.UserDAO;
import com.tickets.model.UserBean;
import com.tickets.service.IUserService;

import java.util.*;

/** @pdOid 30935912-99f7-418a-a164-bdae519f61e3 */
public class UserService implements IUserService {
   /** @param user
    * @pdOid e2c25568-a760-4b26-a412-1ed9cccb7d7d */
   private static UserDAO userDAO;
   static{
      userDAO = new UserDAO();
   }
   public UserBean login(UserBean user) {
      // TODO: implement
      if(user.getUserName() != null){
         return userDAO.findUserByName(user.getUserName(), user.getPassword());
      }
      if(user.getPhone() != null){
         return userDAO.findUserByPhone(user.getPhone(), user.getPassword());
      }
      return null;
   }
   
   /** @param user
    * @pdOid 7d8de017-201d-4cb8-884b-93904d26e226 */
   public UserBean register(UserBean user) {
      // TODO: implement
      if(userDAO.addUser(user)) return user;
      return null;
   }
   
   /** @param user
    * @pdOid 01ac8336-67b3-4731-ae3c-b59411cc439d */
   public boolean update(UserBean user) {
      // TODO: implement
      return userDAO.updateUser(user);
   }

}