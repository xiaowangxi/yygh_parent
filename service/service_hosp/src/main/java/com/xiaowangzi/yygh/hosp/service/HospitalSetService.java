package com.xiaowangzi.yygh.hosp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaowangzi.yygh.model.hosp.HospitalSet;
import com.xiaowangzi.yygh.vo.order.SignInfoVo;

public interface HospitalSetService extends IService<HospitalSet> {
    /**
     * 获取签名key
     *
     * @param hoscode
     * @return
     */
    String getSignKey(String hoscode);

    //获取医院签名信息
    SignInfoVo getSignInfoVo(String hoscode);
}
