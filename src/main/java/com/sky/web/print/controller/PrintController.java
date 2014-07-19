package com.sky.web.print.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/print")
public class PrintController {
	
//	@RequestMapping
	public String setPrintTemplate(Model model, HttpSession session) {
		System.out.println("<<<<<<<<<<<<<<"+ session.getAttribute("username"));
//		model.addAttribute("expList", expList());
		
		return "setprinttemplate";
	}
	
	@RequestMapping("listExpComp")
	@ResponseBody
	public List<Map<String, String>> listExpComp() {
		
		List<Map<String, String>> expcomps = new ArrayList<Map<String, String>>();
		
		Map<String, String> sf = new HashMap<String, String>();
		sf.put("compId", "1001");
		sf.put("compName", "顺丰速运(SF)");
		expcomps.add(sf);
		
		Map<String, String> zto = new HashMap<String, String>();
		zto.put("compId", "1502");
		zto.put("compName", "中通快递(ZTO)");
		expcomps.add(zto);
		
		Map<String, String> yto = new HashMap<String, String>();
		yto.put("compId", "1501");
		yto.put("compName", "圆通速递(YTO)");
		expcomps.add(yto);
		
		Map<String, String> yund = new HashMap<String, String>();
		yund.put("compId", "1504");
		yund.put("compName", "韵达快递(YUNDA)");
		expcomps.add(yund);
		
		return expcomps;
	}
	
	@ModelAttribute("expList")
	public Map<Long, String> expList() {
		Map<Long, String> expList = new HashMap<Long, String>();
		
		expList.put(1001L, "顺丰速递(SF)");
		expList.put(1054L, "圆通快递(YTO)");
		
		return expList;
	}
	
}
