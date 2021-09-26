package svc;
import static db.JdbcUtil.*;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.IceDAO;
import vo.Ice;

public class IceViewService {

	public Ice getIce(int id) {
		// 조회수 ㅡㅡ

		// 1.커넥션 풀에서 Connection객체 얻어와
		Connection con = getConnection();
		// 2.싱글톤 패턴:DogDAO객체 생성
		IceDAO iceDAO = IceDAO.getInstance();
		// 3.DB작업에 사용될 Connection객체를 DogDAO의 멤버변수로 삽입하여 DB 연결
		iceDAO.setConnection(con);

		int updateCount = iceDAO.updateReadCount(id);
		if(updateCount > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		//id로 조회한 아이스크림 정보를 객체반환할라면 먼저 DAO에 가서 만들어야한다
		Ice ice = iceDAO.selectIec(id);
		return null;

	}

}
