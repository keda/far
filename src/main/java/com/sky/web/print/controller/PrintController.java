package com.sky.web.print.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/print")
public class PrintController {
	
	@RequestMapping
	public String setPrintTemplate(Model model, HttpSession session) {
		System.out.println("<<<<<<<<<<<<<<"+ session.getAttribute("username"));
//		model.addAttribute("expList", expList());
		
		return "setprinttemplate";
	}
	
	@ModelAttribute("expList")
	public Map<Long, String> expList() {
		Map<Long, String> expList = new HashMap<Long, String>();
		
		expList.put(1001L, "顺丰速递(SF)");
		expList.put(1054L, "圆通快递(YTO)");
		
		return expList;
	}
	
}
