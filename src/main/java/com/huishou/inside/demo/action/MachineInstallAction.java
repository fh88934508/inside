package com.huishou.inside.demo.action;
import com.huishou.inside.demo.mapper.MachineInstallMapper;
import com.huishou.inside.demo.mapper.UserMapper;
import com.huishou.inside.demo.entity.BeanJsonReturn;
import com.huishou.inside.demo.entity.BeanMachineInstall;
import com.huishou.inside.demo.entity.BeanUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@CrossOrigin
@RestController
public class MachineInstallAction {
    @Autowired
    UserMapper userMapper;

    @Autowired
    MachineInstallMapper machineInstallMapper;
    @RequestMapping("/machine")

    public BeanJsonReturn add(BeanMachineInstall beanMachineInstall) {
        //验证是否登陆
        //验证是否有权限
        UUID uuid = UUID.randomUUID();
        String suuid=uuid.toString().replace("-","");
        beanMachineInstall.setId(suuid);
        machineInstallMapper.addSelect(beanMachineInstall);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");
        beanJsonReturn.setErrmsg("选点成功");
        beanJsonReturn.setId(suuid);
        return beanJsonReturn;
    }
    @RequestMapping("/machine/TitleList")
    public BeanJsonReturn getTitleList(Integer current,Integer pagestep,String site){
        List titleListStep=null;
        current=current+2;
        switch (pagestep){
            case 0:titleListStep = machineInstallMapper.getTitleListStep0(current);break;
            case 1:titleListStep = machineInstallMapper.getTitleListStep1(current,site);break;
            default:titleListStep=null;break;
        }
        List<Map<String, Object>> stepCount = machineInstallMapper.getStepCount();
        List<String> list = new ArrayList<>();
        list.add("已选点");
        list.add("地坪中");
        list.add("待安装");
        list.add("待调试");
        list.add("已上线");

            for (Map<String,Object> m:stepCount) {
                Integer title = Integer.valueOf(m.get("title").toString());
                switch (title){
                    case 2 :list.set(0,"已选点"+m.get("count"));break;
                    case 3 :list.set(1,"地坪中"+m.get("count"));break;
                    case 4 :list.set(2,"待安装"+m.get("count"));break;
                    case 5 :list.set(3,"待调试"+m.get("count"));break;
                    case 6 :list.set(4,"已上线"+m.get("count"));break;
                }
            }
        Map paramMap=new HashMap();
        paramMap.put("steplist",list);
        paramMap.put("title",titleListStep);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");
        beanJsonReturn.setParamMap(paramMap);
        return beanJsonReturn;
    }
    @RequestMapping("/machine/selectverify")
    public BeanJsonReturn Selectverify(String id){
        Map<String,String> selectVerify = machineInstallMapper.getSelectVerify(id);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");
        beanJsonReturn.setParamMap(selectVerify);
        return beanJsonReturn;
    }
    @RequestMapping("/machine/setselectverify")
    public  BeanJsonReturn setSelectverify(String id, String remark,String step,String longitude,String latitude,String terrace_progress){

        machineInstallMapper.updateSelectVerify(id,remark,step,latitude,longitude,terrace_progress);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");
        beanJsonReturn.setId(id);
        return beanJsonReturn;
    }
    @RequestMapping("/machine/cancellation")
    public BeanJsonReturn cancellation(String id,String remark){
        machineInstallMapper.cancellation(id,remark);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");
        beanJsonReturn.setId(id);
        return beanJsonReturn;
    }
    @RequestMapping("/machine/terrace")
    public BeanJsonReturn terrace(String id){
        Map<String, String> getterrace = machineInstallMapper.getterrace(id);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");
        beanJsonReturn.setParamMap(getterrace);
        return beanJsonReturn;
    }
    @RequestMapping("/machine/updateterrace")
    public BeanJsonReturn updateterrace(String id,String terracestep,String remark,String step){
         machineInstallMapper.updateterrace(id,terracestep,remark,step);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");

        return beanJsonReturn;
    }

    @RequestMapping("/machine/order")
    public BeanJsonReturn getorder(String orderno){
        Map<String,String> getorder = machineInstallMapper.getorder(orderno);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");
        beanJsonReturn.setParamMap(getorder);
        return beanJsonReturn;
    }
    @RequestMapping("/machine/detail")
    public BeanJsonReturn getdtail(String orderno){
        Map<String,String> getorder = machineInstallMapper.getdtail(orderno);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");
        beanJsonReturn.setParamMap(getorder);
        return beanJsonReturn;
    }
    @RequestMapping("/machine/debug")
    public BeanJsonReturn updatedebug(String id,String remark){
         machineInstallMapper.updatedebug(id,remark);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");
        return beanJsonReturn;
    }
    @RequestMapping("/machine/install")
    public BeanJsonReturn updateinstall(String id,String remark,String machineno){
        machineInstallMapper.updateinstall(id,remark,machineno);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");
        return beanJsonReturn;
    }
    @RequestMapping("/machine/updaterepair")
    public BeanJsonReturn updateRepair(String id){
        String terrace_progress="地坪修复中";
        machineInstallMapper.updateRepair(id,terrace_progress);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");
        return beanJsonReturn;
    }

    @RequestMapping("/2version/m_select")
    public BeanJsonReturn new2m_select(BeanMachineInstall beanMachineInstall){
        UUID uuid = UUID.randomUUID();
        String suuid=uuid.toString().replace("-","");
        beanMachineInstall.setId(suuid);
        machineInstallMapper.new2m_select(beanMachineInstall);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");
        beanJsonReturn.setId(suuid);
        System.out.println(beanMachineInstall.toString());
        return beanJsonReturn;
    }
    @RequestMapping("/2version/m_install")
    public BeanJsonReturn new2m_install(BeanMachineInstall beanMachineInstall){
        machineInstallMapper.new2m_install(beanMachineInstall);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");
        return beanJsonReturn;
    }
    @RequestMapping("/2version/m_title/{pagestep}")
    public BeanJsonReturn new2m_title(@PathVariable Integer pagestep){
        List titleListStep=null;

        switch (pagestep){
            case 0: titleListStep=machineInstallMapper.new2m_title1();break;
            case 1: titleListStep=machineInstallMapper.new2m_title2();break;
            default:break;
        }
        List<Map<String, Object>> stepCount = machineInstallMapper.getStepCount();
        List<String> list = new ArrayList<>();
        list.add("待安装");
        list.add("已上线");
        for (Map<String,Object> m:stepCount) {
            Integer step = Integer.valueOf(m.get("title").toString());
            switch (step){
                case 4 :list.set(0,"待安装"+m.get("count"));break;
                case 6 :list.set(1,"已上线"+m.get("count"));break;
            }
        }
        Map paramMap=new HashMap();
        paramMap.put("steplist",list);
        paramMap.put("title",titleListStep);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");
        beanJsonReturn.setParamMap(paramMap);
        return beanJsonReturn;
    }
    @RequestMapping("/2version/m_modify")
    @PreAuthorize("hasAnyRole('ROLE_INSTALL','ROLE_ADMIN','ROLE_SUPPERADMIN','ROLE_OPERATION')")
    public BeanJsonReturn new2m_modify(BeanMachineInstall beanMachineInstall){
        machineInstallMapper.new2m_modify(beanMachineInstall);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");
        beanJsonReturn.setId(beanMachineInstall.getId());
        return beanJsonReturn;
    }
    @RequestMapping("/2version/detail")
    public BeanJsonReturn get2versiondetail(String id){
        Map<String,String> getorder = machineInstallMapper.get2versiondetail(id);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");
        beanJsonReturn.setParamMap(getorder);
        return beanJsonReturn;
    }
    @PostMapping("/2version/user" )
    public BeanJsonReturn add2versionName(BeanUser beanUser){
        userMapper.insertNameOpenid(beanUser);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");
        beanJsonReturn.setErrmsg(beanUser.toString());
        return beanJsonReturn;
    }
    @PutMapping("/2version/user" )
    public BeanJsonReturn modify2versionName(BeanUser beanUser){
        userMapper.update(beanUser);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");
        beanJsonReturn.setErrmsg(beanUser.toString());
        return beanJsonReturn;
    }
    @GetMapping("/2version/user" )
    public BeanJsonReturn get2versionName(String openid){
        Map<String, String> map = userMapper.getbyopenid(openid);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("1");
        beanJsonReturn.setParamMap(map);
        return beanJsonReturn;
    }




}
