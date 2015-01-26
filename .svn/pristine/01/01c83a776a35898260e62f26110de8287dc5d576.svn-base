package com.helloworld.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.helloworld.form.LoginForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
 
public class LoginAction extends Action {
 
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
     
        String target = null;
        LoginForm loginForm = (LoginForm)form; 
             
        if (loginForm.getUserName().equals("admin") && loginForm.getPassword().equals("admin123")) {
            request.setAttribute("username", loginForm.getUserName());
            target = "success";            
        } else {  
        	if (loginForm.getUserName().equals("admin") && !loginForm.getPassword().equals("admin123")) { 
        		request.setAttribute("error", "error1");
        		request.setAttribute("username", loginForm.getUserName());
        	} else {
        		request.setAttribute("error", "error2");
        	}
        	        		
        	target = "failure";
        }
         
        return mapping.findForward(target);
    }
}