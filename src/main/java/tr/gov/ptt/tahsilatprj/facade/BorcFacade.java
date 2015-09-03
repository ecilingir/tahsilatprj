/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.tahsilatprj.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.tahsilatprj.entity.Borc;

/**
 *
 * @author BEM
 */
@Stateless
public class BorcFacade extends AbstractFacade<Borc> {
    @PersistenceContext(unitName = "tr.gov.ptt_TahsilatPrj_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BorcFacade() {
        super(Borc.class);
    }
    public List<Borc> borclariGetir(Integer p_kurum_no, String p_abone_no)
    {
        return em.createNamedQuery("Borc.findByKurumBorclariniGetir")
                .setParameter("kurumNo",p_kurum_no)
                .setParameter("aboneNo",p_abone_no).getResultList();
    
    }
            
    
}
