package com.xiaowangzi.yygh.msm.service;

import com.xiaowangzi.yygh.vo.msm.MsmVo;

public interface MsmService {
    //发送手机验证码
    boolean send(String phone, String code);
    //MQ发送手机验证码
    boolean send(String phone);
}
