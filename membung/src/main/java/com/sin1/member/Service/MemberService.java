package com.sin1.member.Service;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sin1.member.dao.memberDAO;
import com.sin1.member.dto.LoginDTO;
import com.sin1.member.dto.MemberDTO;

@Service
public class MemberService {
	@Inject
	private memberDAO dao;
	@Inject
	private PasswordEncoder passwordEncoder;
	
	public void join(MemberDTO dto) {
		String encPass = passwordEncoder.encode(dto.getPw());
		//pw = passwordEncoder.encode(pw);
		dto.setPw(encPass);
		dao.join(dto);
	}
	
	public LoginDTO login(String id, String pw) {
		System.out.println(dao.login(id, pw));
		return dao.login(id, pw);
	}
	
	public void chagePw(String id, String pw, String newPw) {
		newPw = passwordEncoder.encode(newPw);
		System.out.println(newPw);
		dao.chagePw(id, pw, newPw);
	}
	public MemberDTO searchId(String email, String name, String tel, String gender) {
		System.out.println(email+ name+ tel+ gender);
		return dao.searchId(email, name, tel, gender);
	}
	public String findId(String id) {
		return dao.findId(id);
	}
	
	public String chkId(String id) {
		return dao.chkId(id);
	}

	public MemberDTO middleSerchPw(String id, String tel, String email) {
		// TODO Auto-generated method stub
		System.out.println(id+tel+email);
		return dao.middleSerchPw(id, tel, email);
	}

	public void finalSearchPw(String pw,String id, String tel, String email) {
		// TODO Auto-generated method stub
		pw = passwordEncoder.encode(pw);
		dao.finalSearchPw(pw, id, tel, email);
	}

	public MemberDTO view(String id) {
		// TODO Auto-generated method stub
		return dao.view(id);
	}

	public void update(MemberDTO dto) {
		// TODO Auto-generated method stub
		dao.update(dto);
	}
}
