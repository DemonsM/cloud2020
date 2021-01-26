package com.ink.mapper;

import com.ink.domain.UserNotification;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserNotificationMapper {
    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserNotification record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserNotification record);
}
