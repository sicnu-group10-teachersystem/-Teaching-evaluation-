package sicnu.cjj.myspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sicnu.cjj.myspringboot.entity.Authority;
import sicnu.cjj.myspringboot.mapper.BusManagerMapper;
import sicnu.cjj.myspringboot.service.BusManagerService;

import java.util.List;

@Service
public class BusManagerServiceImpl implements BusManagerService {

    @Autowired
    BusManagerMapper busManagerMapper;

    @Override
    public List<Authority> getallauthoritylist() {
        return busManagerMapper.getallauthoritylist();
    }
}
