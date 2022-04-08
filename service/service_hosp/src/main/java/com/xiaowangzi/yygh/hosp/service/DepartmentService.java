package com.xiaowangzi.yygh.hosp.service;

import com.xiaowangzi.yygh.model.hosp.Department;
import com.xiaowangzi.yygh.vo.hosp.DepartmentQueryVo;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface DepartmentService {
    /**
     * 上传科室信息
     *
     * @param paramMap
     */
    void save(Map<String, Object> paramMap);

    /**
     * 分页查询
     *
     * @param page              当前页码
     * @param limit             每页记录数
     * @param departmentQueryVo 查询条件
     * @return
     */
    Page<Department> selectPage(Integer page, Integer limit, DepartmentQueryVo departmentQueryVo);

    /**
     * 删除科室
     *
     * @param hoscode
     * @param depcode
     */
    void remove(String hoscode, String depcode);
}
