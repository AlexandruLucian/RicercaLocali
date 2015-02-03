package it.edenred.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import it.edenred.bean.Affiliato;
import it.edenred.mybatis.EdenredClient;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
 
public class RicercaLocaliAction extends Action {
 
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
     
        String target = null;
        Affiliato affiliatoForm = (Affiliato) form;
//        String localita = affiliatoForm.getLocalita();
        String localita = request.getParameter("localita");
        System.out.println("PARAMETRO LOCALITA: " + localita);
        
        EdenredClient edenredClient = new EdenredClient();
        Affiliato[] affiliati = edenredClient.getAffiliati(localita.toUpperCase());
        request.getSession().setAttribute("affiliati", affiliati);
        request.getSession().setAttribute("localita", localita);
        return mapping.findForward("success");
    }
}
