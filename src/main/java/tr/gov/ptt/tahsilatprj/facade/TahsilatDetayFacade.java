package tr.gov.ptt.tahsilatprj.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.tahsilatprj.entity.TahsilatDetay;


@Stateless
public class TahsilatDetayFacade extends AbstractFacade<TahsilatDetay> {
    @PersistenceContext(unitName = "tr.gov.ptt_TahsilatPrj_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TahsilatDetayFacade() {
        super(TahsilatDetay.class);
    }

}
