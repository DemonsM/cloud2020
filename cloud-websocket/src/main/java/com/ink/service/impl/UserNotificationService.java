package com.ink.service.impl;

import com.ink.domain.UserNotification;

public interface UserNotificationService {


    int insertSelective(UserNotification record);

    int updateByPrimaryKeySelective(UserNotification record);

}
