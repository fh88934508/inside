package com.huishou.inside.demo.decode;
import net.sf.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class code {
    @GetMapping("/wxdecode")
    public String getsession(String code,String encryptedData, String iv)  {
        RestTemplate restTemplate = new RestTemplate();
        String url="https://api.weixin.qq.com/sns/jscode2session?appid=wx3f68a19156a368b3&secret=5b4212e2460bf1018990f98c0cebf38e&js_code="+code+"&grant_type=authorization_code";
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        JSONObject jsonObject1 = JSONObject.fromObject(forEntity.getBody());
        result stu = (result) JSONObject.toBean(jsonObject1,result.class);
        String openid=stu.openid;
        String session_key=stu.session_key;
        System.out.println("请求成功");
        System.out.println("openid="+openid);
        System.out.println("session_key"+session_key);
        System.out.println("encryptedData"+encryptedData);
        System.out.println("iv"+iv);

        WXBizDataCrypt wxBizDataCrypt = new WXBizDataCrypt("wx3f68a19156a368b3",session_key);
        String decrypt = null;
        try {
            decrypt =  wxBizDataCrypt.decrypt(encryptedData, iv).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (decrypt==null){
            return stu.toString();
        }

        return decrypt;
    }


}
