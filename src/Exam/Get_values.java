package Exam;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by g00238234 on 08/12/2015.
 */
public class Get_values extends HttpServlet{

    Connection connection;
    PreparedStatement find;

    public void init(ServletConfig config) {
        try {


            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/address?user=root");
            //addressBook = connection.prepareStatement("insert into person(firstname,lastname,address,phone) values (?, ? , ? , ? )");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Successful</title></head></body");
        out.println("<h2>Thank you for your Query");

        //String query = "insert into person (firstname, lastname, id, emailaddress, phone) values (" + "'" + request.getParameter("firstname") +"'"  + "," + "'" + request.getParameter("lastname") +"'"
              //  + "," +"'"+ request.getParameter("ID_number") +"'" + "," + "'"+ request.getParameter("email") +"'" + "," + "'" +  request.getParameter("phone") + "'" + ")";
        String query = "SELECT *  from person where firstname = "+ "'" + request.getParameter("firstname") + "'" ;

        out.println("<p> your query is: " + query + "</p>");


        try {
          find = connection.prepareStatement(query);
           ResultSet result =  find.executeQuery();
            int count =0;
            while(result.next())
            {
                out.println("<p>" + result.getString("firstname")
                        + ", " + result.getString("lastname") + "," + result.getString("emailaddress") + ","
                        + result.getDouble("phone")+ ","+ result.getString("comment") + "</p>" );
                ++count;
            }
            out.println("<p>====" + count + "records found ====</p>");
            out.println("</body></html>");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void destroy() {
        try {
            find.close();

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }







}






