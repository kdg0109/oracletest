package com.ubivelox.oracle_test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.UbiveloxException;

public class Crud
{

    public static String selectDB() throws UbiveloxException
    {
        List<Emp> arrayList = new ArrayList<>();

        try
        {

            ConnectDB connDB = ConnectDB.getInstance();
            Connection conn = connDB.connectDB();

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select ename, job, phone from emp");

            while ( rs.next() )
            {
                arrayList.add(new Emp(rs.getString("ename"), rs.getString("job"), rs.getString("phone")));
            }
            for ( Emp emp : arrayList )
            {
                CrudTest.logger.info("emp : [{}]", emp);
            }
            rs.close();
            stmt.close();
        }
        catch ( Exception ex )
        {
            throw new UbiveloxException("DB 출력 에러");
        }
        return "DB 출력 성공";
    }





    public static String insertDB(final String ename, final String job, final String phone) throws UbiveloxException
    {
        try
        {
            ConnectDB connDB = ConnectDB.getInstance();
            Connection conn = connDB.connectDB();
            PreparedStatement pstmt = conn.prepareStatement("insert into emp values (?, ?, ?)");

            pstmt.setString(1, ename);
            pstmt.setString(2, job);
            pstmt.setString(3, phone);
            pstmt.executeUpdate();
            pstmt.close();
        }
        catch ( Exception ex )
        {
            throw new UbiveloxException("DB 저장 에러");

        }
        return "DB 저장 성공";
    }





    public static String updateDB(final String ename, final String job, final String phone) throws UbiveloxException
    {
        try
        {
            ConnectDB connDB = ConnectDB.getInstance();
            Connection conn = connDB.connectDB();

            PreparedStatement pstmt = conn.prepareStatement("update emp set job= ?, phone= ? where ename = ?");
            pstmt.setString(1, job);
            pstmt.setString(2, phone);
            pstmt.setString(3, ename);
            pstmt.executeUpdate();
            pstmt.close();
        }
        catch ( Exception e )
        {
            throw new UbiveloxException("DB 수정 에러");
        }
        return "DB 수정 성공";
    }





    public static String deleteDB(final String ename) throws UbiveloxException
    {
        try
        {

            ConnectDB connDB = ConnectDB.getInstance();
            Connection conn = connDB.connectDB();

            PreparedStatement pstmt = conn.prepareStatement("delete from emp where ename = ? ");
            pstmt.setString(1, ename);
            pstmt.executeUpdate();
            pstmt.close();
        }
        catch ( Exception ex )
        {
            throw new UbiveloxException("DB 삭제 에러");
        }

        return "DB 삭제 성공";
    }
}
