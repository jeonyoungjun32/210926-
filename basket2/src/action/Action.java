package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public interface Action {

	//추상 케서드 : 반드시 자식클래스에서 재정의해야 함
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
}
