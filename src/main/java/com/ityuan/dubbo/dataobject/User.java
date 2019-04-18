/**
 * Chengzai.com Inc.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.ityuan.dubbo.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author ityuan
 * @version $Id: User, v 0.1 2019-03-01 12:03 ityuan Exp $
 */
@Data
@AllArgsConstructor
public class User {
    private Integer userId;
    private String  userName;
    private String  password;
    private String  phone;
}
