/***********************************************************************
 * Module:  TicketDAO.java
 * Author:  yang
 * Purpose: Defines the Class TicketDAO
 ***********************************************************************/
package com.tickets.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.DateFormat;
import java.util.*;
import com.tickets.dao.*;
import com.tickets.model.*;


/** @pdOid 87b83075-784e-423a-9b3a-e7b69a4d705c */
public class TicketDAO implements ITicketDAO {
   /** @param startCity 出发城市编号
    * @param endCity 终点城市编号
    * @param time 出发时间
    * @pdOid 736f864d-d5b5-4015-a1ed-726ee8021e38 */
   public List<TicketBean> findTickets(int startCity, int endCity, Date time) {
      // TODO: implement
      List<TicketBean> list = null;
      Connection con = null;
      PreparedStatement pstm = null;
      ResultSet rs = null;
      String sql = "select sa.station_name as startStation, " +
              "sb.station_name as endStation," +
              "t.train_name as train," +
              "t.train_type as trainType," +
              "la.cur_time as startTime," +
              "lb.cur_time as endTime," +
              "count(c.price) as price " +
              "from tb_station sa,tb_station sb,tb_train t,tb_line la,tb_line lb,tb_line c " +
              "where sa.city_id=? and sb.city_id=? " +
              "and la.station_id=sa.station_id and lb.station_id=sb.station_id " +
              "and t.train_id=la.train_id and la.train_id=lb.train_id " +
              "and lb.cur_time>la.cur_time " +
              "and c.train_id=t.train_id and c.cur_time>=la.cur_time and c.cur_time<lb.cur_time " +
              "and la.cur_time like?";
      try {
         con = DBPool.getConnection();
         pstm = con.prepareStatement(sql);
         pstm.setInt(1, startCity);
         pstm.setInt(2, endCity);
         pstm.setString(3, DateFormat.getDateInstance().format(time) + "%");
         rs = pstm.executeQuery();
         list = new ArrayList<TicketBean>();
         while(rs.next()){
            TicketBean ticket = new TicketBean();
            ticket.setStartStation(rs.getString("startStation"));
            ticket.setEndStation(rs.getString("endStation"));
            ticket.setTrain(rs.getString("train"));
            ticket.setTrainType(rs.getString("trainType"));
            ticket.setStartTime(rs.getTime("startTime"));
            ticket.setEndTime(rs.getTime("endTime"));
            ticket.setPrice(rs.getInt("price"));
            list.add(ticket);
         }
      }catch(SQLException e){
         e.printStackTrace();
      }finally {
         try{
            if(rs != null) rs.close();
            if(pstm != null) pstm.close();
            if(con != null) con.close();
         }catch(SQLException e){
            e.printStackTrace();
         }
      }
      return list;
   }
   
   /** @param ticket
    * @pdOid 97649964-275e-4383-8e85-dc286a72c5ef */
   public boolean orderTicket(TicketBean ticket) {
      // TODO: implement
      Connection con = null;
      PreparedStatement pstm = null;
      PreparedStatement prePstm = null;
      ResultSet rs = null;
      int count = 0;
      String preSql="SELECT tb_ticket.ticket_id " +
              "FROM tb_ticket,tb_line,tb_station,tb_user,tb_train " +
              "WHERE " +
              "tb_user.idcard=? " +
              "AND tb_ticket.user_id=tb_user.user_id " +
              "AND tb_train.train_name=? " +
              "AND tb_ticket.train_id=tb_train.train_id " +
              "AND tb_ticket.start_station=tb_station.station_id " +
              "AND tb_line.station_id=tb_ticket.start_station " +
              "AND tb_line.cur_time LIKE ?";
      try{
         con = DBPool.getConnection();
         prePstm = con.prepareStatement(preSql);
         prePstm.setString(1, ticket.getUser().getIdCard());
         prePstm.setString(2, ticket.getTrain());
         prePstm.setString(3, DateFormat.getDateInstance().format(ticket.getStartTime()) + "%");
         rs = prePstm.executeQuery();
         if(rs.next()) return false;

      }catch (SQLException e){
         e.printStackTrace();
      }finally {
         try{
            if(prePstm != null) prePstm.close();
            if(con != null) con.close();
         }catch (SQLException e){
            e.printStackTrace();
         }
      }
      String sql = "insert into tb_ticket(start_station,end_station,user_id,train_id) " +
              "VALUES(" +
              "SELECT  station_id FROM tb_station WHERE station_name=?," +
              "SELECT station_id FROM tb_station WHERE station_name=?" +
              "SELECT user_id FROM tb_user WHERE idcard=?" +
              "SELECT train_id FROM tb_train WHERE train_name=?)";
      try{
         con = DBPool.getConnection();
         pstm = con.prepareStatement(sql);
         pstm.setString(1, ticket.getStartStation());
         pstm.setString(2, ticket.getEndStation());
         pstm.setString(3, ticket.getUser().getIdCard());
         pstm.setString(4, ticket.getTrain());
         count = pstm.executeUpdate();
      }catch(SQLException e){
         e.getErrorCode();
      }finally {
         try{
            if(pstm != null) pstm.close();
            if(con != null) con.close();

         }catch (SQLException e){
            e.printStackTrace();
         }
      }
      return count == 1;
   }
   
   /** @param ticket
    * @pdOid 3eff8edf-4bec-4e0a-b99d-68d394a3cf62 */
   public boolean refundTicket(TicketBean ticket) {
      // TODO: implement
      Connection con = null;
      PreparedStatement pstm = null;
      int count = 0;
      String sql = "DELETE FROM tb_ticket " +
              "WHERE " +
              "user_id=(SELECT user_id FROM tb_user WHERE idcard=?)" +
              "AND train_id=(SELECT train_id FROM tb_train WHERE train_name=?)";
      try{
         con = DBPool.getConnection();
         pstm = con.prepareStatement(sql);
         pstm.setString(1, ticket.getUser().getIdCard());
         pstm.setString(2, ticket.getTrain());
         count = pstm.executeUpdate();
      }catch (SQLException e){
         e.printStackTrace();
      }finally {
         try{
            if(pstm != null) pstm.close();
            if(con != null) con.close();
         }catch (SQLException e){
            e.printStackTrace();
         }
      }
      return count == 1;
   }
   
   /** @param time 
    * @param ticket
    * @pdOid f2127290-25cd-4ac1-90be-1a403e3fced8 */
   public boolean changeTicket(Date time, TicketBean ticket) {
      // TODO: implement
      if(refundTicket(ticket)) {
         ticket.setStartTime(time);
         return orderTicket(ticket);
      }
      return false;
   }

}