package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.model.Menu;
import test.service.MenuService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhaobinr
 * @Date 2018/7/11 12 27
 * @Description
 */
@RestController
@RequestMapping(value = "/v1/tcl")
public class MenuController {

    @Autowired private MenuService menuService;

    @RequestMapping(value = "/projectmanageMenu", method = RequestMethod.GET)
    public ResponseEntity<Object> findAllMenu(@RequestParam(value = "userId") String userId,
                                              @RequestParam(value = "accountType") String accountType) {

        try {
            System.out.println("111111111");
            List<Menu> menus = menuService.generateProjectManageMenu(userId, accountType);
            return new ResponseEntity<>(menus, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("操作失败", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
