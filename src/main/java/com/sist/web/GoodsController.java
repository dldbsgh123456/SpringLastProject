package com.sist.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.service.GoodsService;
import com.sist.vo.FoodVO;
import com.sist.vo.GoodsVO;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class GoodsController {
	private final GoodsService gService;
	
	@GetMapping("goods/main.do")
	public String goods_main(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		final int ROWSIZE=12;
		int start=(ROWSIZE*curpage)-(ROWSIZE-1);
		
		List<GoodsVO> list=gService.goodsListData(start);
		int totalpage=gService.goodsTotalData();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
	     model.addAttribute("list",list);
	   	 model.addAttribute("curpage",curpage);
	   	 model.addAttribute("startPage",startPage);
	   	 model.addAttribute("endPage",endPage);
	   	 model.addAttribute("totalpage",totalpage);	   	 
	   	 model.addAttribute("main_jsp","../goods/home.jsp");
	   	 return "goods/main";
	}
	
	@GetMapping("goods/detail.do")
	public String goods_detail(int no,Model model)
	{
		GoodsVO vo=gService.goodsDetail(no);
	  	  model.addAttribute("vo",vo);
	  	  model.addAttribute("main_jsp","../goods/detail.jsp");
	  	  return "goods/main";
	}
	
	
}
