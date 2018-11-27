package com.sin1.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sin1.member.dto.LoginDTO;
import com.sin1.member.dto.MemberDTO;

@Repository
public class NoticeMemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private final String NAME_SPACE = "com.sin1.mapper.NoticeMemberMapper.";
	
	public List<MemberDTO> list(){
		return sqlSession.selectList(NAME_SPACE+"list");
	}
	
	public MemberDTO view(String id) {
		return sqlSession.selectOne(NAME_SPACE+"view", id);
	}
	
	public void updateGrade(String id) {
		sqlSession.update(NAME_SPACE+"updateGrade", id);
	}
	
	public void delectMember(String id) {
		sqlSession.update(NAME_SPACE+"deleteMember", id);
	}

	public List<MemberDTO> deletelist() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAME_SPACE+"deletelist");//pageObject
	}
	
	public void updateDeleteMember(String id) {
		sqlSession.update(NAME_SPACE+"updateDeleteMember", id);
	}
}
