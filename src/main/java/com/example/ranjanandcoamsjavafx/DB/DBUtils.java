package com.example.ranjanandcoamsjavafx.DB;

import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.sql.ResultSet ;

public class DBUtils {


    public Connection databaseLink;

    String databaseName = "RanjanAndCo_AMS_db";
    String databaseUser = "root";
    String databasePassword = "";
    String url = "jdbc:mysql://localhost/" + databaseName;


    public Connection connect()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser,databasePassword);
            System.out.println("Success");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return databaseLink;
    }

}
