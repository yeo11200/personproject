package com.sin1.member.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sin1.member.dto.LoginDTO;
import com.sin1.member.dto.MemberDTO;

@Repository
public class memberDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private final String NAME_SPACE = "com.sin1.mapper.MemberMapper.";
	
	public void join(MemberDTO dto) {
		sqlSession.insert(NAME_SPACE+"join", dto);
	}
	
	public LoginDTO login(String id, String pw) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		return sqlSession.selectOne(NAME_SPACE+"login", map);
	}
	
	public MemberDTO searchId(String email, String name, String tel, String gender) {
		System.out.println();
		Map<String, String> map = new HashMap<>();
		map.put("email", email);
		map.put("name", name);
		map.put("tel", tel);
		map.put("gender", gender);
		
		return sqlSession.selectOne(NAME_SPACE+"searchId", map);
	}
	public String findId(String id) {
		return sqlSession.selectOne(NAME_SPACE+"findId", id);
	}
	public String chkId(String id) {
		return sqlSession.selectOne(NAME_SPACE+"chkId", id);
	}

	public MemberDTO middleSerchPw(String id, String tel, String email) {
		// TODO Auto-generated method stub
		System.out.println(id+tel+email);
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("tel", tel);
		map.put("email", email);
		return sqlSession.selectOne(NAME_SPACE+"middleSerchPw", map);
	}

	public void finalSearchPw(String pw,String id, String tel, String email) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("tel", tel);
		map.put("email", email);
		map.put("pw", pw);
		sqlSession.update(NAME_SPACE+"updatePw", map);
	}

	public void chagePw(String id, String pw, String newPw) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		map.put("newPw", newPw);
		
		System.out.println(newPw);
		sqlSession.update(NAME_SPACE+"chagePw", map);
	}

	public MemberDTO view(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAME_SPACE+"view", id);
	}

	public void update(MemberDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.update(NAME_SPACE+"update", dto);
	}
}
