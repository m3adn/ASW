/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package back_end.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import back_end.class_obj.User_Account;
import back_end.model.DAO;

import org.json.simple.JSONObject;

/**
 *
 * @author epilif3sotnas
 */
@WebServlet(name = "Account", urlPatterns = {"/Servlet/Account"})
public class Account extends HttpServlet {
    DAO dao = new DAO();
    
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            User_Account newUser = new User_Account (req.getParameter("email"),
                                                req.getParameter("username"),
                                                req.getParameter("password"),
                                                req.getParameter("phoneNumber"),
                                                req.getParameter("referralCode"));
            
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
        User_Account userData = dao.getUserData(req.getParameter("username"));
        if (userData.hasAttributes(userData)) {
            PrintWriter out = res.getWriter();
            JSONObject obj = new JSONObject();
            obj.put("email", userData.getEmail());
            obj.put("username", userData.getUsername());
            obj.put("phoneNumber", userData.getPhoneNumber());
            obj.put("referralCode", userData.getReferralCode());
            
            res.setStatus(HttpServletResponse.SC_OK);
            res.setContentType("application/json");
            out.print(obj);
            out.flush();
        }
        res.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
    }

    @Override
    protected void doPut (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            User_Account updateUser = new User_Account(req.getParameter("email"),
                                                req.getParameter("username"),
                                                req.getParameter("password"),
                                                req.getParameter("phoneNumber"),
                                                req.getParameter("referralCode"));
            
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
        if (dao.verifyUser(req.getParameter("email"), req.getParameter("password"))) {
            if (dao.deleteUser(req.getParameter("email"))){
                res.setStatus(HttpServletResponse.SC_OK);
                res.sendRedirect(location); // location -> deleteAccount.jsp
            }
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
