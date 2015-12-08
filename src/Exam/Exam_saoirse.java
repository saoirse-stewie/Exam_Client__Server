package Exam;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by g00238234 on 08/12/2015.
 */
public class Exam_saoirse extends HttpServlet {
    Connection connection;
    PreparedStatement insert,default_firstname,default_lastname, default_id, default_email,default_phone;

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


        String query = "insert into person (firstname, lastname, id_NUMBER, emailaddress, phone, comment) values (" + "'" + request.getParameter("firstname") +"'"  + "," + "'" + request.getParameter("lastname") +"'"
                 + "," +"'"+ request.getParameter("ID_number") +"'" + "," + "'"+ request.getParameter("email") +"'" + "," + "'" +  request.getParameter("phone") + "'" + "," +"'" +request.getParameter("comment")+ "'"+")";


        out.println("<p> your query is: " + query + "</p>");


        try {
            insert = connection.prepareStatement(query);
            int result4 = insert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
    public void destroy() {
        try {
            insert.close();

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }







}
