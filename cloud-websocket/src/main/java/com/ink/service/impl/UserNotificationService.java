package com.ink.service.impl;

import com.ink.domain.UserNotification;

import java.util.List;

public interface UserNotificationService {


    int insertSelective(UserNotification record);

    int updateByPrimaryKeySelective(UserNotification record);

    int updateBatchSelective(List<UserNotification> list);
}

