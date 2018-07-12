package test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import test.model.Menu;

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

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<Object> findAllMenu() {
        Menu parentMenu = new Menu();
        parentMenu.setName("parent1");
        parentMenu.setOpen("true");
        parentMenu.setId("100002a");
        parentMenu.setpId("100002");

        Menu subMenu1 = new Menu();
        Menu subMenu11 = new Menu();

        subMenu1.setId("100002a1");
        subMenu1.setpId("100002a");
        subMenu1.setName("sub1");

        subMenu11.setId("100002a11");
        subMenu11.setpId("100002a1");
        subMenu11.setName("sub1");
        parentMenu.addMenu(subMenu1);
        List<Menu> menus = new ArrayList<>();
        menus.add(parentMenu);
        return new ResponseEntity<>(parentMenu, HttpStatus.OK);
    }
}
