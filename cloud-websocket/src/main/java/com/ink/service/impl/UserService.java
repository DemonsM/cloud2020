package com.ink.service.impl;

import com.ink.domain.User;

import java.util.List;

public interface UserService {


    int insertSelective(User record);

    int updateByPrimaryKeySelective(User record);

    int updateBatchSelective(List<User> list);
}

