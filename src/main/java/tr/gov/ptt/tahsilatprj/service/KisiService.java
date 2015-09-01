
package tr.gov.ptt.tahsilatprj.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import tr.gov.ptt.tahsilatprj.entity.Kisi;
import tr.gov.ptt.tahsilatprj.facade.KisiFacade;


@Stateless
public class KisiService {
    
    @Inject
    private KisiFacade kisiFacade;
    
    
    
    public Kisi girisKontrol(Kisi p_kisi)
    {
       return kisiFacade.girisKontrol(p_kisi);
    }
    
}
