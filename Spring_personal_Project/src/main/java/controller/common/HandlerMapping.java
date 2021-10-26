package controller.common;

import java.util.HashMap;
import java.util.Map;

import controller.action.DeleteBoardController;
import controller.action.EditBoardController;
import controller.action.GoEditBoardController;
import controller.action.InsertBoardController;
import controller.action.JoinMemberController;
import controller.action.LoginController;
import controller.action.LogoutController;
import controller.action.MainController;
import controller.action.ShowPostController;

public class HandlerMapping {
	// 누가 어디로 가야하는지 맵핑을 할것이기 때문에
	// 어떤 명령에 대해 어떤 컨트롤러를 이어줘야할지 명시해야하기때문에
	// Map객체가 필요하다
	private Map<String , Controller> mappings;
	
	// HandlerMapping의 경우 생성자로 초기화
	public HandlerMapping() { // 생성자
		mappings = new HashMap<String , Controller>();
		// ** 요청이 들어올때마다 변경,추가 되는 곳은 여기! **
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/main.do", new MainController());
		mappings.put("/newpost.do", new InsertBoardController());
		mappings.put("/goeditBoard.do", new GoEditBoardController());
		mappings.put("/updatepost.do", new EditBoardController());
		mappings.put("/deletepost.do", new DeleteBoardController());
		mappings.put("/showpost.do", new ShowPostController());
		mappings.put("/joinMember.do", new JoinMemberController());

		
		// *******************************
	}
	// URL 요청을 인자로 받아서 Controller객체를 반환 
	
	public Controller getController(String path) {
		// 어떤 요청이 왔는지 알려주면 컨트롤러를 리턴한다
		return mappings.get(path);
	}
}
