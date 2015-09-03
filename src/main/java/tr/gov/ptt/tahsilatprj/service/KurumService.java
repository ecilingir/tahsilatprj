package tr.gov.ptt.tahsilatprj.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import tr.gov.ptt.tahsilatprj.facade.KurumFacade;

@Stateless
public class KurumService {
    
    @Inject
    private KurumFacade kurumFacade;
    
    public List<String> kurumAdlarınıGetir()
    {
      return kurumFacade.kurumAdlarınıGetir();
    }
    
    public Integer KurumAdiIleNoGetir(String p_kurumAdi)
    {
      return kurumFacade.KurumAdiIleNoGetir(p_kurumAdi);
    }
    
}
