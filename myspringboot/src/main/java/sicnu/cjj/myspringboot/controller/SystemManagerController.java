package sicnu.cjj.myspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sicnu.cjj.myspringboot.entity.Role;
import sicnu.cjj.myspringboot.result.Result;
import sicnu.cjj.myspringboot.result.ResultGenerator;
import sicnu.cjj.myspringboot.service.SystemManagerService;

import java.util.List;

@RestController
@RequestMapping("systemmanager")
public class SystemManagerController {

    @Autowired
    SystemManagerService systemManagerService;

    @RequestMapping("getroles")
    public Result getallrole(){

        List<Role> roles=systemManagerService.getallrole();
        System.out.println(roles);
        return ResultGenerator.genSuccessResult(roles);
    }
}
