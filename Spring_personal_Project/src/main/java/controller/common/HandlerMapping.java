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
	// ���� ���� �����ϴ��� ������ �Ұ��̱� ������
	// � ��ɿ� ���� � ��Ʈ�ѷ��� �̾�������� ����ؾ��ϱ⶧����
	// Map��ü�� �ʿ��ϴ�
	private Map<String , Controller> mappings;
	
	// HandlerMapping�� ��� �����ڷ� �ʱ�ȭ
	public HandlerMapping() { // ������
		mappings = new HashMap<String , Controller>();
		// ** ��û�� ���ö����� ����,�߰� �Ǵ� ���� ����! **
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
	// URL ��û�� ���ڷ� �޾Ƽ� Controller��ü�� ��ȯ 
	
	public Controller getController(String path) {
		// � ��û�� �Դ��� �˷��ָ� ��Ʈ�ѷ��� �����Ѵ�
		return mappings.get(path);
	}
}
