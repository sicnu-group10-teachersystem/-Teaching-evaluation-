package sicnu.cjj.myspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sicnu.cjj.myspringboot.entity.Authority;
import sicnu.cjj.myspringboot.mapper.BusManagerMapper;
import sicnu.cjj.myspringboot.service.BusManagerService;

import java.util.List;

@RestController
@RequestMapping("BusManager")
public class BusManagerController {

    @Autowired
    BusManagerService busManagerService;

    @RequestMapping("getauthoritylist")
    public String getauthority(){
        return null;
    }
    @RequestMapping("getallauthoritylist")
    public List<Authority> getallauthority(){
        List<Authority> authorities = busManagerService.getallauthoritylist();
        return authorities;
    }


}
