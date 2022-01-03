/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package back_end.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import back_end.model.DAO;

/**
 *
 * @author epilif3sotnas
 */
@WebServlet(name = "Login", urlPatterns = {"/Servlet/Login"})
public class Login extends HttpServlet {
    DAO dao = new DAO();

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {      
        if (dao.verifyUser(req.getParameter("email"), req.getParameter("password"))) {
            res.setStatus(HttpServletResponse.SC_OK);
            res.sendRedirect(location); // location -> main.jsp
        }
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
