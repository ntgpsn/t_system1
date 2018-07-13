package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.constant.Constant;
import test.dao.model.CaseInfo;
import test.dao.model.ProductInfo;
import test.dao.model.ProjectInfo;
import test.dao.service.CaseInfoDaoService;
import test.dao.service.ProductInfoDaoService;
import test.dao.service.ProjectInfoDaoService;
import test.model.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhaobinr
 * @Date 2018/7/13 12 13
 * @Description
 */
@Service
public class MenuService {

    @Autowired
    private ProductInfoDaoService productInfoDao;
    @Autowired
    private ProjectInfoDaoService projectInfoDao;
    @Autowired
    private CaseInfoDaoService caseInfoDao;

    public List<Menu> generateProjectManageMenu(String userId, String accountType) {
        Menu manageMenu = new Menu();
        manageMenu.setId(Constant.PRODUCT_MANAGE_MENU_ID);
        manageMenu.setpId("0");
        manageMenu.setName(Constant.PRODUCT_MANAGE_STR);
        manageMenu.setEditNameFlag(false);

        List<ProductInfo> productInfos = productInfoDao.findAll();
        for (ProductInfo productInfo : productInfos) {
            Menu productMenu = new Menu();
            productMenu.setId(productInfo.getId());
            productMenu.setpId(Constant.PRODUCT_MANAGE_MENU_ID);
            productMenu.setName(productInfo.getProductName());
            productMenu.setEditNameFlag(false);
            manageMenu.addMenu(productMenu);

            //project
            List<ProjectInfo> projectInfos = projectInfoDao.findAllByOrgId(productInfo.getId());
            for (ProjectInfo projectInfo : projectInfos) {
                Menu prijectMenu = new Menu();
                prijectMenu.setId(projectInfo.getId());
                prijectMenu.setpId(productInfo.getId());
                prijectMenu.setName(projectInfo.getProjectName());
                prijectMenu.setEditNameFlag(false);
                productMenu.addMenu(prijectMenu);

                List<CaseInfo> caseInfos = caseInfoDao.findCaseByCreateUserIdAndProjectId(userId, projectInfo.getId());
                for (CaseInfo caseInfo : caseInfos) {
                    Menu caseMenu = new Menu();
                    caseMenu.setId(caseInfo.getId());
                    caseMenu.setpId(projectInfo.getId());
                    caseMenu.setName(caseInfo.getCaseName());
                    prijectMenu.addMenu(caseMenu);
                }

            }
        }
        List<Menu> menus = new ArrayList<>();
        menus.add(manageMenu);
        return menus;
    }

}
