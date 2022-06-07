/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DeptDBContext;
import dal.EmpDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Dept;
import model.Emp;

/**
 *
 * @author Ngo Tung Son
 */
public class SearchController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        DeptDBContext dbDept = new DeptDBContext();
        ArrayList<Dept> depts = dbDept.list();
        request.setAttribute("depts", depts);
        request.getRequestDispatcher("../view/emp/search.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int did = Integer.parseInt(request.getParameter("did"));
        EmpDBContext dbEmp = new EmpDBContext();
        ArrayList<Emp> emps = dbEmp.searchByDid(did);
        request.setAttribute("emps", emps);
        DeptDBContext dbDept = new DeptDBContext();
        ArrayList<Dept> depts = dbDept.list();
        request.setAttribute("depts", depts);
        request.getRequestDispatcher("../view/emp/search.jsp").forward(request, response);
    }

    


}
