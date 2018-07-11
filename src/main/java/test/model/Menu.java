package test.model;

/**
 * @Author zhaobinr
 * @Date 2018/7/11 12 25
 * @Description
 */
public class Menu {
    private String menuName;
    private Menu subMenu;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Menu getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(Menu subMenu) {
        this.subMenu = subMenu;
    }
}
