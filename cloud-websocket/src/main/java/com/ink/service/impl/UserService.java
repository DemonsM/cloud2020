package com.ink.service.impl;

import com.ink.domain.User;

public interface UserService {


    int insertSelective(User record);

    int updateByPrimaryKeySelective(User record);

}
