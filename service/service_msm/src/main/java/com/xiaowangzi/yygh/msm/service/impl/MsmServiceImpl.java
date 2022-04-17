package com.xiaowangzi.yygh.msm.service.impl;

import com.alibaba.excel.util.StringUtils;
import com.xiaowangzi.yygh.msm.help.SendEmailHelper;
import com.xiaowangzi.yygh.msm.service.MsmService;
import com.xiaowangzi.yygh.vo.msm.MsmVo;
import org.springframework.stereotype.Service;

@Service
public class MsmServiceImpl implements MsmService {
    @Override
    public boolean send(String phone, String code) {
        //判断手机号是否为空
        if (StringUtils.isEmpty(phone)) {
            return false;
        }
        // 发送邮件服务,测试期间，邮箱地址写死
        String account = "xiaowangzi96@qq.com";
        if (SendEmailHelper.sendEmail(account, code)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean send(String phone) {
        if (StringUtils.isEmpty(phone)) {
            return false;
        }
        // 发送邮件服务,测试期间，邮箱地址写死
        String account = "xiaowangzi96@qq.com";
        if (SendEmailHelper.sendMessage(account)) {
            return true;
        }
        return false;
    }
}
