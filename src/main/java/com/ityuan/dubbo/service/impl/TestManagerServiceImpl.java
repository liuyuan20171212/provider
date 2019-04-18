/**
 * Chengzai.com Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.ityuan.dubbo.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ityuan.dubbo.dao01.UserMapper;
import com.ityuan.dubbo.dao02.UserMapper02;
import com.ityuan.dubbo.dataobject.User;
import com.ityuan.dubbo.facade.TestManagerService;

/**
 *
 * @author ityuan
 * @version $Id: TestManagerServiceimpl, v 0.1 2019-02-27 11:37 ityuan Exp $
 */
@Service(version = "1.0.0")
@org.springframework.stereotype.Service
public class TestManagerServiceImpl implements TestManagerService {
    @Autowired
    private UserMapper   mapper1;

    @Autowired
    private UserMapper02 mapper02;

    @Override
    public String test01(String a) {
        User user = new User(5, "liuyuan", "565897", "13866059341");
        mapper1.insert(user);
        mapper02.insert(user);
        return "你好！a=" + a;
    }
}
