package com.xiaowangzi.yygh.cmn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaowangzi.yygh.model.cmn.Dict;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface DictService extends IService<Dict> {
    //根据数据id查询子数据列表
    List<Dict> findChlidData(Long id);

    /**
     * 导出
     *
     * @param response
     */
    void exportData(HttpServletResponse response);

    void importDictData(MultipartFile file);
}

