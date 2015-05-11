/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import control.filehandlers.FileHandler;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dinanajana
 */
public class ViewBlog extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String user = request.getParameter("View");
        FileHandler reviewed;
        String URL = "C:\\Users\\Dinanajana\\Documents\\NetBeansProjects\\Blogger\\src\\java\\content\\refferredContent\\";
        File folder = new File(URL);
        File[] listOfFiles = folder.listFiles();
        
        String blogNames="<form method=\"POST\" action=\"show_blog\">";

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                
                String fileName = listOfFiles[i].getName();
                System.out.println("File vieBlog " + fileName); 
                
                
                blogNames = blogNames + "<input type =\"submit\" name =\"blog\" value="+fileName+"><br>";
                
                if(user.equals("View the blog")){
                    
                    blogNames = blogNames + "<input type =\"hidden\" name =\"User\" value=\"user\"><br>";
                    
                }else if(user.equals("View")){
                
                     blogNames = blogNames + "<input type =\"hidden\" name =\"User\" value=\"\"><br>";
                    
                }
                
                
            } else if (listOfFiles[i].isDirectory()) {
        
            System.out.println("Directory " + listOfFiles[i].getName());
            
            }
            
        }
        
        blogNames = blogNames + "</form>";
    
        response.setContentType("text/html");
        request.setAttribute("result", blogNames);
        
        if(user.equals("View the blog")){
            request.setAttribute("type", "user");
            request.getRequestDispatcher("\\Edit\\Blogs.jsp").forward(request, response);
            
        }else{
            request.setAttribute("type", "");
            request.getRequestDispatcher("Blogs.jsp").forward(request, response);
        }
        //request.setAttribute("blog", fileName);
        
    
    }
    
}
