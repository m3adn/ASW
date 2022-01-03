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

import back_end.class_obj.Request_Money;
import back_end.model.DAO;

/**
 *
 * @author epilif3sotnas
 */
@WebServlet(name = "Withdraw", urlPatterns = {"/Servlet/Money/Withdraw"})
public class Withdraw extends HttpServlet {
    DAO dao = new DAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        Request_Money reqMoney = new Request_Money(req.getParameter("coin"),
                                                   Float.parseFloat(req.getParameter("units")),
                                                   true);
        if (dao.withdraw(req.getParameter("username"), reqMoney)) {
            res.setStatus(HttpServletResponse.SC_OK);
        }
        res.sendError(HttpServletResponse.SC_CONFLICT);
    }
}
