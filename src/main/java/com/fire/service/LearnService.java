package com.fire.service;

import java.util.List;

import com.fire.domain.LearnResource;
import com.fire.model.LeanQueryLeanListReq;
import com.fire.util.Page;

/**
 * nn
 */

public interface LearnService  extends IService<LearnResource>{
    public List<LearnResource> queryLearnResouceList(Page<LeanQueryLeanListReq> page);
    public void deleteBatch(Long[] ids);
}
