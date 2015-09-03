package tr.gov.ptt.tahsilatprj.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import tr.gov.ptt.tahsilatprj.entity.Borc;
import tr.gov.ptt.tahsilatprj.facade.BorcFacade;

@Stateless
public class BorcService {
    
    @Inject
    BorcFacade borcFacade;

    public List<Borc> borclariGetir(Integer p_kurum_no, String p_abone_no) {
        return borcFacade.borclariGetir(p_kurum_no, p_abone_no);
        
    }
    
}
