package com.huishou.inside.demo.action;
import com.huishou.inside.demo.Mapper.MachineInstallMapper;
import com.huishou.inside.demo.bean.BeanJsonReturn;
import com.huishou.inside.demo.bean.BeanMachineInstall;
import com.huishou.inside.demo.service.TokenVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@CrossOrigin
@RestController
public class MachineInstallAction {
    @Autowired
    TokenVerifyService tokenVerifyService;
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
        beanJsonReturn.setErrcode("0");
        beanJsonReturn.setErrmsg("选点成功");
        beanJsonReturn.setId(suuid);
        return beanJsonReturn;
    }
    @RequestMapping("/machine/TitleList")
    public BeanJsonReturn getTitleList(Integer current,Integer pagestep,String city,String villages,String Community){
        List titleListStep=null;
        current=current+2;
        switch (pagestep){
            case 0:titleListStep = machineInstallMapper.getTitleListStep0(current);break;
            case 1:titleListStep = machineInstallMapper.getTitleListStep1(current,city);break;
            case 2:titleListStep = machineInstallMapper.getTitleListStep2(current,city,villages);break;
            case 3:titleListStep = machineInstallMapper.getTitleListStep3(current,city,villages,Community);break;
            default:titleListStep=null;break;
        }


        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("0");
        beanJsonReturn.setParamList(titleListStep);
        return beanJsonReturn;
    }
    @RequestMapping("/machine/selectverify")
    public BeanJsonReturn Selectverify(String id){
        Map<String,String> selectVerify = machineInstallMapper.getSelectVerify(id);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("0");
        beanJsonReturn.setParamMap(selectVerify);
        return beanJsonReturn;
    }
    @RequestMapping("/machine/setselectverify")
    public  BeanJsonReturn setSelectverify(String id, String remark,String step,String longitude,String latitude){
        String terrace_progress="无需安装";
        if (step.equals(3)){
            terrace_progress="待安装";
        }
        machineInstallMapper.updateSelectVerify(id,remark,step,latitude,longitude,terrace_progress);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("0");
        beanJsonReturn.setId(id);
        return beanJsonReturn;
    }
    @RequestMapping("/machine/cancellation")
    public BeanJsonReturn cancellation(String id,String remark){
        machineInstallMapper.cancellation(id,remark);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("0");
        beanJsonReturn.setId(id);
        return beanJsonReturn;
    }
    @RequestMapping("/machine/terrace")
    public BeanJsonReturn terrace(String id){
        Map<String, String> getterrace = machineInstallMapper.getterrace(id);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("0");
        beanJsonReturn.setParamMap(getterrace);
        return beanJsonReturn;
    }
    @RequestMapping("/machine/updateterrace")
    public BeanJsonReturn updateterrace(String id,String terracestep,String remark,String step){
         machineInstallMapper.updateterrace(id,terracestep,remark,step);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("0");

        return beanJsonReturn;
    }

    @RequestMapping("/machine/order")
    public BeanJsonReturn getorder(String orderno){
        Map<String,String> getorder = machineInstallMapper.getorder(orderno);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("0");
        beanJsonReturn.setParamMap(getorder);
        return beanJsonReturn;
    }
    @RequestMapping("/machine/detail")
    public BeanJsonReturn getdtail(String orderno){
        Map<String,String> getorder = machineInstallMapper.getdtail(orderno);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("0");
        beanJsonReturn.setParamMap(getorder);
        return beanJsonReturn;
    }
    @RequestMapping("/machine/debug")
    public BeanJsonReturn updatedebug(String id,String remark,String machineno){
         machineInstallMapper.updatedebug(id,remark,machineno);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("0");
        return beanJsonReturn;
    }
    @RequestMapping("/machine/install")
    public BeanJsonReturn updateinstall(String id,String remark){
        machineInstallMapper.updateinstall(id,remark);
        BeanJsonReturn beanJsonReturn=new BeanJsonReturn();
        beanJsonReturn.setErrcode("0");
        return beanJsonReturn;
    }

}
