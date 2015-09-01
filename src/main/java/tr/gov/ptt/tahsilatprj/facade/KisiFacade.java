/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.tahsilatprj.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.tahsilatprj.entity.Kisi;

/**
 *
 * @author BEM
 */
@Stateless
public class KisiFacade extends AbstractFacade<Kisi> {
    @PersistenceContext(unitName = "tr.gov.ptt_TahsilatPrj_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KisiFacade() {
        super(Kisi.class);
    }
    
        public Kisi girisKontrol(Kisi p_kisi)
    {
       try
       {    
          Kisi kisi = (Kisi)em.createNamedQuery("Kisi.girisKontrol")
                              .setParameter("kullaniciAd", p_kisi.getKullaniciAd())
                              .setParameter("sifre", p_kisi.getSifre())
                              .getSingleResult();
       
          return kisi;      
       }
       catch(NoResultException nre)
       {
          return null;
       }
       
    }
    
}
