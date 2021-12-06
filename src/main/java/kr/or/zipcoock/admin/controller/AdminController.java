package kr.or.zipcoock.admin.controller;

import java.io.Console;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.table.model.vo.AdminDeal;
import kr.or.table.model.vo.AdminQna;
import kr.or.table.model.vo.AdminRefund;
import kr.or.table.model.vo.HomecookDeal;
import kr.or.table.model.vo.Member;
import kr.or.table.model.vo.Qna;
import kr.or.zipcoock.admin.model.service.AdminService;



@Controller
public class AdminController 
{
	@Autowired
	private AdminService service;
	

	@RequestMapping(value = "/getAllMemberList.do")
	@ResponseBody
	public ArrayList<Member> get_AllMemberList()
	{		
		return service.selectAllMember();
	}
	
	@RequestMapping(value = "/getAllQnaList.do")
	@ResponseBody
	public ArrayList<AdminQna> get_AllQnaList()
	{		
		return service.selectAllQna();
	}
	
	@RequestMapping(value = "/getAllHomecookDeal.do")
	@ResponseBody
	public ArrayList<AdminDeal> get_AllHomecookDeal()
	{		
		return service.selectAllHomecookDeal();
	}
	
	@RequestMapping(value = "/getAllRefund.do")
	@ResponseBody
	public ArrayList<AdminRefund> get_AllRefund()
	{		
		return service.selectAllRefund();
	}
	
	
	@RequestMapping(value = "/admin_MemberInfo.do")
	public String call_MemberInfo(int memberNo, Model model)
	{		
		Member m = service.selectOneMemberInfo(memberNo);
		model.addAttribute("m", m);
		
		return "admin/adminMemberInfo";
	}
	
	@RequestMapping(value = "/Fix_MemberInfo.do")
	@ResponseBody
	public int fix_MemberInfo(int memberNo, String memberName, String memberLevel, String memberDLevel, String memberPhone)
	{		
		
		Member m = new Member();
		
		m.setMemberNo(memberNo);
		m.setMemberName(memberName);
		m.setMemberLevel(memberLevel);
		m.setDeliveryLevel(memberDLevel);
		m.setMemberPhone(memberPhone);
		
		return service.updateMemberInfo(m);
	}	
	
}
