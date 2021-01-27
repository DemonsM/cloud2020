package com.ink.service.impl;

import com.ink.domain.Notification;

import java.util.List;

public interface NotificationService {


    int insertSelective(Notification record);

    int updateByPrimaryKeySelective(Notification record);

    int updateBatchSelective(List<Notification> list);
}

