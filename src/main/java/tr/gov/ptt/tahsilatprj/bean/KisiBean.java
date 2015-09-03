
package tr.gov.ptt.tahsilatprj.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import tr.gov.ptt.tahsilatprj.entity.Kisi;
import tr.gov.ptt.tahsilatprj.service.KisiService;
import tr.gov.ptt.tahsilatprj.util.JSFUtil;


@Named(value = "kisiBean")
@SessionScoped
public class KisiBean implements Serializable {

    private Kisi kisi = new Kisi();
    
    @Inject
    private KisiService kisiService;
    
    
    public KisiBean() {
        kisi.setTema("afterwork");
        
        kisi.setKullaniciAd("esra");
        kisi.setSifre("1234");
    }

    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }
    
    public String girisKontrol()
    {
        
         ResourceBundle backendText = 
                 FacesContext.getCurrentInstance().getApplication().
                         getResourceBundle(FacesContext.getCurrentInstance(), "msg");
       
        Kisi vtKisi = kisiService.girisKontrol(this.kisi);
        if (vtKisi != null) {
            
            this.kisi = vtKisi;
            
            HttpSession session = JSFUtil.getSession();
            
            session.setAttribute("kullanici", this.kisi.getKullaniciAd());
            
            return "menu.xhtml";
            
        } else {
            kisi = new Kisi();
            JSFUtil.hataGoster(backendText.getString("tahsilatprj.giris.loginErrorSummary"), 
                               backendText.getString("tahsilatprj.giris.loginErrorDetail"));
            return "";
        }  
    }
    
    public String guvenliCikis()
    {
       HttpSession session = JSFUtil.getSession();
       JSFUtil.sessionBitir(session);
       JSFUtil.mesajGoster("Session bitti.", "Yeniden giriş yapınız.");
       
       return "giris.xhtml?faces-redirect=true";
       
       
    }
    
    
    
}





















