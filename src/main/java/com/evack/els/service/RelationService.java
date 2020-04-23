package com.evack.els.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evack.els.mapper.RelationMapper;
import com.evack.els.model.Relation;

@Service
public class RelationService {
	@Autowired
	RelationMapper relationMapper;
	
	public List<Relation> relationList(){
		return relationMapper.getAllRelation();
	}
	
	public List<Integer> getCourseByStu(Integer stuID) {
		return relationMapper.getCourseByStu(stuID);
	}
}
