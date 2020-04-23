package com.evack.els.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.evack.els.model.Relation;

@Mapper
public interface RelationMapper {
	@Select("select * from relation")
	public List<Relation> getAllRelation();
	
	@Select("select courseID from relation where stuID=#{stuID}")
	public List<Integer> getCourseByStu(Integer stuID);
}
