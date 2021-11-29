package controller.action;

import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.employee.EmployeeService;
import model.employee.EmployeeVO;
import model.mail.MailVO;


@Controller

public class MailController {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/goSendEmail.do")
	public String goSendEmail(Model model,@ModelAttribute("employeeData")EmployeeVO vo) throws IllegalStateException, IOException{
		EmployeeVO employeeData = employeeService.getEmployee(vo);
		model.addAttribute("employeeData",employeeData);	
		return "emailSend.jsp?email="+employeeData.getEmail();
	}
	@RequestMapping("/sendMail.do") 
	@ResponseBody
	public String sendMail(MailVO vo,EmployeeVO evo,Model model) { 
		System.out.println("메일보내기 vo :" + vo);
		
		try { 
			String from = vo.getFrom();
			String subject = vo.getSubject();
			String to = vo.getTo();
			String content = vo.getContent();

			MimeMessage message = mailSender.createMimeMessage(); 
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8"); 
			messageHelper.setTo(to); 
			String htmlStr = "<hr><p>"+content+"</p><hr>";
			messageHelper.setText(htmlStr,true); // html 코드를 읽을수 있도록하는 설정 
			messageHelper.setFrom(from); 
			messageHelper.setSubject(subject); 
		
			mailSender.send(message); 
		}catch(Exception e){ 
			System.out.println(e); 
		} 
		System.out.println("메일보내기 성공!");
		return "<script>alert('MailSuccess:D');location.href='main.do';</script>"; 
	}

	

}