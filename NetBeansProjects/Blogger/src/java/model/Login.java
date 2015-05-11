

package model;

import control.filehandlers.FileHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dinanajana
 */
public class Login extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
    
        String userName = request.getParameter("name");
        String password = request.getParameter("password");
        String admin = request.getParameter("Admin");
        
        String combi = userName+password ;
        
        String userDetails = "C:\\Users\\Dinanajana\\Documents\\NetBeansProjects\\Blogger\\src\\java\\user_details\\username.txt";
        //String passdetails = "C:\\Users\\Dinanajana\\Documents\\NetBeansProjects\\Blogger\\src\\java\\user_details\\password.txt";
        
        FileHandler handler = new FileHandler(userDetails);
        
        handler.FileReader();
        
        PrintWriter out = response.getWriter();
        out.println("<html>");
	out.println("<head><title>User login</title></head>");
        out.println("<body><h1>Hello user "+userName+"</h1>");
        
        String [] userNpass = handler.content.split("\\r?\\n");
        
        if(Arrays.asList(userNpass).contains(combi)){
        
            out.println("<a href = \"user_options.html\">View the blog</a></br>");
                        
        }else{
            
            out.println("<p>Not a valid usename password combination</p>");
        
        }
        out.println("</body></html>");
    }
    
}
