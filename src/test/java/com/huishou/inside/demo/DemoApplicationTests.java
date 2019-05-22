package com.huishou.inside.demo;

import com.huishou.inside.demo.mapper.MachineInstallMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    MachineInstallMapper machineInstallMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void contextLoads() {



    }

}

