package com.OnlineDoctor.web;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.OnlineDoctor.model.DataGenerator;
//import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OnlineDoctorServlet extends HttpServlet {

	DataGenerator d;

    /*public OnlineDoctorServlet() {
            try {
                this.d = new DataGenerator();
            } catch (Exception ex) {
                Logger.getLogger(OnlineDoctorServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
    }*/

        @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String name ;
	String height ;
	String weight ;
	/* retrieve values for name, ,height and weight from the html form*/
	String bmi;
        
        name = request.getParameter("name");
        height = request.getParameter("height");
        weight = request.getParameter("weight");
        
            try {
                d = new DataGenerator() ;
                
                
                try{
                    float h = Float.parseFloat(height);
                    float w = Float.parseFloat(weight);
                    bmi = d.calculate(name, h, w);
                
                    if(!(h > 0 && w > 0)){
                    
                        bmi = "Errorneous values";
                    }
                        
                

	/*check whether the height and weight are floating values which are greater than zero. If there are errors, generate appropriate error messages. 
create a DataGenerator object, give inputs and get the results into the bmi variable. 
*/
                    //}    
                }catch(Exception ex)
                {
                    bmi = "There is an error in the entered data";
                }
                    
/* now set an attribute and dispatch the request to result.jsp */
                response.setContentType("text/html");
                request.setAttribute("result", bmi);
                request.getRequestDispatcher("/result.jsp").forward(request, response);
                //PrintWriter out = response.getWriter();
                
                
                
                
            } catch (Exception ex) {
                Logger.getLogger(OnlineDoctorServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
	
		
}
}
