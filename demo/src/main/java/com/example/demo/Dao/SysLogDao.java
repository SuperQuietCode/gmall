package com.example.demo.Dao;

import com.example.demo.DO.SysLogDO;

/**
 * @author ZhaoXin
 * @date 2021/6/9 16:22
 */
public interface SysLogDao {
    int insertSelective(SysLogDO sysLogDO);
}
