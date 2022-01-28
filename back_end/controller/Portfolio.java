/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package back_end.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import back_end.classes.portfolio.Portfolio_Item;
import back_end.model.DAO;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author epilif3sotnas
 */
@WebServlet(name = "Portfolio", urlPatterns = {"/Servlet/Portfolio"})
public class Portfolio extends HttpServlet {
    private DAO dao = new DAO();

    @Override
    protected void doGet(HttpServletRequest req ,HttpServletResponse res)
            throws ServletException, IOException {
        
        ArrayList<Portfolio_Item> portfolio = dao.getPortfolio(req.getParameter("Email"));
        
        // fill portfolio with data from an api -> binance
        
        if (!portfolio.isEmpty()) {
            PrintWriter out = res.getWriter();
            JSONArray array = new JSONArray();
            JSONObject obj = new JSONObject();
            
            int size = portfolio.size();
            for (short i = 0; i < size; i++) {
                obj.put("Coin", portfolio.get(i).getCoin());
                obj.put("Units", portfolio.get(i).getUnits());
                obj.put("PurchaseDate", portfolio.get(i).getPurchaseDate());
                obj.put("PurchaseValue", portfolio.get(i).getPurchaseValue());
                obj.put("CurrentPrice", portfolio.get(i).getCurrentPrice());
                obj.put("PercentageChange", portfolio.get(i).getPercentageChange());
                obj.put("CurrentAssetValue", portfolio.get(i).getCurrentAssetValue());
                
                array.put(obj);
                obj.clear();
            }
            res.setStatus(HttpServletResponse.SC_OK);
            res.setContentType("application/json");
            out.print(array);
            out.flush();
        }
        res.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
    }
}
