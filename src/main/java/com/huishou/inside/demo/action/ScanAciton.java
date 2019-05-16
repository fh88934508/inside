package com.huishou.inside.demo.action;

import net.sf.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController

public class ScanAciton {

    @PostMapping("/api/admin/minip/{id}/ProviderUserlogin")
    public String  ProviderUserlogin(@PathVariable String id){

        RestTemplate restTemplate=new RestTemplate();
        String url="http://dbsprod-console.dabashounb.com/api/admin/app/"+id+"/ProviderUserlogin";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("outId",38);
        jsonObject.put("username","13800000000");
        jsonObject.put("realname","minip");
        jsonObject.put("type","repair");
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity httpEntity = new HttpEntity(jsonObject.toString(), header);
        String response = restTemplate.postForObject(url, httpEntity, String.class);
        return response.toString();
    }

}
