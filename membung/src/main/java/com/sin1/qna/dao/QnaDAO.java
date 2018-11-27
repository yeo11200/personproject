package com.sin1.qna.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sin1.qna.dto.QnaDTO;
import com.sin1.util.PageObject;

@Repository
public class QnaDAO {
	@Inject
	private SqlSession session;
	
	private final String NAME_SPACE = "com.sin1.mapper.QnaMapper.";
	
	// Qna 리스트
	public List<QnaDTO> list(PageObject pageObject){
		return session.selectList(NAME_SPACE+"list", pageObject);
	}
	// Qna 보기
	public QnaDTO view(int no) {
		return session.selectOne(NAME_SPACE+"view", no);
	}
	// Qna 질문 쓰기
	public void questWrite(QnaDTO dto) {
		session.insert(NAME_SPACE+"questWrite", dto);
	}
	// Qna 답변쓰기
	public void answerWrite(QnaDTO dto) {
		session.insert(NAME_SPACE+"answerWrite", dto);
	}
	// Qna 답변 쓰기에서 관련글의 순서번호와 같거나 큰 데이터의 순서 번호를 1 증가 시켜야만 한다.  
	public void increaseOrdNo(QnaDTO dto) {
		session.update(NAME_SPACE+"increaseOrdNo", dto);
	}
	// 질문 업데이트
	public void questUpdate(QnaDTO dto) {
		session.update(NAME_SPACE+"questUpdate", dto);
	}
	// 답변 업데이트
	public void answerUpdate(QnaDTO dto) {
		session.update(NAME_SPACE+"answerUpdate", dto);
	}
	// Qna 삭제
	public void delete(int no) {
		session.delete(NAME_SPACE+"delete", no);
	}
	// Qna 조회수 증가
	
	public int increase(int no) {
		System.out.println(getClass().getSimpleName()+".increase()"); 
		return session.update(NAME_SPACE+"increase", no);
	}
	// Qna 페이지 처리
	public int page(PageObject pageObject) {
		return session.selectOne(NAME_SPACE+"page", pageObject);
// jsp에서 페이지 처리할 때 sql도 연결하고 쿼리문도 작성해야했지만 spring에서는 mybatis와 sqlsession으로 그 소스가 줄어들었다.
// jsp에 페이지 처리
/*		public int count() {
			int cnt = 0;
			
			// 필요한 객체 선언
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null; // select 에서만 필요함
			
			try {
				//1. 드라이버 확인 - 2. 연결
				con = DBUtil.getConnection();
				//3. sql문장 작성
				String sql = " select count(*) from qna ";
				//4. 실행객체 + 데이터 세팅
				pstmt = con.prepareStatement(sql);
				// 5. 실행
				rs = pstmt.executeQuery();
				// 6. 표시 - 데이터 담기
				if(rs != null && rs.next()) {
					cnt = rs.getInt(1);
					
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try{
					//7. 닫기
					DBUtil.close(con, pstmt, rs);
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			return cnt;
			
		} // end of count
*/	}
}
