package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.IceViewService;
import vo.ActionForward;
import vo.Ice;

public class IceViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 1개 클릭 했을때 보여주는거
		IceViewService iceViewService = new IceViewService(); 
		
		//조회수 1증가 
		int id = Integer.parseInt(request.getParameter("id"));
		
		Ice ice = iceViewService.getIce(id);
		
		//request영역에 아이스크림 하나 정보를 담고 객체 공유
		request.setAttribute("ice", ice);
		
		//★혜-753p-두번째 그림(iceList.jsp) : "오늘본 아이스크림 상품 목록" 정보를 알기 위해서는 '아이스크림 하나의 상세정보 보기'를 한 후
		Cookie todayImageCookie = new Cookie("today"+id, ice.getImage()); 
		
		todayImageCookie.setMaxAge(24);
		response.addCookie(todayImageCookie);//반드시 응답에 쿠키 객체 추가!!!
		
		ActionForward forward = new ActionForward("iceView", false);
		return forward;
	}

}
