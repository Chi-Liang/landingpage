package com.hanye.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hanye.info.service.GroceryService;
import com.hanye.info.vo.GroceryItemVo;

@Controller
@RequestMapping("/auth/grocery")
public class GroceryController {
	
	@Autowired
	private GroceryService groceryService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("groceryItemList", groceryService.findAllGroceryItem());
		return "grocery/list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		GroceryItemVo grocery = new GroceryItemVo();
		model.addAttribute("grocery", grocery);
		
		return "grocery/add";
	}
	
	@PostMapping("/addSubmit")
	public String addSubmit(@ModelAttribute GroceryItemVo groceryItemVo) {	
		groceryService.saveGroceryItem(groceryItemVo);
		return "redirect:/auth/grocery/list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam String id, Model model) {
		model.addAttribute("grocery", groceryService.findGroceryItem(id));
		return "grocery/edit";
	}
	
	@PostMapping("/editSubmit")
	public String editSubmit(@ModelAttribute GroceryItemVo GroceryItemVo) {	
		groceryService.editGroceryItem(GroceryItemVo);
		return "redirect:/auth/grocery/list";
	}
	
	@PostMapping("/delSubmit")
	public String delSubmit(@RequestParam String id) {
		groceryService.deleteGroceryItem(id);
		return "redirect:/auth/grocery/list";
	}
}
