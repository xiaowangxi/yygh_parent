package com.xiaowangzi.yygh.hosp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaowangzi.yygh.common.exception.YyghException;
import com.xiaowangzi.yygh.common.result.ResultCodeEnum;
import com.xiaowangzi.yygh.hosp.mapper.HospitalSetMapper;
import com.xiaowangzi.yygh.hosp.service.HospitalSetService;
import com.xiaowangzi.yygh.model.hosp.HospitalSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet> implements HospitalSetService {
    @Override
    public String getSignKey(String hoscode) {
        HospitalSet hospitalSet = this.getByHoscode(hoscode);
        if (null == hospitalSet) {
            throw new YyghException(ResultCodeEnum.HOSPITAL_OPEN);
        }
        if (hospitalSet.getStatus().intValue() == 0) {
            throw new YyghException(ResultCodeEnum.HOSPITAL_LOCK);
        }
        return hospitalSet.getSignKey();
    }

    /**
     * 根据hoscode获取医院设置
     *
     * @param hoscode
     * @return
     */
    private HospitalSet getByHoscode(String hoscode) {
        return baseMapper.selectOne(new QueryWrapper<HospitalSet>().eq("hoscode", hoscode));
    }

}
