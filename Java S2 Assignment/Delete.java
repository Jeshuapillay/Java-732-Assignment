package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

public class Delete extends HttpServlet{  

    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        PreparedStatement ps;
        ResultSet rs;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/richfield", "root", "");
            ps = con.prepareStatement("delete from users where name=?");
            int i = ps.executeUpdate();
            
            if(i != 0){
                pw.println("Deleting row...");
            } else if (i == 0){
                pw.println("<br>Row has been deleted successfully.");
            }
        
        } catch(SQLException sx){
            pw.println(sx);
        
        } catch(ClassNotFoundException cx){
            pw.println(cx);
        }

    }
}
