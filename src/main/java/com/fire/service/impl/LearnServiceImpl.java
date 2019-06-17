package com.fire.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.dao.LearnResourceMapper;
import com.fire.domain.LearnResource;
import com.fire.model.LeanQueryLeanListReq;
import com.fire.service.LearnService;
import com.fire.util.Page;
import com.github.pagehelper.PageHelper;

/**
 * Created by tengj on 2017/4/7.
 */
@Service
public class LearnServiceImpl extends BaseService<LearnResource>  implements LearnService {

    @Autowired
    private LearnResourceMapper  learnResourceMapper;

    @Override
    public void deleteBatch(Long[] ids) {
        Arrays.stream(ids).forEach(id->learnResourceMapper.deleteByPrimaryKey(id));
    }

    @Override
    public List<LearnResource> queryLearnResouceList(Page<LeanQueryLeanListReq> page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        return learnResourceMapper.queryLearnResouceList(page.getCondition());
    }
}
