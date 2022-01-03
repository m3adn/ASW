/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package back_end.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import back_end.class_obj.Portfolio_Item;
import back_end.model.DAO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author epilif3sotnas
 */
@WebServlet(name = "Portfolio", urlPatterns = {"/Servlet/Portfolio"})
public class Portfolio extends HttpServlet {
    DAO dao = new DAO();

    @Override
    protected void doGet(HttpServletRequest req ,HttpServletResponse res)
            throws ServletException, IOException {
        
        ArrayList<Portfolio_Item> portfolio = dao.getPortfolio(req.getParameter("email"));
        
        // fill portfolio with data from an api -> binance
        
        if (!portfolio.isEmpty()) {
            PrintWriter out = res.getWriter();
            JSONArray array = new JSONArray();
            JSONObject obj = new JSONObject();
            
            int size = portfolio.size();
            for (short i = 0; i < size; i++) {
                obj.put("Coin", portfolio.get(i).getCoin());
                obj.put("Units", portfolio.get(i).getUnits());
                obj.put("purchaseDate", portfolio.get(i).getPurchaseDate());
                obj.put("purchaseValue", portfolio.get(i).getPurchaseValue());
                obj.put("currentPrice", portfolio.get(i).getCurrentPrice());
                obj.put("percentageChange", portfolio.get(i).getPercentageChange());
                obj.put("currentAssetValue", portfolio.get(i).getCurrentAssetValue());
                
                array.add(obj);
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
