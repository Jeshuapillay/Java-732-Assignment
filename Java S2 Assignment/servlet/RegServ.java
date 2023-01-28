package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

public class RegServ extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        Connection con = null;
        Statement stmt = null;

        String n = request.getParameter("name");
        String p = request.getParameter("password");
        String e = request.getParameter("email");
        String g = request.getParameter("gender");
        String c = request.getParameter("city");

        try{
            // initialize JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");

            // establish database connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/richfield", "root", "");

            //create object of statement which is responsible for executing queries
            stmt = con.createStatement();

            // execute query to insert into database
            stmt.executeQuery("insert into users values ('"+n+"', '"+p+"', '"+e+"', '"+g+"', '"+c+"')");
            out.print("<h1>Your account is created successfully!</h1>");

        } catch(Exception exc){
            out.print("Please try again!");
        }

    }
}