package com.ityuan.dubbo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ityuan.dubbo.dao01.UserMapper;
import com.ityuan.dubbo.dao02.UserMapper02;
import com.ityuan.dubbo.dataobject.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProviderApplicationTests {
    @Autowired
    private UserMapper   mapper1;

    @Autowired
    private UserMapper02 mapper02;

    @Test
    @Transactional(value = "test1TransactionManager", rollbackFor = Exception.class)
    public void contextLoads() {
        User user = new User(5, "liuyuan", "565897", "13866059341");
        mapper1.insert(user);
        //        mapper02.insert(user);
        System.out.println(user);
    }

}
