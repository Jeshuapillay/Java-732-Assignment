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

        String edtn = request.getParameter("name");
        String edtp = request.getParameter("password");
        String edte = request.getParameter("email");
        String edtg = request.getParameter("gender");
        String edtc = request.getParameter("city");

        try{
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/richfield", "root", "");

            stmt = con.createStatement();

            String query = "update users set name='" +edtn+ "', password='" +edtp+"', email='" +edte+"', gender='" +edtg+"', city='" +edtc+"' where name='" +edtn+ "', password='" +edtp+"', email='" +edte+"', gender='" +edtg+"', city='" +edtc+"'";
            int result = stmt.executeUpdate(query);
            out.print(result + "row(s) updated.");

        } catch(Exception exc) {
            out.print("Something went wrong when updating!");
        }
    }