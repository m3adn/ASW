/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package back_end.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import back_end.classes.user.User_Account;
import back_end.model.DAO;

/**
 *
 * @author epilif3sotnas
 */
@WebServlet(name = "Account", urlPatterns = {"/Servlet/Admin/Account"})
public class Account extends HttpServlet {
    private DAO dao = new DAO();
    
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            User_Account newUser = new User_Account (req.getParameter("Email"),
                                                req.getParameter("Username"),
                                                req.getParameter("Password"),
                                                req.getParameter("PhoneNumber"),
                                                req.getParameter("ReferralCode"));
            
            if (dao.insertUser(newUser)){
                res.setStatus(HttpServletResponse.SC_CREATED);
                res.sendRedirect(location); // location -> login.jsp
            }
            res.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
        } catch (IllegalArgumentException ex) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }   
    }
    
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        // verify account
        User_Account userData = dao.getUserData(req.getParameter("Username"));
        PrintWriter out = res.getWriter();
        JSONObject obj = new JSONObject();
        obj.put("Email", userData.getEmail());
        obj.put("Username", userData.getUsername());
        obj.put("PhoneNumber", userData.getPhoneNumber());
        obj.put("ReferralCode", userData.getReferralCode());

        res.setStatus(HttpServletResponse.SC_OK);
        res.setContentType("application/json");
        out.print(obj);
        out.flush();
    }

    @Override
    protected void doPut (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            User_Account updateUser = new User_Account(req.getParameter("Email"),
                                                req.getParameter("Username"),
                                                req.getParameter("Password"),
                                                req.getParameter("PhoneNumber"),
                                                req.getParameter("ReferralCode"));
            
            if (dao.updateUserData(updateUser)){
                res.setStatus(HttpServletResponse.SC_CREATED);
                res.sendRedirect(location); // location -> modifyPage.jsp
            }
            res.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
            
        } catch (IllegalArgumentException ex) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    
    @Override
    protected void doDelete (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {        
        if (dao.deleteUser(req.getParameter("Email"))){
                res.setStatus(HttpServletResponse.SC_OK);
                res.sendRedirect(location); // location -> deleteAccount.jsp
        }
        res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
}
