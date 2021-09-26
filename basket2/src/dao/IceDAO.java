package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Ice;

public class IceDAO {
	// 멤버변수(전역변수 : 전체 메서드에서 사용가능)
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 싱글톤 패턴 : CartDAO객체 1개 생성 후 객체를 공유하기 위해서
	public IceDAO() {
		// TODO 자동 생성된 생성자 스텁
	}

	private static IceDAO iceDAO;

	public static IceDAO getInstance() {
		if (iceDAO == null) { // 객체가 없으면
			iceDAO = new IceDAO(); // 객체생성
		}
		return iceDAO;// 기존 객체 리턴
	}

	public void setConnection(Connection con) {// Connection객체를 받아 DB연결하고
		this.con = con;

	}

	// 1. 모든 베라 상품 조회 하기 ArrayList<ice>객체 반환
	public ArrayList<Ice> selectIecList() {
		ArrayList<Ice> iceList = null;

		try {
			pstmt = con.prepareStatement("select * from ice");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				iceList = new ArrayList<Ice>();

				do {
					Ice ice = new Ice(rs.getInt("id"),
							rs.getString("name"),
							rs.getString("kind"),
							rs.getString("country"),
							rs.getInt("price"),
							rs.getString("image"),
							rs.getInt("readcount"),
							rs.getInt("count"));

					iceList.add(ice);
				} while (rs.next());
			}
		} catch (SQLException e) {
			System.out.println("select 오류 " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return iceList;
	}

	// id로 아이스크림 상세 보기
	public int updateReadCount(int id) {
		String sql = "update ice set readcount=readcount+1 where id=" + id;
		int updateCount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();// 성공하면 1리턴
		} catch (SQLException e) {
			System.out.println("id로 아이스크림 상세보기 오류 " + e);
		} finally {
			close(con);
			close(pstmt);
		}

		return updateCount;
	}

	// id로 아이스크림 조회하고 ice객체반환
	public Ice selectIec(int id) {
		Ice ice = null;

		try {
			pstmt = con.prepareStatement("select * from ice where id=" + id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				 ice = new Ice(rs.getInt("id"),
						 rs.getString("name"),
						rs.getString("kind"),
						rs.getString("country"),
						rs.getInt("price"),
						rs.getString("image"),
						rs.getInt("readcount"),
						rs.getInt("count"));
			}
		} catch (SQLException e) {
			System.out.println("id로 조회 오류 " + e);
		}finally {
			close(con);
			close(pstmt);
		}
		return ice;
	}
}
