package com.ink.service.impl;

import com.ink.domain.Notification;

public interface NotificationService {


    int insertSelective(Notification record);

    int updateByPrimaryKeySelective(Notification record);

}
