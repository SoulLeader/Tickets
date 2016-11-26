/***********************************************************************
 * Module:  LoginServlet.java
 * Author:  yang
 * Purpose: Defines the Class LoginServlet
 ***********************************************************************/

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/** @pdOid 915c294f-50c1-45de-9adb-d5a44cda5b5b */
public class LoginServlet extends javax.servlet.http.HttpServlet {
   /** Called by the server (via the service method) to allow a servlet to handle a GET request.
    * 
    * @param req 
    * @param res
    * @exception javax.servlet.ServletException
    * @exception java.io.IOException
    * @pdOid a3a99b50-752c-43d9-8c4f-db80bebc6ce8 */
   public void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse res) throws javax.servlet.ServletException, java.io.IOException {
      // TODO: implement
      res.setContentType("text/html");
      PrintWriter out = res.getWriter();
   
      out.println("<HTML>");   
      out.println("<HEAD>");   
      out.println("<TITLE>Add the title here</TITLE>");   
      out.println("</HEAD>");   
      out.println("<BODY>");   
      out.println("HTTP servlet: doGet()");
      out.println("</BODY>");   
      out.println("</HTML>");   
      
      out.close();
   }
   
   /** Called by the server (via the service method) to allow a servlet to handle a POST request.
    * 
    * @param req 
    * @param res
    * @exception javax.servlet.ServletException
    * @exception java.io.IOException
    * @pdOid 11b8da54-6d69-4e51-b322-d4060eb0d0ef */
   public void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse res) throws javax.servlet.ServletException, java.io.IOException {
      // TODO: implement
      res.setContentType("text/html");
      PrintWriter out = res.getWriter();
   
      out.println("<HTML>");   
      out.println("<HEAD>");   
      out.println("<TITLE>Add the title here</TITLE>");   
      out.println("</HEAD>");   
      out.println("<BODY>");   
      out.println("HTTP servlet: doPost()");
      out.println("</BODY>");   
      out.println("</HTML>");   
      
      out.close();
   }

}