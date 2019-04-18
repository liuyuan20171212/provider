/**
 * Chengzai.com Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.ityuan.dubbo.dao01;

import com.ityuan.dubbo.dataobject.User;

/**
 *
 * @author ityuan
 * @version $Id: UserMapper, v 0.1 2019-03-01 12:11 ityuan Exp $
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
