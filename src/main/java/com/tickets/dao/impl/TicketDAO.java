/***********************************************************************
 * Module:  TicketDAO.java
 * Author:  yang
 * Purpose: Defines the Class TicketDAO
 ***********************************************************************/

import java.util.*;

/** @pdOid 87b83075-784e-423a-9b3a-e7b69a4d705c */
public class TicketDAO implements ITicketDAO {
   /** @param startCity 
    * @param endCity 
    * @param time
    * @pdOid 736f864d-d5b5-4015-a1ed-726ee8021e38 */
   public List<TicketBean> findTickets(int startCity, int endCity, Date time) {
      // TODO: implement
      return null;
   }
   
   /** @param ticket
    * @pdOid 97649964-275e-4383-8e85-dc286a72c5ef */
   public void orderTicket(TicketBean ticket) {
      // TODO: implement
   }
   
   /** @param ticket
    * @pdOid 3eff8edf-4bec-4e0a-b99d-68d394a3cf62 */
   public void refundTicket(TicketBean ticket) {
      // TODO: implement
   }
   
   /** @param time 
    * @param ticket
    * @pdOid f2127290-25cd-4ac1-90be-1a403e3fced8 */
   public void changeTicket(Date time, TicketBean ticket) {
      // TODO: implement
   }

}