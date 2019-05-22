package com.huishou.inside.demo.action;

import com.huishou.inside.demo.mapper.ControlMapper;
import com.huishou.inside.demo.entity.BeanJsonReturn;
import com.huishou.inside.demo.entity.BeanMachineInstall;
import com.huishou.inside.demo.entity.m_version;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControlAction {
    @Autowired
    ControlMapper controlMapper;
    @GetMapping("/api/admin/host/register/{id}")
    public String RegisterHost(@PathVariable String id){
        RestTemplate restTemplate=new RestTemplate();
        String url="http://zszypro.bmadmin.com/manager/bmadmin/trisubstitutedMachine/insertTrisubstituteMachine";
        final BeanMachineInstall registerHostinfo = controlMapper.getRegisterHostinfo(id);
        System.out.println("注册主机获取内容="+registerHostinfo);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("recycleBinName",registerHostinfo.getSite());
        jsonObject.put("userAddress",registerHostinfo.getCity()+registerHostinfo.getArea()+registerHostinfo.getVillages()+registerHostinfo.getCommunity());
        jsonObject.put("latitudes",registerHostinfo.getLatitude());
        jsonObject.put("longitude",registerHostinfo.getLongitude());
        jsonObject.put("yingChuangNo",registerHostinfo.getMachine_no());
        jsonObject.put("areaMaintenanceId",registerHostinfo.getArea4code());
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity httpEntity = new HttpEntity(jsonObject.toString(), header);
        String response = restTemplate.postForObject(url, httpEntity, String.class);
        System.out.println("注册主机接口返回内容"+response);
        return response.toString();
    }

    @GetMapping("/api/admin/host/enable/{id}")
    public String EnAbleHost(@PathVariable String id){
        RestTemplate restTemplate=new RestTemplate();
        final BeanMachineInstall registerHostinfo = controlMapper.getRegisterHostinfo(id);
        String url="http://dbsprod-console.dabashounb.com/api/admin/app/androidHost/"+registerHostinfo.getMachine_no()+"/online";
        JSONObject jsonObject = JSONObject.fromObject(registerHostinfo);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity httpEntity = new HttpEntity(jsonObject.toString(), header);
        String response = restTemplate.postForObject(url, httpEntity, String.class);
        return response.toString();
    }
    @GetMapping("/api/admin/version")
    public BeanJsonReturn gerVersion(){
        BeanJsonReturn beanJsonReturn = new BeanJsonReturn();
        m_version version = controlMapper.getVersion();
        if(version==null){
            beanJsonReturn.setErrcode("0");
            beanJsonReturn.setErrmsg("获取版本号失败");
        }else {
            beanJsonReturn.setErrcode("1");
            beanJsonReturn.setErrmsg("获取版本号成功");
            beanJsonReturn.setData(version);
        }
        return beanJsonReturn;
    }
}
