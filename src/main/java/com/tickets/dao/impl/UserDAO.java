/***********************************************************************
 * Module:  UserDAO.java
 * Author:  yang
 * Purpose: Defines the Class UserDAO
 ***********************************************************************/

import java.util.*;

/** @pdOid 33b89e58-87eb-4d0f-ac06-ea967813ecd9 */
public class UserDAO implements IUserDAO {
   /** @param user
    * @pdOid 3e3c7ee9-265e-4591-bc7e-f259a58c51af */
   public void addUser(UserBean user) {
      // TODO: implement
   }
   
   /** @param user
    * @pdOid c9b97b02-7e8f-4c66-ae22-8d237662ba1b */
   public void updateUser(UserBean user) {
      // TODO: implement
   }
   
   /** @param name 
    * @param pwd
    * @pdOid 06d9edd2-6aa7-4136-895d-ee7a2a921ed7 */
   public UserBean findUserByName(String name, String pwd) {
      // TODO: implement
      return null;
   }
   
   /** @param phone 
    * @param pwd
    * @pdOid eaf3d238-a600-4fe7-8b7d-1db960f00624 */
   public UserBean findUserByPhone(String phone, String pwd) {
      // TODO: implement
      return null;
   }

}