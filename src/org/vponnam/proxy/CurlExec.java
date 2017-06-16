package org.vponnam.proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CurlExec
 */
@WebServlet("/CurlExec")
public class CurlExec extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String host = request.getParameter("HostName");
		out.println("Response from Host:" + host);
		System.out.println(host);
		
		       String[] command = {"curl", "-v", "-H", "Accept:application/json", host};
		        ProcessBuilder process = new ProcessBuilder(command); 
		        Process p;
		        try
		        {
		            p = process.start();
		             BufferedReader reader =  new BufferedReader(new InputStreamReader(p.getInputStream()));
		                StringBuilder builder = new StringBuilder();
		                String line = null;
		                while ( (line = reader.readLine()) != null) {
		                        builder.append(line);
		                        builder.append(System.getProperty("line.separator"));
		                }
		                String result = builder.toString();
		                System.out.print(result);
		             
		                out.println("\n" + result);

		        }
		        catch (IOException e)
		        {   System.out.print("error");
		            e.printStackTrace();
		        }
	    }
	}

