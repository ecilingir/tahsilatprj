
package tr.gov.ptt.tahsilatprj.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import tr.gov.ptt.tahsilatprj.facade.KisiFacade;
import tr.gov.ptt.tahsilatprj.service.KisiService;

@Named
@SessionScoped
public class ThemeBean implements Serializable{
    private List<String> temaListesi;

    @Inject
    private KisiBean kisiBean;
    @Inject
    private KisiFacade kisiFacade;
    public ThemeBean() {
        temaListesi = new ArrayList<String>();

        temaListesi.add("afterdark");
        temaListesi.add("afternoon");
        temaListesi.add("afterwork");
        temaListesi.add("aristo");
        temaListesi.add("black-tie");
        temaListesi.add("blitzer");
        temaListesi.add("bluesky");
        temaListesi.add("bootstrap");
        temaListesi.add("casablanca");
        temaListesi.add("cupertino");
        temaListesi.add("cruze");
        temaListesi.add("dark-hive");
        temaListesi.add("delta");
        temaListesi.add("dot-luv");
        temaListesi.add("eggplant");
        temaListesi.add("excite-bike");
        temaListesi.add("flick");
        temaListesi.add("glass-x");
        temaListesi.add("home");
        temaListesi.add("hot-sneaks");
        temaListesi.add("humanity");
        temaListesi.add("le-frog");
        temaListesi.add("midnight");
        temaListesi.add("mint-choc");
        temaListesi.add("overcast");
        temaListesi.add("pepper-grinder");
        temaListesi.add("redmond");
        temaListesi.add("rocket");
        temaListesi.add("sam");
        temaListesi.add("smoothness");
        temaListesi.add("south-street");
        temaListesi.add("start");
        temaListesi.add("sunny");
        temaListesi.add("swanky-purse");
        temaListesi.add("trontastic");
        temaListesi.add("ui-darkness");
        temaListesi.add("ui-lightness");
        temaListesi.add("vader");

    }
    
    public List<String> getTemaListesi() {
        return temaListesi;
    }

    public void setTemaListesi(List<String> temaListesi) {
        this.temaListesi = temaListesi;
    }
    public void temayiKaydet()
    {
        kisiFacade.edit(kisiBean.getKisi());
    }
    
}
