/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package back_end.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import back_end.classes.request.Request_Coins;
import back_end.model.DAO;

/**
 *
 * @author epilif3sotnas
 */
@WebServlet(name = "Sell", urlPatterns = {"/Servlet/Coins/Sell"})
public class Sell extends HttpServlet {
    private DAO dao = new DAO();

    @Override
    protected void doPut (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        Request_Coins reqCoins = new Request_Coins(req.getParameter("coin"),
                                                   Float.parseFloat(req.getParameter("units")));
        if (dao.sellCoins(req.getParameter("Username"), reqCoins)) {
            res.setStatus(HttpServletResponse.SC_OK);
        }
        res.sendError(HttpServletResponse.SC_CONFLICT);
    }
}
