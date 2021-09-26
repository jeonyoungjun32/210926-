package vo;

public class ActionForward {
	// Controller에서 요청어리 후 포워딩 될 죄즁 뷰 페이지 URI이 저장
	private String path = null;

	// 포워딩 방식 저장. false이면 디스패치(기존요청), true이면 리다이렉트(새요청)
	private boolean isRedirect = false;

	// 매개변수가 없는 생성자 - 수동으로 만들기
	public ActionForward() {
	}

	public ActionForward(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

}
