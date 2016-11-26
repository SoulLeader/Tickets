/***********************************************************************
 * Module:  ITicketDAO.java
 * Author:  yang
 * Purpose: Defines the Interface ITicketDAO
 ***********************************************************************/

import java.util.*;

/** @pdOid 5f58a453-ac23-4e30-b2e3-3a39d6e0f5a0 */
public interface ITicketDAO {
   /** @param startCity 
    * @param endCity 
    * @param time
    * @pdOid ba6b717c-f476-4981-be2d-c0ade04f0466 */
   List<TicketBean> findTickets(int startCity, int endCity, Date time);
   /** @param ticket
    * @pdOid 75188eb3-2c96-4cc1-94fa-ba507080a210 */
   void orderTicket(TicketBean ticket);
   /** @param ticket
    * @pdOid 80d392b8-bb9c-4550-8a3b-a5357c178927 */
   void refundTicket(TicketBean ticket);
   /** @param time 
    * @param ticket
    * @pdOid 90154aad-11cd-4739-8d81-f384712ee078 */
   void changeTicket(Date time, TicketBean ticket);

}