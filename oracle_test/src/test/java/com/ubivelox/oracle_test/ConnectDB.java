package com.ubivelox.oracle_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.UbiveloxException;

public class ConnectDB
{
    private static ConnectDB connectDB = null;
    private Connection       conn      = null;





    private ConnectDB()
    {

    }





    public static ConnectDB getInstance()
    {
        if ( connectDB != null )
        {
            return connectDB;
        }
        else
        {
            synchronized ( ConnectDB.class )
            {
                if ( connectDB == null )
                {
                    connectDB = new ConnectDB();
                }
                return connectDB;
            }
        }
    }





    public Connection connectDB() throws UbiveloxException
    {

        if ( this.conn == null )
        {
            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                this.conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "work", "work");

            }
            catch ( Exception ex )
            {
                throw new UbiveloxException("DB 접근 에러");
            }
        }
        return this.conn;
    }





    public String disConnectDB() throws UbiveloxException
    {
        if ( this.conn != null )
        {
            try
            {
                this.conn.close();
            }
            catch ( SQLException ex )
            {
                ex.printStackTrace();
                throw new UbiveloxException("접속 종료 에러");
            }
        }
        return "접속 종료 성공";
    }
}
