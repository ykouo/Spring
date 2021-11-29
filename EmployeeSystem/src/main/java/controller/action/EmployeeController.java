package controller.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.employee.EmployeeService;
import model.employee.EmployeeVO;



@Controller
public class EmployeeController {
	
	@ModelAttribute("sm")
	public Map<String,String> searchMap(){
		Map<String,String> sm=new HashMap<String,String>();
		sm.put("num", "num");
		sm.put("ename", "ename");
		sm.put("grade", "grade");
		sm.put("phone", "phone");
		sm.put("email", "email");
		return sm;
	}
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/main.do")
	public String getAllEmployeeList(HttpServletRequest request,EmployeeVO vo,Model model) throws IllegalStateException, IOException{
		List<EmployeeVO> employeeList = employeeService.getAllEmployeeList(vo);
		model.addAttribute("employeeList", employeeList);		
		return "main.jsp";
	}
	@RequestMapping("/searchEmployee.do")
	public String searchEmployee(HttpServletRequest request,EmployeeVO vo,Model model) throws IllegalStateException, IOException{
		System.out.println("여기!!");
		System.out.println("* vo : "+ vo);
		List<EmployeeVO> employeeList = employeeService.searchEmployeeList(vo);
		System.out.println("employeeList : " + employeeList );
		if(vo.getCondition() == null) {
			vo.setCondition("num");
		}
		if(vo.getKeyword() == null) {
			vo.setKeyword("");
		}
		model.addAttribute("employeeList", employeeList);
		return "main.jsp";
	}
	@RequestMapping("/insertEmployee.do")
	@ResponseBody
	public String insertEmployee(HttpServletRequest request,EmployeeVO vo) throws IllegalStateException, IOException{
		employeeService.insertEmployee(vo);
		return "<script>alert('Complete:D');location.href='main.do';</script>";
	}
	
	@RequestMapping("/goUpdateEmployee.do")
	public String goUpdateEmployee(Model model,@ModelAttribute("employeeData")EmployeeVO vo) throws IllegalStateException, IOException{
		EmployeeVO employeeData = employeeService.getEmployee(vo);
		model.addAttribute("employeeData",employeeData);	
		return "updateEmployee.jsp?num="+employeeData.getNum();
	}
	
	@RequestMapping("/updatingEmployee.do")
	@ResponseBody
	public String updatingEmployee(EmployeeVO vo) throws IllegalStateException, IOException{
		System.out.println("업데이트" + vo);
		employeeService.updateEmployee(vo);	
		return "<script>alert('Updating Complete:D');location.href='main.do';</script>";
	}
	@RequestMapping("/deleteEmployee.do")
	public String deleteEmployee(EmployeeVO vo) throws IllegalStateException, IOException{
		employeeService.deleteEmployee(vo);
		return "main.do";
	}	
	
}
