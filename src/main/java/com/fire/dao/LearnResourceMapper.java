package com.fire.dao;

import java.util.List;
import java.util.Map;

import com.fire.domain.LearnResource;
import com.fire.util.MyMapper;

public interface LearnResourceMapper extends MyMapper<LearnResource>{
	
	List<LearnResource> queryLearnResouceList(Map<String,Object> map);
}
