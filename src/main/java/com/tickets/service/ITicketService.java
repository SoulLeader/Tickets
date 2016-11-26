/***********************************************************************
 * Module:  ITicketService.java
 * Author:  yang
 * Purpose: Defines the Interface ITicketService
 ***********************************************************************/

import java.util.*;

/** @pdOid c321f00a-f970-4119-8939-9332cb721baa */
public interface ITicketService {
   /** @param startCity 
    * @param endCity 
    * @param time
    * @pdOid 889fadab-3a7c-4d6b-be9c-94837ad634e2 */
   List<TicketBean> findTickets(int startCity, int endCity, Date time);
   /** @param ticket
    * @pdOid 882c9e29-711d-48a9-a9f7-9358b9ca13e3 */
   void orderTicket(TicketBean ticket);
   /** @param ticket
    * @pdOid 51f636d5-47e1-426c-9def-ac9d2bd7c0d6 */
   void refundTicket(TicketBean ticket);
   /** @param time 
    * @param ticket
    * @pdOid ae156f37-dbe0-433e-83a9-9b8a4873e5bb */
   void changeTicket(Date time, TicketBean ticket);

}