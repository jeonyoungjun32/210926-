package svc;

import static db.JdbcUtil.*; //이거 안넣으면 getCoonection, close가 안된다

import java.sql.Connection;
import java.util.ArrayList;

import dao.IceDAO;
import vo.Ice;

public class IceListService {

	public ArrayList<Ice> getIceList() {
		// 1.커넥션 풀에서 Connection객체 얻어와
		Connection con = getConnection();
		// 2.싱글톤 패턴:DogDAO객체 생성
		IceDAO iceDAO = IceDAO.getInstance();
		// 3.DB작업에 사용될 Connection객체를 DogDAO의 멤버변수로 삽입하여 DB 연결
		iceDAO.setConnection(con);

		/*----DogDAO의 해당 메서드를 호출하여 처리-------------------*/
		//ArrayList<Ice> dogList = IceDAO.selectIecList();
		ArrayList<Ice> iceList =  iceDAO.selectIecList();

		/*-(update,delete,insert)성공하면 commit 실패하면 rollback
		 * (select제외)----*/

		// 4.해제
		close(con);// Connection객체 해제

		return null;
		//return dogList;

	}
}
