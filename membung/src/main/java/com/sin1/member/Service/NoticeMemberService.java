package com.sin1.member.Service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.sin1.member.dao.NoticeMemberDAO;
import com.sin1.member.dao.memberDAO;
import com.sin1.member.dto.LoginDTO;
import com.sin1.member.dto.MemberDTO;

@Service
public class NoticeMemberService {
	@Inject
	private NoticeMemberDAO dao;
	
	public List<MemberDTO> list(){
		return dao.list();
	}
	
	public MemberDTO view(String id) {
		return dao.view(id);
	}
	
	public void updateGrade(String id) {
		dao.updateGrade(id);
	}
	
	public void deleteMember(String id) {
		dao.delectMember(id);
	}

	public List<MemberDTO> deletelist() {//pageObject 처리
		return dao.deletelist();//pageObject 처리
		// TODO Auto-generated method stub
	}
	
	public void updateDeleteMember(String id) {
		dao.updateDeleteMember(id);
	}
}
