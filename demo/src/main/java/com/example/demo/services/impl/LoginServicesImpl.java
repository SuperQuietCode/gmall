package com.example.demo.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.DO.UserDO;
import com.example.demo.VO.UserVO;
import com.example.demo.base.ResultStat;
import com.example.demo.config.RedisKeys;
import com.example.demo.Dao.UserInfoDao;
import com.example.demo.services.LoginServices;
import com.example.demo.util.EmptyUtil;
import com.example.demo.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户登录
 *
 * @author ZhaoXin
 * @date 2020/9/25 13:45
 */
@Service
public class LoginServicesImpl implements LoginServices {

    @Resource
    private UserInfoDao userInfoDao;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public ResultStat loginCheck(UserVO user) {
        if (EmptyUtil.isEmpty(user.getUserName()) ||
                EmptyUtil.isEmpty(user.getPassWord())) {
            return ResultStat.PAYLOAD_MISS;
        }
        String key = RedisKeys.USERINFO.getKey() + user.getUserName();

        // 如果redis查询到数据
        if(redisUtil.hasKey(key)){
            return ResultStat.SUCCESS;
        }else {
            UserDO userDO = userInfoDao.selectOne(new QueryWrapper<UserDO>().lambda()
                    .eq(UserDO::getUserName, user.getUserName())
                    .eq(UserDO::getPassWord, user.getPassWord()));
            if (EmptyUtil.isEmpty(userDO)) {
                return ResultStat.ERROR;
            } else {
                redisUtil.set(key, user.getPassWord());
                return ResultStat.SUCCESS;
            }
        }
    }
}
