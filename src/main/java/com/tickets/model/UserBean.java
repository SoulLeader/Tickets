/***********************************************************************
 * Module:  UserBean.java
 * Author:  yang
 * Purpose: Defines the Class UserBean
 ***********************************************************************/
package com.tickets.model;

/** @pdOid c21d88df-8932-48b1-bd59-d4f3b662268f */
public class UserBean {
   /** @pdOid 7e3d824a-7db5-49d1-beb0-b32d6b984fc4 */
   private String userName = null;
   /** @pdOid 3fadd79c-0253-4dfc-8eb6-4c53f99e94c0 */
   private String realName = null;
   /** @pdOid 244bd949-2afd-4bdb-8ed3-84ae8d38fc2a */
   private String password = null;
   /** @pdOid 15772325-0dc0-4529-b6ac-8e2235704197 */
   private String phone = null;
   /** @pdOid e2c0b7e3-5518-4e74-9c10-bd8dba73641e */
   private String idCard = null;
   /** @pdOid 7e5d309d-16ee-42a2-af90-79106ca16b3f */
   private String email = null;
   public UserBean(){

   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public String getRealName() {
      return realName;
   }

   public void setRealName(String realName) {
      this.realName = realName;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getIdCard() {
      return idCard;
   }

   public void setIdCard(String idCard) {
      this.idCard = idCard;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}