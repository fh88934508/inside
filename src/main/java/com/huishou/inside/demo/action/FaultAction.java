package com.huishou.inside.demo.action;

import com.huishou.inside.demo.Mapper.FaultMapper;
import com.huishou.inside.demo.bean.BeanBadList;
import com.huishou.inside.demo.bean.BeanJsonReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class FaultAction {
    @Autowired
    FaultMapper faultMapper;
    @GetMapping("/api/admin/fault/bad")
    public BeanJsonReturn getBadList(){
        List<BeanBadList> list=faultMapper.getBadList();
        BeanJsonReturn beanJsonReturn = new BeanJsonReturn();
        if (list.size()==0){
            beanJsonReturn.setErrcode("0");
            beanJsonReturn.setErrmsg("查询数据为空");
        }else{
            beanJsonReturn.setErrcode("1");
            beanJsonReturn.setErrmsg("查询数据成功");
            beanJsonReturn.setParamList(list);
        }
        return beanJsonReturn;
    }

    @GetMapping("/api/admin/fault/badrecode/{ah_id}")
    public BeanJsonReturn getBadRecode10(@PathVariable String ah_id){
        List<Map<String,String>> list=faultMapper.getFaultRecord(ah_id);
        BeanJsonReturn beanJsonReturn = new BeanJsonReturn();
        if (list.size()==0){
            beanJsonReturn.setErrcode("0");
            beanJsonReturn.setErrmsg("查询数据为空");
        }else{
            beanJsonReturn.setErrcode("1");
            beanJsonReturn.setErrmsg("查询数据成功");
            beanJsonReturn.setParamList(list);
        }
        return beanJsonReturn;
    }
}
