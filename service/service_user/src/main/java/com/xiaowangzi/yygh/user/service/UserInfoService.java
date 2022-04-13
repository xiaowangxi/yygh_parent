package com.xiaowangzi.yygh.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaowangzi.yygh.model.user.UserInfo;
import com.xiaowangzi.yygh.vo.user.LoginVo;
import com.xiaowangzi.yygh.vo.user.UserAuthVo;

import java.util.Map;

public interface UserInfoService extends IService<UserInfo> {
    //会员登录
    Map<String, Object> login(LoginVo loginVo);

    UserInfo selectWxInfoOpenId(String openId);

    void userAuth(Long userId, UserAuthVo userAuthVo);
}
