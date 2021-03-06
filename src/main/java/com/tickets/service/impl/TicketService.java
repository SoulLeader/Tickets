package com.tickets.service.impl; /***********************************************************************
 * Module:  TicketService.java
 * Author:  yang
 * Purpose: Defines the Class TicketService
 ***********************************************************************/

import com.tickets.dao.impl.TicketDAO;
import com.tickets.model.TicketBean;
import com.tickets.service.ITicketService;

import java.util.*;


/** @pdOid 21e679b3-3860-4bcf-ba88-755eb542f003 */
public class TicketService implements ITicketService {
    private static TicketDAO ticketDAO = null;
    static{
        ticketDAO = new TicketDAO();
    }
   /** @param startCity 
    * @param endCity 
    * @param time
    * @pdOid 409b6224-a9f4-4e97-8359-a5e771347966 */
   public List<TicketBean> findTickets(int startCity, int endCity, Date time) {
      // TODO: implement
       return ticketDAO.findTickets(startCity, endCity, time);
   }
   
   /** @param ticket
    * @pdOid 8f10052a-1e8e-4837-ad26-1fa1709f488d */
   public boolean orderTicket(TicketBean ticket) {
      // TODO: implement
       return ticketDAO.orderTicket(ticket);
   }
   
   /** @param ticket
    * @pdOid 96688338-5605-4865-889a-a1dce47ff18e */
   public boolean refundTicket(TicketBean ticket) {
      // TODO: implement
       return ticketDAO.refundTicket(ticket);
   }
   
   /** @param time 
    * @param ticket
    * @pdOid 4594d3a0-2ae4-4c2b-99bb-a8a63d88b725 */
   public boolean changeTicket(Date time, TicketBean ticket) {
      // TODO: implement
       return ticketDAO.changeTicket(time, ticket);
   }

}