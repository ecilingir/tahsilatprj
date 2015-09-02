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
import tr.gov.ptt.tahsilatprj.entity.Menu;

/**
 *
 * @author BEM
 */
@Stateless
public class MenuFacade extends AbstractFacade<Menu> {
    @PersistenceContext(unitName = "tr.gov.ptt_TahsilatPrj_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuFacade() {
        super(Menu.class);
    }
    
    public List<Menu> altMenuleriGetir(Integer p_ustno)
    {
        return em.createNamedQuery("Menu.findByUstmenu").setParameter("ustmenu", p_ustno).getResultList();
    }
    
}
