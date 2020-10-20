package net.cuscatlan.sfcrecipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Renato Oswaldo Bonilla (rBonilla) el día Oct 13, 2020
 *
 */
@Controller
@RequestMapping({"","/"})
public class IndexController {
	
	@GetMapping({"","/","/index"})
	String myIndex(Model model) {
		model.addAttribute("title", "Recetas App!");
		return "index";
	}

}
