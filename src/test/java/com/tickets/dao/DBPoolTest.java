package com.tickets.dao;

import junit.framework.TestCase;

import java.sql.Connection;

/**
 * Created by yang on 2016/12/10.
 */
public class DBPoolTest extends TestCase {

    public void testGetConnection() throws Exception {
        Connection con = DBPool.getConnection();
        assertTrue("获取链接成功", !(con == null));
        if(!(con == null))con.close();

    }

}