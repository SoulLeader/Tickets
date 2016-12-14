/***********************************************************************
 * Module:  TicketBean.java
 * Author:  yang
 * Purpose: Defines the Class TicketBean
 ***********************************************************************/
package com.tickets.model;
import java.util.*;

/** @pdOid 254a2981-e464-4400-8cfd-4a93b2e8da40 */
public class TicketBean {
   /** @pdOid 91c6e645-9163-4c55-bf58-42977feadfee */
   private String startStation = null;
   /** @pdOid b3718e8c-43ff-46a4-9b55-77d10529cec9 */
   private String endStation = null;
   /** @pdOid f83fb892-8fe8-42ed-ae6e-cad00dafaa75 */
   private String train = null;
   /** @pdOid 6dd05fa6-e93a-4578-b513-a5c6e3c96542 */
   private String trainType = null;
   /** @pdOid 1dd58a7e-c135-4c30-855e-a99eaef6e78b */
   private Date startTime = null;
   /** @pdOid a072075d-7484-416f-a05d-40cf768a74bb */
   private Date endTime = null;
   /** @pdOid bbdd5f8a-2aed-4beb-9c15-1970892bec7f */
   private UserBean user = null;
   /** @pdOid 05e3ec38-55e0-4f1f-85aa-b29918c58566 */
   private double price;
   public TicketBean(){}

   public String getStartStation() {
      return startStation;
   }

   public void setStartStation(String startStation) {
      this.startStation = startStation;
   }

   public String getEndStation() {
      return endStation;
   }

   public void setEndStation(String endStation) {
      this.endStation = endStation;
   }

   public String getTrain() {
      return train;
   }

   public void setTrain(String train) {
      this.train = train;
   }

   public String getTrainType() {
      return trainType;
   }

   public void setTrainType(String trainType) {
      this.trainType = trainType;
   }

   public Date getStartTime() {
      return startTime;
   }

   public void setStartTime(Date startTime) {
      this.startTime = startTime;
   }

   public Date getEndTime() {
      return endTime;
   }

   public void setEndTime(Date endTime) {
      this.endTime = endTime;
   }

   public UserBean getUser() {
      return user;
   }

   public void setUser(UserBean user) {
      this.user = user;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }
}