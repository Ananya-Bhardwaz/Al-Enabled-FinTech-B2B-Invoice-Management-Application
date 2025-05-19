package com.highradius.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.connection.DbConnection;

/**
 * Servlet implementation class AddData
 */
@WebServlet("/AddData")
public class AddData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DbConnection obj = new DbConnection();
		
		Connection con = obj.CreateC();
		
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement("insert into adding(business_code,cust_number,clear_date,buisness_year,doc_id,"
					+ "posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,"
					+ "total_open_amount,baseline_create_date,cust_payment_terms,invoice_id) values(?, ?, ?, ?, ?, ?, ?"
					+ ", ?, ?, ?, ?, ?, ?, ?, ?)");
			
			
			ps.setString(1 , request.getParameter("business_code"));
			ps.setString(2 , request.getParameter("cust_number"));
			ps.setString(3 , request.getParameter("clear_date"));
			ps.setString(4 , request.getParameter("buisness_year"));
			ps.setString(5 , request.getParameter("doc_id"));
			ps.setString(6 , request.getParameter("posting_date"));
			ps.setString(7 , request.getParameter("document_create_date"));
			ps.setString(8 , request.getParameter("due_in_date"));
			ps.setString(9 , request.getParameter("invoice_currency"));
			ps.setString(10, request.getParameter("document_type"));
			ps.setString(11, request.getParameter("posting_id"));
			ps.setString(12, request.getParameter("total_open_amount"));
			ps.setString(13, request.getParameter("baseline_create_date"));
			ps.setString(14, request.getParameter("cust_payment_terms"));
			ps.setString(15, request.getParameter("invoice_id"));
			
			int a = ps.executeUpdate();
			if(a==1) {
			System.out.println("data added");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
