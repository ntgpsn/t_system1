package test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        return null;
    }
}
