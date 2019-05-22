package com.huishou.inside.demo.action;

import com.huishou.inside.demo.Mapper.MapMapper;
import com.huishou.inside.demo.bean.BeanJsonReturn;
import com.huishou.inside.demo.bean.BeanMachineInstall;
import com.huishou.inside.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MapAction {
    @Autowired
    MapMapper mapMapper;
    @GetMapping("api/admin/map")
    @PreAuthorize("hasAnyRole('ROLE_REPAIR','ROLE_INSTALL','ROLE_ADMIN','ROLE_SUPPERADMIN')")
    public BeanJsonReturn getAllMap(){
        List<BeanMachineInstall> mapAll = mapMapper.getMapAll();
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrmsg("OK");
        beanJsonReturn.setErrcode("1");
        beanJsonReturn.setParamList(mapAll);
        return beanJsonReturn;
    }
}
