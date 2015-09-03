package tr.gov.ptt.tahsilatprj.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Inject;
import tr.gov.ptt.tahsilatprj.entity.Borc;
import tr.gov.ptt.tahsilatprj.entity.Tahsilat;
import tr.gov.ptt.tahsilatprj.service.BorcService;
import tr.gov.ptt.tahsilatprj.service.KurumService;

@Named(value = "tahsilatBean")
@SessionScoped
public class TahsilatBean implements Serializable {

    private Tahsilat tahsilat = new Tahsilat();
    private Borc borc = new Borc();
    @Inject
    KurumService kurumService;
    @Inject
    BorcService borcService;
    List<Borc> kurumFaturaListesi = new ArrayList<Borc>();
    List<Borc> seciliFaturaListesi = new ArrayList<Borc>();

    private Double toplamPara;
    private Double alinanPara;
    private Double paraUstu;

    public TahsilatBean() {

    }

    public Tahsilat getTahsilat() {
        return tahsilat;
    }

    public void setTahsilat(Tahsilat tahsilat) {
        this.tahsilat = tahsilat;
    }

    public Borc getBorc() {
        return borc;
    }

    public void setBorc(Borc borc) {
        this.borc = borc;
    }

    public List<Borc> getKurumFaturaListesi() {
        return kurumFaturaListesi;
    }

    public void setKurumFaturaListesi(List<Borc> kurumFaturaListesi) {
        this.kurumFaturaListesi = kurumFaturaListesi;
    }

    public List<Borc> getSeciliFaturaListesi() {
        return seciliFaturaListesi;
    }

    public void setSeciliFaturaListesi(List<Borc> seciliFaturaListesi) {
        this.seciliFaturaListesi = seciliFaturaListesi;
    }

    public Double getToplamPara() {
        return toplamPara;
    }

    public void setToplamPara(Double toplamPara) {
        this.toplamPara = toplamPara;
    }

    public Double getAlinanPara() {
        return alinanPara;
    }

    public void setAlinanPara(Double alinanPara) {
        this.alinanPara = alinanPara;
    }

    public Double getParaUstu() {
        return paraUstu;
    }

    public void setParaUstu(Double paraUstu) {
        this.paraUstu = paraUstu;
    }

    public List<String> kurumAdiTamamla(String p_sorgu) {
        List<String> kurumAdiListe = kurumService.kurumAdlarınıGetir();
        List<String> sonucListe = new ArrayList<String>();
        for (String kurumAdi : kurumAdiListe) {
            if (kurumAdi.toUpperCase(new Locale("tr", "TR")).contains(p_sorgu.toUpperCase(new Locale("tr", "TR")))) {
                sonucListe.add(kurumAdi);
            }
        }
        return sonucListe;
    }

    public String borcSorgula() {
        tahsilat.getKurum().setNo(kurumService.KurumAdiIleNoGetir(tahsilat.getKurum().getAd()));
        kurumFaturaListesi = borcService.borclariGetir(tahsilat.getKurum().getNo(), borc.getAboneNo());
        toplamPara = 0.0;
        alinanPara = 0.0;
        paraUstu = 0.0;
        return "tahsilatListele.xhtml?faces-redirect=true";
    }

    public void toplamParaHesapla() {
        toplamPara = 0.0;
        paraUstu = 0.0;
        for (Borc fatura : seciliFaturaListesi) {
            toplamPara = toplamPara + fatura.getFaturaTutar();
        }
        paraUstuHesapla();
    }

    public void paraUstuHesapla() {
        paraUstu = alinanPara - toplamPara;
    }
}
