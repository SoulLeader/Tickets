/***********************************************************************
 * Module:  IUserDAO.java
 * Author:  yang
 * Purpose: Defines the Interface IUserDAO
 ***********************************************************************/

import java.util.*;

/** @pdOid 695b5c64-c61e-43e8-aa51-7fe48cdd7472 */
public interface IUserDAO {
   /** @param user
    * @pdOid 8be409b7-85ee-4864-abc0-122f0a130b08 */
   void addUser(UserBean user);
   /** @param user
    * @pdOid 6f99cf9b-8db9-499f-9727-f9cde49998a7 */
   void updateUser(UserBean user);
   /** @param name 
    * @param pwd
    * @pdOid d6667fd8-9b4d-4f51-bb5f-538700612c82 */
   UserBean findUserByName(String name, String pwd);
   /** @param phone 
    * @param pwd
    * @pdOid 87440cb2-157e-4653-88be-f00cba8073af */
   UserBean findUserByPhone(String phone, String pwd);

}