/***********************************************************************
 * Module:  UserDAO.java
 * Author:  yang
 * Purpose: Defines the Class UserDAO
 ***********************************************************************/

package com.tickets.dao.impl;
import com.tickets.dao.DBPool;
import com.tickets.dao.IUserDAO;
import com.tickets.model.UserBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** @pdOid 33b89e58-87eb-4d0f-ac06-ea967813ecd9 */
public class UserDAO implements IUserDAO {
   /** @param user
    * @pdOid 3e3c7ee9-265e-4591-bc7e-f259a58c51af */
   public boolean addUser(UserBean user) {
      // TODO: implement
      String sql = "insert into tb_user(user_name, name, password, idcard, phone, email)"
              + " values(?, ?, ?, ?, ?, ?)";
      Connection con = null;
       PreparedStatement pstm = null;
       int count = 0;
       try {
           con = DBPool.getConnection();
           pstm = con.prepareStatement(sql);
           pstm.setString(1, user.getUserName());
           pstm.setString(2, user.getRealName());
           pstm.setString(3, user.getPassword());
           pstm.setString(4, user.getIdCard());
           pstm.setString(5, user.getPhone());
           pstm.setString(6, user.getEmail());
           count = pstm.executeUpdate();

       } catch (SQLException e) {
           e.printStackTrace();
       }finally{
           if(pstm != null) try {
               pstm.close();
               if(con != null) con.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       return count == 1;
   }
   
   /** @param user
    * @pdOid c9b97b02-7e8f-4c66-ae22-8d237662ba1b */
   public boolean updateUser(UserBean user) {
      // TODO: implement
       String sql = "update tb_user set user_name=?,password=?,phone=?,email=? " +
               "where idcard=?";
       Connection con = null;
       PreparedStatement pstm = null;
       int count = 0;
       try {
           con = DBPool.getConnection();
           pstm = con.prepareStatement(sql);
           pstm.setString(1, user.getUserName());
           pstm.setString(2, user.getPassword());
           pstm.setString(3, user.getPhone());
           pstm.setString(4, user.getEmail());
           pstm.setString(5, user.getIdCard());
           count = pstm.executeUpdate();

       } catch (SQLException e) {
           e.printStackTrace();
       }finally{
           try {
               if(pstm != null)pstm.close();
               if(con != null)con.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       return count == 1;
   }
   
   /** @param name 
    * @param pwd
    * @pdOid 06d9edd2-6aa7-4136-895d-ee7a2a921ed7 */
   public UserBean findUserByName(String name, String pwd) {
      // TODO: implement
       String sql = "select user_name,name,password,idcard,phone,email,user_id " +
               "from tb_user where user_name=? and password=?";
       UserBean user = null;
       Connection con = null;
       PreparedStatement pstm = null;
       ResultSet rs = null;
       try{
           con = DBPool.getConnection();
           pstm = con.prepareStatement(sql);
           pstm.setString(1, name);
           pstm.setString(2, pwd);
           rs = pstm.executeQuery();
           if(rs.next()){
               user = new UserBean();
               user.setUserName(rs.getString("user_name"));
               user.setPassword(rs.getString("password"));
               user.setRealName(rs.getString("name"));
               user.setIdCard(rs.getString("idcard"));
               user.setPhone(rs.getString("phone"));
               user.setEmail(rs.getString("email"));

           }

       }catch (SQLException e){
           e.printStackTrace();
       }finally {
           try {
               if(rs != null) rs.close();
               if(pstm != null) pstm.close();
               if(con != null) con.close();

           }catch (SQLException e){
               e.printStackTrace();
           }
       }
       return user;
   }
   
   /** @param phone 
    * @param pwd
    * @pdOid eaf3d238-a600-4fe7-8b7d-1db960f00624 */
   public UserBean findUserByPhone(String phone, String pwd) {
       // TODO: implement
       String sql = "select user_name,name,password,idcard,phone,email,user_id " +
               "from tb_user where phone=? and password=?";
       UserBean user = null;
       Connection con = null;
       PreparedStatement pstm = null;
       ResultSet rs = null;
       try{
           con = DBPool.getConnection();
           pstm = con.prepareStatement(sql);
           pstm.setString(1, phone);
           pstm.setString(2, pwd);
           rs = pstm.executeQuery();
           if(rs.next()){
               user = new UserBean();
               user.setUserName(rs.getString("user_name"));
               user.setPassword(rs.getString("password"));
               user.setRealName(rs.getString("name"));
               user.setIdCard(rs.getString("idcard"));
               user.setPhone(rs.getString("phone"));
               user.setEmail(rs.getString("email"));

           }

       }catch (SQLException e){
           e.printStackTrace();
       }finally {
           try {
               if(rs != null) rs.close();
               if(pstm != null) pstm.close();
               if(con != null) con.close();

           }catch (SQLException e){
               e.printStackTrace();
           }
       }
       return user;
   }

}