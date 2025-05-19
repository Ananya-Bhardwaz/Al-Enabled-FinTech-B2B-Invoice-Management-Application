package com.highradius.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.connection.DbConnection;
import java.sql.*;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.highradius.Entity.*;

/**
 * Servlet implementation class ViewInvoice
 */
@WebServlet("/ViewInvoice")
public class ViewInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewInvoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList< HighRadiusEntity> data = new ArrayList<>();
		DbConnection obj = new DbConnection();
		
		Connection con = obj.CreateC();
		
		
		try {
			Statement st = con.createStatement();
			
			String sql = "select * from winter_internship";
			
			ResultSet rs = st.executeQuery(sql);
			
			
			while(rs.next())
			{
				HighRadiusEntity in = new  HighRadiusEntity();
				
				in.setSl_no(rs.getInt("sl_no"));
				in.setBusinessCode(rs.getString("business_code"));
				in.setCustNumber(rs.getString("cust_number"));
				in.setClear_date(rs.getString("clear_date"));
				in.setBuisness_year(rs.getInt("buisness_year"));
				in.setDoc_id(rs.getString("doc_id"));
				in.setPosting_date(rs.getString("posting_date"));
				in.setDocument_create_date(rs.getString("document_create_date"));
				in.setDocument_create_date1(rs.getString("document_create_date1"));
				in.setDue_in_date(rs.getString("due_in_date"));
				in.setInvoice_currency(rs.getString("invoice_currency"));
				in.setDocument_type(rs.getString("document_type"));
				in.setPosting_id(rs.getInt("posting_id"));
				in.setArea_business(rs.getString("area_business"));
				in.setTotal_open_amount(rs.getString("total_open_amount"));
				in.setBaseline_create_date(rs.getString("baseline_create_date"));
				in.setCust_payment_terms(rs.getString("cust_payment_terms"));
				in.setInvoice_id(rs.getString("invoice_id"));
				in.setIsOpen(rs.getString("isOpen"));
				in.setAging_bucket(rs.getString("aging_bucket"));
				in.setIs_deleted(rs.getString("is_deleted"));
				
				data.add(in);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		String invoices  = gson.toJson(data);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().write(invoices);
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
