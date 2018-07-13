package test.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhaobinr
 * @Date 2018/7/11 12 25
 * @Description
 * 菜单实例类
 * ztree 说明文档路径http://www.treejs.cn/v3/api.php
 */
public class Menu {
    private String id;
    private String pId;
    private String name;
    private String open;
    private List<Menu> children;
    private String checked;
    private String click;
    private boolean editNameFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }

    public boolean isEditNameFlag() {
        return editNameFlag;
    }

    public void setEditNameFlag(boolean editNameFlag) {
        this.editNameFlag = editNameFlag;
    }

    public void addMenu(Menu menu) {
        if (null == children) {
            children = new ArrayList<>();
        }
        children.add(menu);
    }
}
