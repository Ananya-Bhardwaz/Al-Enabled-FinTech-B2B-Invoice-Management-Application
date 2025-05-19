package com.highradius.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highradius.Entity.HighRadiusEntity;

import jdbc.connection.DbConnection;

/**
 * Servlet implementation class AdvanceSearch
 */
@WebServlet("/AdvanceSearch")
public class AdvanceSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdvanceSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		String doc_id = request.getParameter("doc_id");
		String cust_number = request.getParameter("cust_number");
		String invoice_id = request.getParameter("invoice_id");
		String buisness_year = request.getParameter("buisness_year");
		
		DbConnection obj = new DbConnection();
		Connection conn = obj.CreateC();
		String query = "SELECT * FROM winter_internship WHERE doc_id='"+doc_id+"' AND cust_number='"+cust_number+"' AND invoice_id='"+invoice_id+"' AND buisness_year='"+buisness_year+"' LIMIT 10";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<HighRadiusEntity> data = new ArrayList<>();
		
		while(rs.next()) {
			
			HighRadiusEntity row = new HighRadiusEntity();
			
			row.setSl_no(rs.getInt("sl_no"));
			row.setBusinessCode(rs.getString("business_code"));   
			row.setCustNumber(rs.getString("cust_number"));   
			row.setClear_date(rs.getString("clear_date"));   
			row.setBuisness_year(Integer.parseInt(rs.getString("buisness_year")));   
			row.setDoc_id(rs.getString("doc_id"));   
			row.setPosting_date(rs.getString("posting_date"));   
			row.setDocument_create_date(rs.getString("document_create_date"));   
			row.setDue_in_date(rs.getString("due_in_date"));   
			row.setInvoice_currency(rs.getString("invoice_currency"));   
			row.setDocument_type(rs.getString("document_type"));   
			row.setPosting_id(rs.getInt("posting_id"));   
			row.setTotal_open_amount(rs.getString("total_open_amount"));   
			row.setBaseline_create_date(rs.getString("baseline_create_date"));   
			row.setCust_payment_terms(rs.getString("cust_payment_terms"));   
			row.setInvoice_id(rs.getString("invoice_id"));
			
			data.add(row);
		}
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(data);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonData);
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	} catch (Exception e) {
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
