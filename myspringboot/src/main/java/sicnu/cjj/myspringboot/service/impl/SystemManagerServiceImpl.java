package sicnu.cjj.myspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sicnu.cjj.myspringboot.entity.Role;
import sicnu.cjj.myspringboot.mapper.SystemManagerMapper;
import sicnu.cjj.myspringboot.service.SystemManagerService;

import java.util.List;

@Service
public class SystemManagerServiceImpl implements SystemManagerService {

    @Autowired
    SystemManagerMapper systemManagerMapper;

    @Override
    public List<Role> getallrole() {
        return systemManagerMapper.getallrole();
    }
}
