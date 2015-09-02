package tr.gov.ptt.tahsilatprj.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import tr.gov.ptt.tahsilatprj.entity.Menu;
import tr.gov.ptt.tahsilatprj.facade.MenuFacade;

@Named
@SessionScoped
public class MenuBean implements Serializable {

    @Inject
    KisiBean kisiBean;
    private MenuModel menuModel;

    @Inject
    private MenuFacade menuFacade;

    public MenuBean() {
        menuModel = new DefaultMenuModel();

    }

    @PostConstruct
    public void menuDoldur() {

        List<Menu> ustMenuListesi = kisiBean.getKisi().getTip().getMenuList();
        for (Menu ustMenu : ustMenuListesi) {
            DefaultSubMenu subMenu = new DefaultSubMenu(ustMenu.getBaslik());
            menuModel.addElement(subMenu);
            List<Menu> altMenuListesi = menuFacade.altMenuleriGetir(ustMenu.getNo());
            for (Menu altMenu : altMenuListesi) {
                DefaultMenuItem menuItem = new DefaultMenuItem(altMenu.getBaslik());
                menuItem.setCommand(altMenu.getLink());
                menuItem.setIcon(altMenu.getIcon());
                subMenu.addElement(menuItem);
            }
        }
    }

    public MenuModel getModel() {
        return menuModel;
    }

}
