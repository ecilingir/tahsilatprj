/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.tahsilatprj.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BEM
 */
public class JSFUtil {
    
    public static HttpSession getSession()
    {
       
        HttpSession session= 
                (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        
        return session;
    
    }
    
    public static String getKullanici()
    {
       return getSession().getAttribute("kullanici").toString();
    }
    
    public static void sessionBitir(HttpSession p_session)
    {
        System.out.println(p_session.getId()+" nolu session bitiriliyooooooooooooor");
        p_session.invalidate();
    }
    
    public static void mesajGoster(String p_mesaj, String p_detay)
    {
        FacesContext.getCurrentInstance()
              .addMessage("null", new FacesMessage(FacesMessage.SEVERITY_INFO, p_mesaj, p_detay));
        
        FacesContext.getCurrentInstance().getExternalContext()
                .getFlash().setKeepMessages(true);
    
    }
    
    public static void hataGoster(String p_mesaj, String p_detay)
    {
        FacesContext.getCurrentInstance()
              .addMessage("null", new FacesMessage(FacesMessage.SEVERITY_ERROR, p_mesaj, p_detay));
        
        FacesContext.getCurrentInstance().getExternalContext()
                .getFlash().setKeepMessages(true);
    
    }
    
      
    
}












