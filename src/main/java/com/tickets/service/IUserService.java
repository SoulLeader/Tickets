package com.tickets.service; /***********************************************************************
 * Module:  IUserService.java
 * Author:  yang
 * Purpose: Defines the Interface IUserService
 ***********************************************************************/

import com.tickets.model.UserBean;

import java.util.*;

/** @pdOid b8d40d22-2992-4c5d-a149-9a6be5a5ddbb */
public interface IUserService {
   /** @param user
    * @pdOid a8c29c1d-e6b9-4913-803d-e0a3f3daae77 */
   UserBean login(UserBean user);
   /** @param user
    * @pdOid 1b3592e4-a5c6-43e9-9dac-ac02fbb3d436 */
   UserBean register(UserBean user);
   /** @param user
    * @pdOid 384f395d-c332-4c60-bb4e-b16b42b871b1 */
   boolean update(UserBean user);

}