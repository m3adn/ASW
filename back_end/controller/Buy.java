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

import back_end.class_obj.Request_Coins;
import back_end.model.DAO;

/**
 *
 * @author epilif3sotnas
 */
@WebServlet(name = "Buy", urlPatterns = {"/Servlet/Coins/Buy"})
public class Buy extends HttpServlet {
    DAO dao = new DAO();

    @Override
    protected void doPut (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        Request_Coins reqCoins = new Request_Coins(req.getParameter("coin"),
                                                   Float.parseFloat(req.getParameter("units")),
                                                   true);
        if (dao.buyCoins(req.getParameter("username"), reqCoins)) {
            res.setStatus(HttpServletResponse.SC_OK);
        }
        res.sendError(HttpServletResponse.SC_CONFLICT);
    }
}
