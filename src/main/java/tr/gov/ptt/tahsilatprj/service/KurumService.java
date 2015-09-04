package tr.gov.ptt.tahsilatprj.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import tr.gov.ptt.tahsilatprj.facade.KurumFacade;

@Stateless
public class KurumService {
    
    @Inject
    private KurumFacade kurumFacade;
    
    
    public List<String> kurumAdlariniGetir()
    {
        return kurumFacade.kurumAdlariniGetir();
    }
    
    public Integer kurumAdIleNoGetir(String p_kurumAdi)
    {
       
        return kurumFacade.kurumAdIleNoGetir(p_kurumAdi);
        
    }

}
