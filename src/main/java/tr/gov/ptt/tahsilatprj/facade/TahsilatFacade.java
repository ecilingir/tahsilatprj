package tr.gov.ptt.tahsilatprj.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.tahsilatprj.entity.Tahsilat;


@Stateless
public class TahsilatFacade extends AbstractFacade<Tahsilat> {
    @PersistenceContext(unitName = "tr.gov.ptt_TahsilatPrj_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TahsilatFacade() {
        super(Tahsilat.class);
    }
    
    

}
