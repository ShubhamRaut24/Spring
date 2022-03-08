package com.demo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "shubh";
        String pass = "password";

        try {
            System.out.println("Connecting to database: "+jdbcUrl);

            Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);

            System.out.println("Connection is SuccessFull.....");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}